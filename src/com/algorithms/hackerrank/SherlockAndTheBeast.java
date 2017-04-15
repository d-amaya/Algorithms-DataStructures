package com.algorithms.hackerrank;

import java.util.Scanner;

public class SherlockAndTheBeast {
	
	private static String getMaxDecentNumber(int n) {
		int amount5Digits = n;
		int amount3Digits = 0;
		
		while (amount5Digits > 0) {
			if (amount5Digits % 3 == 0 && amount3Digits % 5 == 0) {
				break;
			}
			amount5Digits -= 1;
			amount3Digits += 1;
		}
		
		StringBuilder maxDecentNumber = new StringBuilder("-1");
		if (amount5Digits > 0 || amount3Digits % 5 == 0) {
			maxDecentNumber.setLength(0);
			for (int i = 0; i < amount5Digits; i++) {
				maxDecentNumber.append("5");
			}
			
			for (int i = 0; i < amount3Digits; i++) {
				maxDecentNumber.append("3");
			}
		}
		
		return maxDecentNumber.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(getMaxDecentNumber(in.nextInt()));
		}
		
		in.close();
	}
}
