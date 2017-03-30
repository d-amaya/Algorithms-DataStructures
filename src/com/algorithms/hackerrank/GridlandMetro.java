package com.algorithms.hackerrank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GridlandMetro {

	private static Queue<BigDecimal[]> insertionSort(Queue<BigDecimal[]> arr, BigDecimal[] newTrain) {
		Queue<BigDecimal[]> arrAux = new LinkedList<BigDecimal[]>();
		
		arrAux.add(newTrain);
		
		while (!arr.isEmpty()) {
			BigDecimal[] train = arr.poll();
			
			if (train[1].compareTo(newTrain[0]) < 0 || newTrain[1].compareTo(train[0]) < 0) {
				arrAux.add(train);
			} else {
				arrAux.poll();
				train[0] = train[0].min(newTrain[0]);
				train[1] = train[1].max(newTrain[1]);
				arrAux.add(train);
			}
			
		}
		
		return arrAux;
	}
	
	private static int findRange(int row) {
		int range = 1000000;
		return Math.round(row / range) * range;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		BigDecimal n = new BigDecimal(in.nextInt());
		BigDecimal m = new BigDecimal(in.nextInt());
		int k = in.nextInt();
		
		Map<Integer, Map<Integer, Queue<BigDecimal[]>>> grid = new HashMap<Integer, Map<Integer, Queue<BigDecimal[]>>>();
		BigDecimal count = n.multiply(m);

		if (k > 0) {
			for (int i = 0; i < k; i++) {
				int r = in.nextInt();
				BigDecimal[] train = {new BigDecimal(in.nextInt()), new BigDecimal(in.nextInt())};
				
				int range = findRange(r);
				
				Map<Integer, Queue<BigDecimal[]>> rows = grid.get(range);
				if (rows == null) {
					rows = new HashMap<Integer, Queue<BigDecimal[]>>();
					grid.put(range, rows);
				}
				
				Queue<BigDecimal[]> arr = rows.get(r);
				if (arr == null) {
					arr = new LinkedList<BigDecimal[]>();
				}

				arr = insertionSort(arr, train);
				rows.put(r, arr);
			}
			
			for (Map<Integer, Queue<BigDecimal[]>> rows : grid.values()) {
				for (Queue<BigDecimal[]> trains : rows.values()) {
					while (!trains.isEmpty()) {
						BigDecimal[] train = trains.poll();
						count = count.subtract(train[1].subtract(train[0]).add(new BigDecimal(1)));
					}
				}
			}
			
		}

		System.out.print(count.toString());
		in.close();
	}
}
