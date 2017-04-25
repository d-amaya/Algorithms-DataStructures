package com.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;

// Example = 2824
// 
// Step 1:
// 2824 + 824 + 24 + 4 = (2*10^3 + 8*10^2 + 2*10^1 + 4*10^0) + (8*10^2 + 2*10^1 + 4*10^0) + (2*10^1 + 4*10^0) + (4*10^0)
// 282  + 82  + 2      = (2*10^2 + 8*10^1 + 2*10^0)          + (8*10^1 + 2*10^0)          + (2*10^0)
// 28   + 8            = (2*10^1 + 8*10^0)                   + (8*10^0)
// 2                   = (2*10^0)
// 
// Step 2:
// 2824 + 824 + 24 + 4 = 1(2*10^3) + 2(8*10^2) + 3(2*10^1) + 4(4*10^0)
// 282  + 82  + 2      = 1(2*10^2) + 2(8*10^1) + 3(2*10^0)
// 28   + 8            = 1(2*10^1) + 2(8*10^0)
// 2                   = 1(2*10^0)
// 
// Step 3: 
// 2824 + 824 + 24 + 4 = 2*10^3 + 16*10^2 + 6*10^1 + 16*10^0
// 282  + 82  + 2      = 2*10^2 + 16*10^1 + 6*10^0
// 28   + 8            = 2*10^1 + 16*10^0
// 2                   = 2*10^0
// 
// Step 4:
// 2(10^3) + 18(10^2) + 24(10^1) + 40(10^0)

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
