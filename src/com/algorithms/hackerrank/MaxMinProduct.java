package com.algorithms.hackerrank;

import java.util.Comparator;
import java.util.Scanner;

public class MaxMinProduct {
	
	private static IndexPriorityQueue<Integer> max = new IndexPriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i2.intValue() - i1.intValue();
		}
	});
	
	private static IndexPriorityQueue<Integer> min = new IndexPriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i1.intValue() - i2.intValue();
		}
	});
	
	private static long[] calculateMaxMinProduct(String[] op, int[] numbers) {
		long[] result = new long[op.length];
		
		result[0] = (long) Math.pow(numbers[0], 2);
		min.push(numbers[0]);
		max.push(numbers[0]);
		
		for (int i = 1; i < op.length; i++) {
			switch (op[i]) {
				case "push":
					min.push(numbers[i]);
					max.push(numbers[i]);
					break;
					
				case "pop":
					min.remove(numbers[i]);
					max.remove(numbers[i]);
					break;
			}
			result[i] = !min.isEmpty() ? Math.multiplyExact(min.peek(), max.peek()) : 0;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.nextLine();
		
		String[] operations = new String[n]; 
		for (int i = 0; i < n; i++) operations[i] = in.nextLine();
		
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) numbers[i] = in.nextInt();
		
		long[] product = calculateMaxMinProduct(operations, numbers);
		for (int i = 0; i < product.length; i++) System.out.print(product[i] + " ");
		
		in.close();
	}
}
