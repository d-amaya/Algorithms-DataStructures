package com.algorithms.hackerrank.dynamicprogramming;

import java.util.*;

public class KnapsackProblem {
    
    private static int knapsack(int[] a, int k) {
        int[] dp = new int[k + 1];
        for (int i = 0; i < a.length; i++) {
            int value =  a[i];
            if (value <= k) {
                dp[value] = value;
                for (int j = value + 1; j < dp.length; j++) {
                    dp[j] = Math.max(dp[j], dp[j - value] + value);
                }
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for (; t > 0; t--) {
            int[] a = new int[in.nextInt()];
            int k = in.nextInt();
            
            for (int i = 0; i < a.length; i++) a[i] = in.nextInt();
            System.out.println(knapsack(a, k));
        }
        
        in.close();
    }
}
