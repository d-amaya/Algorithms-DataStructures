package com.algorithms.hackerrank;

import java.util.Scanner;

public class Anagram {

	private static int makeItAnagram(String s) {
		if (s.length() % 2 > 0) return -1;

		int letters = 30;
		int[] charactersS1 = new int[letters];
		int[] charactersS2 = new int[letters];

		int middle = s.length() / 2;

		for (int i = 0; i < middle; i++) charactersS1[s.charAt(i) - 'a'] += 1;
		for (int i = middle; i < s.length(); i++) charactersS2[s.charAt(i) - 'a'] += 1;

		int change = 0;
		for (int i = 0; i < letters; i++) {
			if (charactersS1[i] > 0) change += Math.max(0, charactersS1[i] - charactersS2[i]);
		}
		
		return change;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		in.nextLine();

		for (int i = 0; i < t; i++) {
			System.out.println(makeItAnagram(in.nextLine()));
		}

		in.close();
	}
}
