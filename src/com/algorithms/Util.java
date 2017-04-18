package com.algorithms;

import java.util.Scanner;

public class Util {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	      char[][] matrix = new char[10][10];
	      
	      for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	          matrix[i][j] = in.next("+|-").charAt(0);
	        }
	      }
	      
	      String[] words = in.nextLine().split(";");
	      System.out.println(words);
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
	
	public static void main2(String[] args) {
		int a = 6;
		
		System.out.println(Integer.parseUnsignedInt("00001100", 2));
		System.out.println(Integer.parseUnsignedInt("10001100", 2));
		System.out.println(Integer.parseUnsignedInt("00001100", 2) & Integer.parseUnsignedInt("10001100", 2));
	}
}
