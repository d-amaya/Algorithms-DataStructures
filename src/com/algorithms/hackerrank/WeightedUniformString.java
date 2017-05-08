package com.algorithms.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformString {

	private static Set<Integer> calculateWeights(String s) {
		Set<Integer> weights = new HashSet<Integer>();

		char prev = s.charAt(0);
		int weight = prev - 'a' + 1;
		weights.add(weight);

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == prev) {
				weight += prev - 'a' + 1;
			} else {
				prev = s.charAt(i);
				weight = prev - 'a' + 1;
			}
			weights.add(weight);
		}

		return weights;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		int n = in.nextInt();

		Set<Integer> weights = calculateWeights(s);

		for (int a0 = 0; a0 < n; a0++) {
			int weight = in.nextInt();
			System.out.println(weights.contains(weight) ? "Yes" : "No");
		}

		in.close();
	}
}
