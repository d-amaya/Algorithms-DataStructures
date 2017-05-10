package com.algorithms.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UkAndUs2 {

	private static int getUkAndUs(String text, String word) {
		Pattern patternUk = Pattern.compile("\\b" + word + "\\b");
		Matcher matcherUk = patternUk.matcher(text);
		
		Pattern patternUs = Pattern.compile("\\b" + word.replace("our", "or") + "\\b");
		Matcher matcherUs = patternUs.matcher(text);

		int count = 0;
		while (matcherUk.find()) count += 1;
		while (matcherUs.find()) count += 1;
		
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();

		StringBuilder text = new StringBuilder();
		for (int i = 0; i < n; i++) {
			text.append(in.nextLine() + " ");
		}

		int t = in.nextInt();
		in.nextLine();

		for (int i = 0; i < t; i++) {
			String word = in.nextLine();
			System.out.println(getUkAndUs(text.toString(), word));
		}

		in.close();
	}
}
