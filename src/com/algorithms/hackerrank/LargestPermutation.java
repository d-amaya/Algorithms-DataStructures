package com.algorithms.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LargestPermutation {

	private static int[] mergeSort(int[] numbers, int from, int to) {
        if (to - from <= 1) {
            int[] sorted = new int[to - from + 1];
            sorted[0] = numbers[from];
            if (sorted.length > 1) {
                if (numbers[to] > sorted[0]) {
                    sorted[1] = sorted[0];
                    sorted[0] = numbers[to];
                } else {
                    sorted[1] = numbers[to];
                }
            }
            return sorted;
        }
        
        int middle = (from + to) / 2;
        int[] left = mergeSort(numbers, from, middle);
        int[] right = mergeSort(numbers, middle + 1, to);
        
        int[] merge = new int[left.length + right.length];
        int i = 0, j = 0, pos = 0;
        while (i < left.length || j < right.length) {
            int value = Math.max((i < left.length ? left[i] : Integer.MIN_VALUE), 
                                 (j < right.length ? right[j] : Integer.MIN_VALUE));
            merge[pos] = value;
            pos++;
            if (i < left.length && value == left[i]) i++; else j++;
        }
        return merge;
    }
    
    private static int[] largestPermutation(int[] numbers, int k) {
        int[] sorted = mergeSort(numbers, 0, numbers.length - 1);
        if (k >= numbers.length) return sorted;

        int x = 0, y = numbers.length - 1;
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < sorted.length && k > 0; i++) {
            if (visited.contains(sorted[i]) || y <= x) {
                y = numbers.length - 1;  
                visited.clear();
            }
            
            while (y > x && numbers[y] != sorted[i]) {
                visited.add(numbers[y]);
                y--;    
            }
            
            while (x < numbers.length && x < y && numbers[x] >= sorted[i]) x++;
          
            if (x < y) {
              numbers[y] = numbers[x];
              numbers[x] = sorted[i];
              k--;
            }
            x++;
        }
      
        return numbers;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        
        int[] largestPermutation = largestPermutation(numbers, k);
        for (int i = 0; i < largestPermutation.length; i++) {
            System.out.print(largestPermutation[i] + " ");
        }
        
        in.close();
    }
}
