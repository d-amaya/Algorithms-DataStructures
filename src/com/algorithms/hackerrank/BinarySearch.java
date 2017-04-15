package com.algorithms.hackerrank;

public class BinarySearch {
	
	private static int binarySearch(int number, int[] sortedArray, int i, int j) {
		if (j < i) return -1;
		
		int middle = (j + i) / 2;
		if (sortedArray[middle] == number) return middle;
		if (sortedArray[middle] < number) return binarySearch(number, sortedArray, middle + 1, j);
		return binarySearch(number, sortedArray, i, middle - 1);
	}
	
	private static int findNumberIndex(int number, int[] sortedArray) {
		return binarySearch(number, sortedArray, 0, sortedArray.length);
	}

	public static void main(String[] args) {
		int[] sortedArray = {1, 5, 6, 7, 9, 11, 15, 18, 22, 28, 36, 39, 40, 48, 52, 76, 78, 85, 90, 92, 93, 100};
		System.out.println(findNumberIndex(0, sortedArray));
	}
}
