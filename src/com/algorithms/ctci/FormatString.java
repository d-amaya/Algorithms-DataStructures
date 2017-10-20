package com.algorithms.ctci;

public class FormatString {

	public static void main(String[] args) {
		System.out.println(formatString("Mr John Smith    "));
	}
	
	public static String formatString(String s1) {
		char[] ch = s1.toCharArray();
		int last = ch.length - 1;
		for (int i = ch.length - 1; i > 0; i--) {
			if (ch[i] != ' ') {
				ch[last] = ch[i];
				last -= 1;
			} else if (ch[ch.length - 1] != ' ') {
				ch[last] = '0';
				ch[last - 1] = '2';
				ch[last - 2] = '%';
				last -= 3;
			}
		}
		return String.valueOf(ch);
	}
}
