package com.algorithms.hackerrank;
import java.util.Scanner;

public class QuickSortInPlace {

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("unused")
	private static int hoarePartition(int[] arr, int l, int h) {
		int pivot = arr[h];
		int i = l, j = h - 1;

		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] >= pivot && j > l) j--;

			if (i <= j) {
				int aux = arr[j];
				arr[j] = arr[i];
				arr[i] = aux;
				i++;
				j--;
			}
		}

		arr[h] = arr[j + 1];
		arr[j + 1] = pivot;
		
		printArray(arr);
		
		return j + 1;
	}
	
	private static int lomutoPartition(int[] arr, int l, int h) {
		int pivot = arr[h];
		int pivotIndex = l - 1;
		
		for (int j = l; j < h; j++) {
			if (arr[j] <= pivot) {
				pivotIndex++;
				int aux = arr[pivotIndex];
				arr[pivotIndex] = arr[j];
				arr[j] = aux; 
			}
		}
		
		arr[h] = arr[pivotIndex + 1];
		arr[pivotIndex + 1] = pivot;
		return pivotIndex + 1;
	}

	private static void quickSortInPlace(int[] arr, int l, int h) {

		if (h <= l) return;
		int pivot = lomutoPartition(arr, l, h);
		quickSortInPlace(arr, l, pivot - 1);
		quickSortInPlace(arr, pivot + 1, h);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[in.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}

		quickSortInPlace(arr, 0, arr.length - 1);
		printArray(arr);
		
		in.close();
	}
}
