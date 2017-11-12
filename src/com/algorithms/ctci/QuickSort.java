package com.algorithms.ctci;

public class QuickSort {

	private static void quickSort(int[] arr, int from, int to) {
		if (to <= from) return;
		
		int pivot = arr[to];
		int x = from - 1;
		
		for (int i = from; i < to; i++) {
			if (arr[i] <= pivot) {
				x++;
				int aux = arr[i];
				arr[i] = arr[x];
				arr[x] = aux;
			}
		}
		arr[to] = arr[x + 1];
		arr[x + 1] = pivot;
		
		quickSort(arr, from, x);
		quickSort(arr, x + 2, to);
	}
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, 20};
		quickSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
