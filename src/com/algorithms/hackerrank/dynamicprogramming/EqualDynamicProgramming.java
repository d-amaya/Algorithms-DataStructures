package com.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;

public class EqualDynamicProgramming {
	
	private static int balanceChocolates(int[] chocolates) {
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < chocolates.length && chocolates[i] < min; i++) min = chocolates[i];
		

		int[][] results = new int[chocolates.length][3];
		for (int i = 0; i < chocolates.length; i++) {
			for (int j = 0; j < 3; j++) {
				int delta = chocolates[i] - min + j;
				results[i][j] = (delta / 5) + (delta % 5 / 2) + (delta % 5 % 2);
			}
		}
		
		int finalResult = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			int subFinal = 0;
			for (int j = 0; j < chocolates.length; j++) subFinal += results[j][i];
			if (finalResult > subFinal) finalResult = subFinal;
		}

		return finalResult;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int[] chocolates = new int[in.nextInt()];
			for (int j = 0; j < chocolates.length; j++) {
				chocolates[j] = in.nextInt();
			}
			System.out.println(balanceChocolates(chocolates));
		}

		in.close();
	}
}
