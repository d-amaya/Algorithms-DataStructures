package com.algorithms.hackerrank;

import java.util.Scanner;

public class CountingSort3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[100];
        
        int n = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(in.nextLine().split(" ")[0]);
            arr[index] += 1;
        }
        
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x += arr[i];
            System.out.print(x + " ");
        }
        
        in.close();
    }
}
