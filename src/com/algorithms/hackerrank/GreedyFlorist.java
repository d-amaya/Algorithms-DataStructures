package com.algorithms.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GreedyFlorist {

	private static int bestGreedySolution(Integer[] prices, int people, int flowers) {
    Arrays.sort(prices, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return (n2 - n1);
			}
		});
    
    int person = 0, round = 0, total = 0, amountBought = 0;
    while (amountBought < flowers) {
      for (int i = 0; i < prices.length; i++) {
      	total += (round + 1) * prices[i];
      	amountBought += 1;
      	person += 1;
      	
      	if (person % people == 0) {
      		person = 0;
      		round += 1;
      	}
  		}
    }
    
    return total;
}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int N, K;
		N = in.nextInt();
		K = in.nextInt();

		Integer C[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			C[i] = in.nextInt();
		}

		int result = bestGreedySolution(C, K, N);
		System.out.println(result);
		
		in.close();
	}
}
