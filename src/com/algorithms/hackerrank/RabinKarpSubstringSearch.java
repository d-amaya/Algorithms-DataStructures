package com.algorithms.hackerrank;

import java.util.Scanner;

public class RabinKarpSubstringSearch {

	private static final int PRIME_HASHCODE_CALCULATION = 101;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		String pattern = in.nextLine();
		
		System.out.println(rabinKarpSearch(s, pattern) ? "The pattern exists." : "The pattern does not exist.");
		
		in.close();
	}

	private static boolean rabinKarpSearch(String s, String pattern) {
		if (pattern.length() <= s.length()) {
			int patternHashCode = calculateHashCode(pattern, pattern.length());
			int sHashCode = calculateHashCode(s, pattern.length());
			
			if (patternHashCode == sHashCode) return true;
			
			for (int i = pattern.length(); i < s.length(); i++) {
				sHashCode = recalculateHashCode(s, sHashCode, pattern.length(), i);
				if (patternHashCode == sHashCode 
						&& pattern.equals(s.substring(i + 1 - pattern.length(), i + 1)))
					return true;
			}
		}
		
		return false;
	}

	private static int recalculateHashCode(String s, int sHashCode, int patternLength, int i) {
		sHashCode -= s.charAt(i - patternLength) - 'a';
		sHashCode /= PRIME_HASHCODE_CALCULATION;
		sHashCode += (s.charAt(i) - 'a') * Math.pow(PRIME_HASHCODE_CALCULATION, patternLength - 1);
		return sHashCode;
	}

	private static int calculateHashCode(String pattern, int finalIndex) {
		char[] characters = pattern.toCharArray();
		int hash = 0;
		for (int i = 0; i < finalIndex; i++) {
			hash += (characters[i] - 'a') * Math.pow(PRIME_HASHCODE_CALCULATION, i);
		}
		return hash;
	}
	
}
