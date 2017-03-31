package com.algorithms.hackerrank;

import java.util.Scanner;

public class CountingSort2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[100];
        
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr[in.nextInt()] += 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print(i + " ");
            }
        }
        
        in.close();
    }
}
