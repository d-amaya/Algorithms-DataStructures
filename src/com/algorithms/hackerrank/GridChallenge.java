package com.algorithms.hackerrank;

import java.util.Scanner;

public class GridChallenge {

	private static void quickSort(String[] arr, int start, int end) {
		if (end <= start) return;
		
		String pivot = arr[end];
		int i = start - 1, j = start;

		for (; j < end; j++) {
			if (arr[j].compareTo(pivot) <= 0) {
				i++;
				String aux = arr[j];
				arr[j] = arr[i];
				arr[i] = aux;
			}
		}
		arr[end] = arr[i + 1];
		arr[i + 1] = pivot;

		quickSort(arr, start, i);
		quickSort(arr, i + 2, end);
	}

	private static boolean gridSorted(String[][] grid) {
		int n = grid.length;
		String[] gridSorted = new String[(int) Math.pow(n, 2)];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				gridSorted[(r * n) + c] = grid[r][c];
			}
		}

		for (int i = 0; i < n; i++) {
			int start = i * n;
			int end = start + n - 1;
			quickSort(gridSorted, start, end);
		}

		for (int c = 0; c < n; c++) {
			int prev = c;
			for (int next = prev + n; next < gridSorted.length; next += n) {
				if (gridSorted[next].compareTo(gridSorted[prev]) < 0) return false;
				prev = next;
			}
			
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			in.nextLine();

			String[][] grid = new String[n][n];
			for (int j = 0; j < n; j++) {
				String line = in.nextLine();
				for (int k = 0; k < line.length(); k++) {
					grid[j][k] = String.valueOf(line.charAt(k));
				}
			}

			System.out.println(gridSorted(grid) ? "YES" : "NO");
		}

		in.close();
	}
}
