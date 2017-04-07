package com.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;

public class DPCoinChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] coins = new int[m];

		for (int i = 0; i < m; i++) {
			coins[i] = in.nextInt();
		}

		System.out.println(makeChange(n, coins));
		in.close();
	}

	private static long makeChange(int total, int[] coins) {
		long[] totals = new long[total + 1];
		for (int coin : coins) {
			if (coin <= total) {
				totals[coin] += 1;
				for (int i = coin + 1; i < totals.length; i++) {
					if (totals[i - coin] > 0) {
						totals[i] += totals[i - coin];
					}
				}
			}
		}
		return totals[total];
	}
}
