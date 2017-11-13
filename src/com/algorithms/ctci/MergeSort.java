package com.algorithms.ctci;

public class MergeSort {

	public static int[] mergeSort(int[] arr, int i, int j) {
		int[] merged;
		
		if (j <= i) {
			merged = new int[1];
			merged[0] = arr[i];
			return merged;
		}
		
		int middle = (j + i) / 2;
		int[] left = mergeSort(arr, i, middle);
		int[] right = mergeSort(arr, middle + 1, j);
		
		int pos = 0, l = 0, r = 0;
		merged = new int[left.length + right.length];
		
		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				merged[pos] = left[l];
				l++;
			} else {
				merged[pos] = right[r];
				r++;
			}
			pos++;
		}
		
		for (; r < right.length; r++) {
			merged[pos] = right[r];
			pos++;
		}
		
		for (; l < left.length; l++) {
			merged[pos] = left[l];
			pos++;
		}
		
		return merged;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, 20};
		arr = mergeSort(arr, 0, arr.length - 1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
