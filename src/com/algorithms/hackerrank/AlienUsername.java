package com.algorithms.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienUsername {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Pattern pattern = Pattern.compile("^(\\.|_)([0-9]+)([a-zA-Z]+)?(_)?$");

		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			Matcher matcher = pattern.matcher(s);
			if (matcher.matches())
				System.out.println("VALID");
			else
				System.out.println("INVALID");
		}
		
		in.close();
	}
}
