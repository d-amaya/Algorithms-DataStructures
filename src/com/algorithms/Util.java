package com.algorithms;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Util {

	public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
		int g = 1000000000;
		long[] x = new long[g];
	}
	
	
	public static ArrayList<Integer> getA() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(2);
		return a;
	}
	
	
	public static void main5(String[] args) {
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
