package com.algorithms.hackerrank;

import java.util.Scanner;

public class SeparateTheNumbers {

	private static long getNumber(String s, int x, int length) {
		String substring = s.substring(x, x + length + 1);
		return substring.charAt(0) == '0' ? 0 : Long.parseLong(substring);
	}

	private static String printBeautiful(String s) {
		if (s.length() <= 1) return "NO";

		long first = -1;
		int length = 0, times = 0, i = 0, j = length + 1;

		boolean isBeautiful = false;
		while (j + length < s.length()) {
			long prev = getNumber(s, i, length);
			long current = getNumber(s, j, length);
			
			if (current - prev == 1) {
				first = (first == -1) ? prev : first;
				isBeautiful = true;
				i = j;
				j += length + 1;
				continue;
			}
			if (j + length + 1 < s.length()) {
				current = getNumber(s, j, length + 1);
				if (current - prev == 1) {
					first = (first == -1) ? prev : first;
					isBeautiful = true;
					length += 1;
					i = j;
					j += length + 1;
					continue;
				}
			}
			
			isBeautiful = false;
			i = 0;
			times += 1;
			first = -1;
			length = times;
			j = length + 1;
		}
		
		return isBeautiful && j == s.length() ? "YES " + first : "NO";
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		in.nextLine();
		for (int a0 = 0; a0 < q; a0++) System.out.println(printBeautiful(in.nextLine()));
		in.close();
	}
}
