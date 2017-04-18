package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CrosswordPuzzle {
	private static int getIndexCurrentLetter(char[][] grid, int i, int j, boolean lookVerticalDirection) {
		int index = 0;
		if (lookVerticalDirection) {
			while (i > 0 && grid[i - 1][j] == '-') {
				index++;
				i--;
			}
			if (i > 0 && grid[i - 1][j] != '+') {
				index = -1;
			}
		} else {
			while (j > 0 && grid[i][j - 1] == '-') {
				index++;
				j--;
			}
			if (j > 0 && grid[i][j - 1] != '+') {
				index = -1;
			}
		}
		return index;
	}

	private static List<String> getPossibleWords(String[] words, Set<String> set, char character, int characterIndex) {
		List<String> possibleWords = new ArrayList<String>(words.length - 1);
		for (int i = 0; i < words.length; i++) {
			if (words[i].charAt(characterIndex) == character && !set.contains(words[i])) {
				possibleWords.add(words[i]);
			}
		}
		return possibleWords;
	}

	private static boolean fillGrid(Set<String> set, String[] words, char[][] grid, String word, int character, int i,
			int j, boolean verticalDirection) {

		if (character >= word.length())
			return true;
		if (i >= 10 || j >= 10)
			return false;

		grid[i][j] = word.charAt(character);

		boolean filled = false;
		boolean changeDirection = false;
		if (verticalDirection) {
			changeDirection = (j == 0 && grid[i][j + 1] == '-') || (j == grid.length - 1 && grid[i][j - 1] == '-')
					|| (j > 0 && j < grid.length - 1 && grid[i][j - 1] == '-' && grid[i][j + 1] == '-')
					|| (j > 0 && j < grid.length - 1 && grid[i][j - 1] == '+' && grid[i][j + 1] == '-');

			if (changeDirection) {
				int indexCurrentLetter = getIndexCurrentLetter(grid, i, j, false);
				if (indexCurrentLetter >= 0) {
					List<String> possibleWords = getPossibleWords(words, set, word.charAt(character),
							indexCurrentLetter);
					if (!possibleWords.isEmpty()) {
						for (int k = 0; k < possibleWords.size() && !filled; k++) {
							set.add(possibleWords.get(k));
							filled = fillGrid(set, words, grid, possibleWords.get(k), 0, i, j - indexCurrentLetter,
									!verticalDirection);
							if (!filled)
								set.remove(possibleWords.get(k));
						}
					}

					if (!filled) {
						grid[i][j] = '-';
						return false;
					}
				}
			}

			filled = fillGrid(set, words, grid, word, character + 1, i + 1, j, verticalDirection);
			if (!filled) {
				grid[i][j] = '-';
			}

		} else {
			changeDirection = (i == 0 && grid[i + 1][j] == '-') || (i == grid.length - 1 && grid[i - 1][j] == '-')
					|| (i > 0 && i < grid.length - 1 && grid[i - 1][j] == '-' && grid[i + 1][j] == '-')
					|| (i > 0 && i < grid.length - 1 && grid[i - 1][j] == '+' && grid[i + 1][j] == '-');

			if (changeDirection) {
				int indexCurrentLetter = getIndexCurrentLetter(grid, i, j, true);
				if (indexCurrentLetter >= 0) {
					List<String> possibleWords = getPossibleWords(words, set, word.charAt(character),
							indexCurrentLetter);
					if (!possibleWords.isEmpty()) {
						for (int k = 0; k < possibleWords.size() && !filled; k++) {
							set.add(possibleWords.get(k));
							filled = fillGrid(set, words, grid, possibleWords.get(k), 0, i - indexCurrentLetter, j,
									!verticalDirection);
							if (!filled)
								set.remove(possibleWords.get(k));
						}
					}

					if (!filled) {
						grid[i][j] = '-';
						return false;
					}
				}
			}

			filled = fillGrid(set, words, grid, word, character + 1, i, j + 1, verticalDirection);
			if (!filled) {
				grid[i][j] = '-';
			}
		}

		return filled;
	}

	private static void fillGrid(char[][] grid, String[] words, Set<String> set) {
		int i = 0, j = 0;

		boolean existHyphen = false;
		for (; i < grid.length && !existHyphen; i++) {
			j = 0;
			for (; j < grid.length && !existHyphen; j++) {
				if (grid[i][j] == '-')
					existHyphen = true;
			}
		}

		i -= 1;
		j -= 1;

		if (set == null)
			set = new HashSet<String>();
		boolean filled = false;
		boolean isVerticalDirection = i + 1 < grid.length && grid[i + 1][j] == '-';
		for (String word : words) {
			if (set.add(word)) {
				filled = fillGrid(set, words, grid, word, 0, i, j, isVerticalDirection);
				if (filled)
					break;
				set.remove(word);
			}
		}

		if (set.size() < words.length)
			fillGrid(grid, words, set);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		char[][] grid = new char[10][10];
		String[] words = null;

		for (int i = 0; i < 10; i++) {
			String line = in.nextLine();
			for (int j = 0; j < 10; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		words = in.nextLine().split(";");

		fillGrid(grid, words, null);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}

		in.close();
	}
}
