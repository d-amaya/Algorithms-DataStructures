package com.algorithms.hackerrank;

import java.util.Scanner;

public class LeftRotation {

	public static int[] rotate(int[] arr, int r) {
        int[] clone = new int[arr.length];
        for (int i = r; i < arr.length; i++) {
            clone[i] = arr[i];
        }
        
        for (int i = 0; i < r; i++) {
            clone[i] = arr[i];
        }
        
        return clone;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        rotate(arr, r);
        scanner.close();
    }
}
