package com.algorithms.hackerrank;

import java.math.BigDecimal;
import java.util.Scanner;

public class RoadsAndLibraries {
	
	private static int amountOfComponents = 0;

	private static String calculateCost(int[] connectedComponents, int cities, int edges, int costByCity, int costByRoad) {
		if (edges == 0 || costByRoad >= costByCity) {
			return new BigDecimal(costByCity).multiply(new BigDecimal(cities)).toString();
		}

		BigDecimal costLibraryEveryCity = new BigDecimal(costByCity).multiply(new BigDecimal(cities));
		BigDecimal costLibraryRoads = new BigDecimal(costByRoad)
		    .multiply(new BigDecimal(cities).subtract(new BigDecimal(amountOfComponents)))
		    .add(new BigDecimal(costByCity).multiply(new BigDecimal(amountOfComponents)));

		return (costLibraryEveryCity.compareTo(costLibraryRoads) <= 0)
							? costLibraryEveryCity.toString()
					    : costLibraryRoads.toString();
	}

	private static void addEdge(int[] connectedComponents, int from, int to) {
		int parentFrom = lookForParent(connectedComponents, from);
		int parentTo = lookForParent(connectedComponents, to);
		
		if (parentFrom != parentTo) {
			amountOfComponents -= 1;
			connectedComponents[parentFrom] = parentTo;
		}
	}
	
	private static int lookForParent(int[] connectedComponents, int index) {
		while (connectedComponents[index] != 0) {
			index = connectedComponents[index];
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		for (int a0 = 0; a0 < q; a0++) {
			int cities = in.nextInt();
			int edges = in.nextInt();
			int costByCity = in.nextInt();
			int costByRoad = in.nextInt();

			int[] connectedComponents = new int[cities + 1];
			amountOfComponents = cities;
			
			for (int a1 = 0; a1 < edges; a1++) {
				addEdge(connectedComponents, in.nextInt(), in.nextInt());
			}

			System.out.println(calculateCost(connectedComponents, cities, edges, costByCity, costByRoad));
		}

		in.close();
	}
}
