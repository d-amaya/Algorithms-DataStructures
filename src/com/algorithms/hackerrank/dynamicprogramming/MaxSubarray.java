package com.algorithms.hackerrank.dynamicprogramming;

import java.util.*;

public class MaxSubarray {

    private static int getMaxContiguousSubarray(int[] arr) {
        int[] dp = new int[arr.length];
        int maxSum = arr[0];
        dp[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] > 0 ? arr[i] + dp[i - 1] : arr[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
    
    private static int getMaxNoContiguousSubarray(int[] arr) {
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(maxSum, maxSum + arr[i]);
            maxSum = Math.max(maxSum, arr[i]);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int[] arr = new int[in.nextInt()];
            for (int j = 0; j < arr.length; j++) arr[j] = in.nextInt();
            System.out.println(getMaxContiguousSubarray(arr) + " " + getMaxNoContiguousSubarray(arr));
        }
    }
}
