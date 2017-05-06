package com.algorithms.hackerrank;

import java.util.Scanner;

public class Pylons {

	private static int verifyEnergyAvailability(int[] cities, int k) {
		int turnedon = 0;

		for (int i = 0; i < cities.length; i++) {
			int end = Math.min(cities.length - 1, i + k);
			int start = Math.max(0, i - k);
			int j = end;
			
			for (; j >= start; j--) {
				if (cities[j] == 1) {
					turnedon += 1;
					i = j + k;
					break;
				}
			}

			if (j < start) return -1;
		}

		return turnedon;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), k = in.nextInt() - 1;

		int[] cities = new int[n];
		for (int i = 0; i < n; i++) {
			cities[i] = in.nextInt();
		}

		System.out.print(verifyEnergyAvailability(cities, k));
		in.close();
	}
}
