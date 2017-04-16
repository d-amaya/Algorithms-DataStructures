package com.algorithms.hackerrank;

import java.util.Scanner;

public class FenwickSumRangeArray {
	
	private final int[] binaryIndexedTree;
	
	public FenwickSumRangeArray(int[] arr) {
		this.binaryIndexedTree = new int[arr.length + 1];
		createBinaryIndexedTree(arr);
	}
	
	public int getSumRange(int from, int to) {
		int sumTo = getSum(to + 1);
		int sumFrom = getSum(from);
		return sumTo - sumFrom;
	}

	private void createBinaryIndexedTree(int[] arr) {
		this.binaryIndexedTree[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			int current = i + 1;
			this.binaryIndexedTree[current] += arr[i];
			
			int next = getNext(current);
			while (next < this.binaryIndexedTree.length) {
				this.binaryIndexedTree[next] += arr[i];
				next = getNext(next);
			}
		}
	}

	private int getSum(int index) {
		int sum = this.binaryIndexedTree[index];
		int parent = getParent(index);
		while (parent > 0) {
			sum += this.binaryIndexedTree[parent];
			parent = getParent(parent);
		}
		return sum;
	}

	/**
	 * To get the next position follow the three next steps:
	 *   1. Get the two's complement of the index.
	 *   2. Execute AND (&) bit operation with the original index.
	 *   3. Add the result to the original number.
	 *   
	 * Example:
	 *     index = 6 = 00000110 so,
	 *   	1. index two's complement => 11111001 + 1 = 11111010
	 *      2. Execute AND operation with index =>  00000110 & 11111010 = 00000010 = 2
	 *      3. Add the result to index => 00000110 (6) + 00000010 (2) = 00001000 = 8
	 * */
	private int getNext(int index) {
		return index + (index & -index);
	}
	
	/**
	 * To get the next position follow the three next steps:
	 *   1. Get the two's complement of the index.
	 *   2. Execute AND (&) bit operation with the original index.
	 *   3. Subtract the result to the original number.
	 *   
	 * Example:
	 *     index = 6 = 00000110 so,
	 *   	1. index two's complement => 11111001 + 1 = 11111010
	 *      2. Execute AND operation with index =>  00000110 & 11111010 = 00000010 = 2
	 *      3. Add the result to index => 00000110 (6) - 00000010 (2) = 00001000 = 4
	 * */
	private int getParent(int index) {
		return index - (index & -index);
	}

	//11
	//3 2 -1 6 5 4 -3 3 7 2 3
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		FenwickSumRangeArray fenwick = new FenwickSumRangeArray(arr);
		System.out.println(fenwick.getSumRange(3, 10)); // it should print 27
		System.out.println(fenwick.getSumRange(0, 10)); // it should print 31
		System.out.println(fenwick.getSumRange(0, 0)); // it should print 3
		
		in.close();
	}
}
