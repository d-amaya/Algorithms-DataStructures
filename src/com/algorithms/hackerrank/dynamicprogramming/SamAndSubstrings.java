package com.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;

public class SamAndSubstrings {

	private static long numberOfCandies(String balls) {
		int n = balls.length();
		int mod = 1000000007;

		long[] powers = new long[n];
		powers[0] = 1;
		for (int p = 1; p < n; p++)
			powers[p] = (powers[p - 1] * 10) % mod;

		long total = 0;
		long times = 0;
		for (int i = 0; i < n; i++) {
			int digit = balls.charAt(i) - '0';
			int power = n - i - 1;
			times = ((i + 1) * digit + times) % mod;
			total = (times * powers[power] + total) % mod;
		}

		return total;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String balls = in.nextLine();
		System.out.print(numberOfCandies(balls));

		in.close();
	}
}
