package com.algorithms;

import java.util.Scanner;

public class Util {

	public static void main(String[] args) {
		short[] result = new short[27];
		String s = "abcdtefghi";

		boolean duplicated = false;
		for (int i = 0; i < s.length(); i++) {
			int position = s.charAt(i) - 'a';
			if (result[position] > 0) {
				duplicated = true;
				break;
			}
			result[position] += 1;
		}

		System.out.println(duplicated ? "Duplicated elements" : "No duplicated elements.");
	}

	public static void main4(String[] args) {
		Scanner in = new Scanner(System.in);
		char[][] matrix = new char[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				matrix[i][j] = in.next("+|-").charAt(0);
			}
		}

		String[] words = in.nextLine().split(";");
		System.out.println(words);
		in.close();
	}

	public static void main1(String[] args) {
		String str = "5";
		int answer = 0, factor = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			answer += (str.charAt(i) - '0') * factor;
			factor *= 10;
		}
		System.out.println(answer);
	}
}
