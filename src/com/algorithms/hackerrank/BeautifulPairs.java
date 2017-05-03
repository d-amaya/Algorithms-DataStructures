package com.algorithms.hackerrank;

import java.util.Scanner;

public class BeautifulPairs {

	private static final int ONE_THOUSAND = 1001;

	private static int beautifulPairs(int[] A, int[] B) {
		int[] countA = new int[ONE_THOUSAND];
		int[] countB = new int[ONE_THOUSAND];

		for (int k = 0; k < A.length; k++) {
			countA[A[k]] += 1;
			countB[B[k]] += 1;
		}

		int disjointBeautifulPairs = 0;
		for (int x = 0; x < ONE_THOUSAND; x++) {
			if (countA[x] > 0)
				disjointBeautifulPairs += Math.min(countA[x], countB[x]);
		}

		if (disjointBeautifulPairs < A.length) {
			disjointBeautifulPairs += 1;
		} else if (disjointBeautifulPairs == A.length) {
			disjointBeautifulPairs -= 1;
		}

		return disjointBeautifulPairs;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}

		for (int j = 0; j < n; j++) {
			B[j] = in.nextInt();
		}

		System.out.print(beautifulPairs(A, B));
		in.close();
	}
}
