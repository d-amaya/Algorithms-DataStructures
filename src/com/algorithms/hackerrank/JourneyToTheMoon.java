package com.algorithms.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JourneyToTheMoon {

	private static int getParent(int[] astronauts, int i) {
		while (i != astronauts[i])
			i = astronauts[i];
		return i;
	}

	private static long calculatePairs(Map<Integer, Integer> countries, int n) {
		long aloneAstronauts = n;

		long[] arr = new long[countries.size() + 1];
		int index = 0;
		for (Integer value : countries.values()) {
			arr[index++] = value.intValue();
			aloneAstronauts -= value.intValue();
		}
		arr[index] = aloneAstronauts;

		long totalPairs = aloneAstronauts > 0 ? ((aloneAstronauts - 1) * (aloneAstronauts)) / 2 : 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				totalPairs += arr[i] * arr[j];
			}
		}

		return totalPairs;
	}

	private static long waysToChooseAstronauts(Map<Integer, Set<Integer>> graph, int n) {
		int[] astronauts = new int[n];
		for (int i = 0; i < astronauts.length; i++)
			astronauts[i] = i;

		Map<Integer, Integer> countries = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
			int parentKey = getParent(astronauts, entry.getKey().intValue());

			Integer childrenParent = countries.get(parentKey);
			if (childrenParent == null)
				childrenParent = 1;

			for (int i : entry.getValue()) {
				int parentValue = getParent(astronauts, i);
				if (parentKey != parentValue) {
					astronauts[parentValue] = parentKey;

					Integer childrenValue = countries.get(parentValue);
					if (childrenValue == null)
						childrenValue = 1;

					childrenParent += childrenValue;

					countries.put(parentKey, childrenParent);
					countries.remove(parentValue);
				}
			}
		}

		return calculatePairs(countries, n);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int P = in.nextInt();

		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < P; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			Set<Integer> set = graph.get(a);
			if (set == null) {
				set = new HashSet<Integer>();
				graph.put(a, set);
			}
			set.add(b);

			set = graph.get(b);
			if (set == null) {
				set = new HashSet<Integer>();
				graph.put(b, set);
			}
			set.add(a);
		}

		System.out.print(waysToChooseAstronauts(graph, N));
		in.close();

	}
}
