package com.algorithms;

public class Util {

	public static void main1(String[] args) {
		String str = "5";
		int answer = 0, factor = 1;
	    for (int i = str.length() - 1; i >= 0; i--) {
	        answer += (str.charAt(i) - '0') * factor;
	        factor *= 10;
	    }
	    System.out.println(answer);
	}
	
	public static void main(String[] args) {
		System.out.println(Math.nextUp( 5 / 2));
	}
}