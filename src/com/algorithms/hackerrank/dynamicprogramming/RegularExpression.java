package com.algorithms.hackerrank.dynamicprogramming;

public class RegularExpression {

	public static void main(String[] args) {
		String pattern = "xa*b.c";
		String text    = "xabyc";
		System.out.println(matches(pattern, text) ? "YES" : "NO");
		
		pattern = "";
		text    = "";
		System.out.println(matches(pattern, text) ? "YES" : "NO");
		
		pattern = "xa*b.c.*T9";
		text    = "xaaaaaabycJgtrT9";
		System.out.println(matches(pattern, text) ? "YES" : "NO");
		
		pattern = "Daniel .* .*";
		text    = "Daniel Roldan Amaya";
		System.out.println(matches(pattern, text) ? "YES" : "NO");
		
		pattern = "Daniel .* .";
		text    = "Daniel Roldan Amaya";
		System.out.println(matches(pattern, text) ? "YES" : "NO");
	}

	private static boolean matches(String pattern, String text) {
		pattern = " " + pattern;
		text = " " + text;
		
		boolean[][] dp = new boolean[text.length()][pattern.length()];
		dp[0][0] = true;
		
		for (int i = 1; i < text.length(); i++) {
			for (int j = 1; j < pattern.length(); j++) {
				if (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(j) == '*') {
					if (j > 1 && dp[i][j - 2]) 
						dp[i][j] = dp[i][j - 2];
					else if (text.charAt(i) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') 
						dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		return dp[text.length() - 1][pattern.length() - 1];
	}
}
