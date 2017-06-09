package com.algorithms.hackerrank;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();

		char[] characters = S.toCharArray();
		int counter = 0;

		for (int i = 0; i < characters.length; i++) {
			int mod = (i + 1) % 3;
			switch (mod) {
				case 1:
					counter += characters[i] != 'S' ? 1 : 0;
					break;
				case 2:
					counter += characters[i] != 'O' ? 1 : 0;
					break;
				case 0:
					counter += characters[i] != 'S' ? 1 : 0;
					break;
			}
		}

		System.out.print(counter);
		in.close();
	}
}
