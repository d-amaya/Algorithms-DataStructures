package com.algorithms.hackerrank;

import java.util.Scanner;

public class SummingPieces2 {
	private static int MOD = 1000000007;

	private static long[] getTotals(int[] digits) {
		long[] totals = new long[digits.length];
		for (int k = 1; k < digits.length; k++)
			totals[k] = (totals[k - 1] + digits[k]) % MOD;
		return totals;
	}

	private static long[] getTwoPowers(int[] digits) {
		long[] powers = new long[digits.length];
		powers[0] = 1;
		for (int k = 1; k < digits.length; k++)
			powers[k] = (powers[k - 1] * 2) % MOD;
		return powers;
	}

	private static long sumPieces(int[] digits) {
		long[] totals = getTotals(digits);
		long[] powers = getTwoPowers(digits);
		long[] pieces = new long[digits.length];

		pieces[digits.length - 1] = digits[digits.length - 1];
		long totalSum = 0;

		for (int j = digits.length - 2; j > 0; j--) {
			for (int i = j; i < digits.length; i++) {
				int length = (i - j + 1) % MOD;
				long piece = (length * (totals[i] - totals[j - 1])) % MOD;
				int power = (i < digits.length - 1) ? digits.length - i - 2 : 0;
				long nextPiece = (i == pieces.length - 1) ? 0 : pieces[i + 1];
				totalSum = ((powers[power] * piece) + nextPiece + totalSum) % MOD;
			}
			pieces[j] = totalSum;
			totalSum = 0;
		}
		return pieces[1];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] digits = new int[in.nextInt() + 1];
		for (int i = 1; i <= digits.length - 1; i++)
			digits[i] = in.nextInt();

		System.out.println(sumPieces(digits));
		in.close();
	}
}
