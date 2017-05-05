package com.algorithms.hackerrank;

import java.util.Scanner;

public class AngryChildren {

	private static void quickSort(int[] numbers, int start, int end) {
		if (end <= start)
			return;

		int pivot = numbers[end], i = start - 1, j = start;
		for (; j < end; j++) {
			if (numbers[j] <= pivot) {
				i++;
				int aux = numbers[j];
				numbers[j] = numbers[i];
				numbers[i] = aux;
			}
		}

		numbers[end] = numbers[i + 1];
		numbers[i + 1] = pivot;

		quickSort(numbers, start, i);
		quickSort(numbers, i + 2, end);
	}

	private static int minimumUnfairness(int[] numbers, int k) {
		quickSort(numbers, 0, numbers.length - 1);

		int difference = Integer.MAX_VALUE, i = 0, j = k - 1;
		while (j < numbers.length) {
			difference = Math.min(difference, numbers[j] - numbers[i]);
			i++;
			j++;
		}

		return difference;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++)
			numbers[i] = in.nextInt();

		System.out.print(minimumUnfairness(numbers, k));
		in.close();
	}
}
