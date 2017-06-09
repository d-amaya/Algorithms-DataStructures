package com.algorithms.hackerrank;

import java.util.Scanner;

public class CaesarCipher1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		in.nextInt();
		String s = in.next();
		int k = in.nextInt();

		char[] characters = s.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			int ascii = (int) s.charAt(i);
			if (ascii >= 'a' && ascii <= 'z') {
				ascii += k;
				if (ascii > 'z') ascii = 'a' + ((ascii - 'a') % ('z' - 'a' + 1));
			} else if (ascii >= 'A' && ascii <= 'Z') {
				ascii += k;
				if (ascii > 'Z') ascii = 'A' + ((ascii -  'A') % ('Z' - 'A' + 1));
			}
			characters[i] = (char) ascii;
		}

		System.out.println(characters);
		in.close();
	}
}
