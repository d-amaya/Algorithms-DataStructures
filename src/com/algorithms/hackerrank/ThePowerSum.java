package com.algorithms.hackerrank;

import java.util.Scanner;

public class ThePowerSum {

	private static int getPowerRepresentation(int total, int power, int index) {
		int count = 0;
		for (int i = index; Math.pow(i, power) <= total; i++) {
			int remainingTotal = total - (int) Math.pow(i, power);
			
			if (remainingTotal == 0) 
				count += 1;
			
			if (remainingTotal > 0)
				count += getPowerRepresentation(remainingTotal, power, i + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		int power = in.nextInt();

		System.out.print(getPowerRepresentation(total, power, 1));

		in.close();
	}
}
