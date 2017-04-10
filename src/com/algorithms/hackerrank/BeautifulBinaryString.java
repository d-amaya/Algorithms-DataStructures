package com.algorithms.hackerrank;

import java.util.Scanner;

public class BeautifulBinaryString {

	private static int minSteps(int n, String s) {
		char[] characters = s.toCharArray();
		int count = 0;

		for (int i = 1; i < characters.length - 1; i++) {
			if (characters[i] == '1' && characters[i - 1] == '0' && characters[i + 1] == '0') {
				count += 1;
				i += 2;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int result = minSteps(in.nextInt(), in.next());
		System.out.println(result);

		in.close();
	}
}
