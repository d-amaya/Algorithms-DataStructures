package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {

//	private static void findLastDeathDay(int[] plants) {
//		Stack<Integer> killers = new Stack<Integer>();
//		killers.push(plants[0]);
//
//		int max = 0;
//		int lastKillerDays = 0;
//		for (int i = 1; i < plants.length; i++) {
//			int currentPlant = plants[i];
//			if (currentPlant > killers.peek()) {
//				lastKillerDays++;
//				
//				int j = i + 1;
//				while (j < plants.length 
//						&& (plants[j] > plants[j - 1] 
//								|| (plants[j] > currentPlant && j-i <= lastKillerDays))) {
//					j++;
//				}
//				i = j - 1;
//			} else {
//				killers.push(currentPlant);
//				max = Math.max(max, lastKillerDays);
//				lastKillerDays = 0;
//			}
//		}
//
//		max = Math.max(max, lastKillerDays);
//		System.out.println(max);
//	}
	
	private static void findLastDeathDay(int[] plants) {
		Stack<Integer> alivePlantsIndex = new Stack<Integer>();
		List<Integer> deadPlants = new ArrayList<Integer>();

		int max = 0;
		int countDays = 0;
		alivePlantsIndex.push(plants[0]);
		for (int i = 1; i < plants.length; i++) {
			
			int currentPlant = plants[i];
			if (currentPlant <= alivePlantsIndex.peek()) {
				alivePlantsIndex.push(currentPlant);
				continue;
			}
			
			int j;
			countDays = 1;
			deadPlants.clear();
			deadPlants.add(alivePlantsIndex.peek());
			for (j = i; j < plants.length && plants[j] > alivePlantsIndex.peek(); j++) {
				if (plants[j] >= plants[j-1]) deadPlants.add(plants[j]);
			}
			i = j - 1;
			
			
			while (deadPlants.size() > 1) {
				countDays++;
				for (int k = deadPlants.size() - 1; k > 0; k--) {
					if (deadPlants.get(k) > deadPlants.get(k - 1)) deadPlants.remove(k);
				}
			}
			
			max = Math.max(max, countDays);
		}

		System.out.println(max);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] plants = new int[scanner.nextInt()];
		for (int i = 0; i < plants.length; i++) {
			plants[i] = scanner.nextInt();
		}

		findLastDeathDay(plants);
		scanner.close();
	}
}
