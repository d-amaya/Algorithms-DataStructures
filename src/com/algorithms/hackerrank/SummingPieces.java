package com.algorithms.hackerrank;

import java.util.Scanner;

public class SummingPieces {
	
	private static final int MOD = 1000000007;
	
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		int[] arr = new int[in.nextInt()];
		for (int i = 0; i < arr.length; i++) arr[i] = in.nextInt();

		System.out.print(summingPieces(arr));
		in.close();
	}

	private static long summingPieces(int[] arr) {
		long[] sum = new long[arr.length];
		sum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum[i] = 0; // (arr[i] + sum[i - 1]) % MOD;
			sum[i] = (sum[i] + arr[i]) % MOD;
			sum[i] = (sum[i] + sum[i - 1]) % MOD;
		}
		
		long[] powers = new long[arr.length];
		powers[arr.length - 1] = 1;
		for (int k = arr.length - 2; k >= 0; k--) {
			powers[k] = 1; // (powers[k + 1] * 2) % MOD;
			powers[k] = (powers[k] * powers[k + 1]) % MOD;
			powers[k] = (powers[k] * 2) % MOD;
		}

		long[] dpSum = new long[arr.length];
		return summingPieces(dpSum, arr, sum, powers, 0, 0, 0);
	}
	
	private static long summingPieces(long[] dpSum, int[] arr, 
			long[] sum, long[] powers, long previousPieces, long finalSum, int i) {
		
		if (i == arr.length) return (finalSum + previousPieces) % MOD;
		
		long piece = arr[i];
		long currentSum = 0; //(previousPieces + piece) % MOD;
		currentSum = (currentSum + previousPieces) % MOD;
		currentSum = (currentSum + piece) % MOD;
		
		finalSum = summingPieces(dpSum, arr, sum, powers, currentSum, finalSum, i + 1);
		
		for (int j = i + 1; j < arr.length; j++) {
			int pieceSize = 0; //(j - i + 1) % MOD;
			pieceSize = (pieceSize + j) % MOD;
			pieceSize = (pieceSize - i) % MOD;
			pieceSize = (pieceSize + 1) % MOD;
			
			long pieceSum = 0; //(sum[j] - sum[i] + arr[i]) % MOD;
			pieceSum = (pieceSum + sum[j]) % MOD;
			pieceSum = (pieceSum - sum[i]) % MOD;
			pieceSum = (pieceSum + arr[i]) % MOD;
			
			piece = 1; // (pieceSum * pieceSize) % MOD;
			piece = (piece * pieceSum) % MOD;
			piece = (piece * pieceSize) % MOD;
			
			currentSum = 0; //(previousPieces + piece) % MOD;
			currentSum = (currentSum + previousPieces) % MOD;
			currentSum = (currentSum + piece) % MOD;
			
			if (j + 1 < dpSum.length && dpSum[j + 1] > 0) {
				long totalSum = 1; // (currentSum * powers[j + 1]) % MOD;
				totalSum = (totalSum * currentSum) % MOD;
				totalSum = (totalSum * powers[j + 1]) % MOD;
				
				finalSum = (finalSum + totalSum) % MOD;
				finalSum = (finalSum + dpSum[j + 1]) % MOD;
			} else {
				finalSum = (finalSum + currentSum) % MOD;
			}
		}
		
		long dpSumAtIndex = 1; // (previousPieces * powers[i]) % MOD;
		dpSumAtIndex = (dpSumAtIndex * previousPieces) % MOD;
		dpSumAtIndex = (dpSumAtIndex * powers[i]) % MOD;
		
		dpSum[i] = 0; //(finalSum - dpSumAtIndex) % MOD;
		dpSum[i] = (dpSum[i] + finalSum) % MOD;
		dpSum[i] = (dpSum[i] - dpSumAtIndex) % MOD;
		
		return finalSum;
	}
}
