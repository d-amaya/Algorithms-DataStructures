package com.algorithms.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {
	
	private static int maximumNumberToys(int[] prices, int money) {
		Arrays.sort(prices);

		int toys = 0;
		for (int i = 0; i < prices.length && money >= prices[i]; i++) {
			toys += 1;
			money -= prices[i];
		}

		return toys;
	}

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int k = stdin.nextInt();

		int[] prices = new int[n];
		for (int i = 0; i < n; i++)
			prices[i] = stdin.nextInt();

		int answer = maximumNumberToys(prices, k);
		System.out.println(answer);

		stdin.close();
	}
}
