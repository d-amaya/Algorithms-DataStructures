package com.algorithms.ctci;

public class RegularExpressionMatching {

	public static boolean matches(String s, String r) {
		
		boolean[][] dp = new boolean[s.length() + 1][r.length() + 1];
		for (int i = 0; i < dp.length; i++)dp[i][0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			char sc = s.charAt(i - 1);
			for (int j = 1; j <= r.length(); j++) {
				char rc = r.charAt(j - 1);
				if (rc == '*' || rc == '+') {
					int skipe = rc == '+' ? 1 : 2; 
					dp[i][j] = (dp[i - 1][j] && (r.charAt(j - 2) == sc || r.charAt(j - 2) == '.')) || dp[i][j - skipe];
				} else {
					dp[i][j] = ((sc == rc || rc == '.') && dp[i - 1][j - 1]);
				}
			}
		}
		
		return dp[s.length()][r.length()];
	}
	
	public static void main(String[] args) {
		String r = "dan.*89";
		System.out.println(matches("daniel89", r) ? "YES" : "NO"); // YES
		System.out.println(matches("dani89", r) ? "YES" : "NO"); // YES
		System.out.println(matches("dan89", r) ? "YES" : "NO"); // YES
		System.out.println(matches("da89", r) ? "YES" : "NO"); // NO
		System.out.println(matches("dan", r) ? "YES" : "NO"); // NO
		
		r = "dan.+89";
		System.out.println(matches("daniel89", r) ? "YES" : "NO"); // YES
		System.out.println(matches("dan89", r) ? "YES" : "NO"); // NO
		
		r = ".*";
		System.out.println(matches("any sequence is valid, even with numbers like 0 and 9", r) ? "YES" : "NO"); // YES
	}
}
