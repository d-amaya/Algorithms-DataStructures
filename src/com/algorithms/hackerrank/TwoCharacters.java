package com.algorithms.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoCharacters {

	private static boolean isValidSequence(String word, char x, char y) {
		int charX = 0, charY = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == x) charX++;
			if (word.charAt(i) == y) charY++;
			if (charX - charY < 0 || charX - charY > 1) return false;
		}
		return true;
	}

	private static int getLongestCombination(String word, int[] letters) {
		int longest = 0;
		Set<String> combinations = new HashSet<String>();
		boolean[] visited = new boolean[letters.length];
		for (int i = 0; i < word.length(); i++) {
			visited[word.charAt(i) - 'a'] = true;
			for (int j = i + 1; j < word.length(); j++) {
				StringBuilder sb = new StringBuilder(2).append(word.charAt(i)).append(word.charAt(j));
				if (!visited[word.charAt(j) - 'a'] && !combinations.contains(sb.toString())
						&& isValidSequence(word, word.charAt(i), word.charAt(j))) {
					longest = Math.max(longest, letters[word.charAt(i) - 'a'] + letters[word.charAt(j) - 'a']);
				}
				combinations.add(sb.toString());
				combinations.add(sb.reverse().toString());
				visited[word.charAt(j) - 'a'] = true;
			}
			visited = new boolean[letters.length];
		}
		return longest;
	}

	private static int getLongestString(String s) {
		int[] letters = new int[30];

		if (s.isEmpty()) return 0;

		boolean subtracted = false;
		letters[s.charAt(0) - 'a'] += 1;
		for (int i = 1; i < s.length(); i++) {
			if (letters[s.charAt(i) - 'a'] >= 0) {
				int count = letters[s.charAt(i) - 'a'];
				count = (s.charAt(i) == s.charAt(i - 1)) ? -1 : count + 1;
				letters[s.charAt(i) - 'a'] = count;
				if (count == -1)
					subtracted = true;
			}
		}

		if (subtracted) {
			StringBuilder sb = new StringBuilder(s.length());
			for (int j = 0; j < s.length(); j++) {
				if (letters[s.charAt(j) - 'a'] > 0)
					sb.append(s.charAt(j));
			}
			return getLongestString(sb.toString());
		}

		return getLongestCombination(s, letters);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		in.nextLine();
		System.out.print(getLongestString(in.nextLine()));

		in.close();
	}
}
