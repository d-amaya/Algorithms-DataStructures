package com.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(getLCS(in.nextLine(), in.nextLine()));
		in.close();
	}

	private static String getLCS(String s1, String s2) {
		int[][] dp = buildMatrixLCS(s1, s2);
		
		Stack<Character> stack = new Stack<Character>();
		int i = s1.length(), j = s2.length();
		
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i][j - 1]) j -= 1;
			else if (dp[i][j] == dp[i - 1][j]) i -= 1;
			else {
				stack.push(s1.charAt(i - 1));
				i -= 1;
				j -= 1;
			}
		}
		
		StringBuilder answer = new StringBuilder();
		IntStream.range(0, stack.size()).forEach(x -> answer.append(stack.pop()));
		
		return answer.toString();
	}
	
	private static int[][] buildMatrixLCS(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		IntStream.rangeClosed(1, s1.length())
			.forEach(i -> IntStream.rangeClosed(1, s2.length())
								   .forEach(j -> fillValues(dp, s1, s2, i, j)));
		return dp;
	}
	
	private static void fillValues(int[][] dp, String s1, String s2, int i, int j) {
		dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) 
				 ? dp[i - 1][j - 1] + 1
				 : Math.max(dp[i][j - 1], dp[i - 1][j]);
	}
}
