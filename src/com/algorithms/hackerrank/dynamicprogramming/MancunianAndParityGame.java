package com.algorithms.hackerrank.dynamicprogramming;

import java.util.*;

public class MancunianAndParityGame {

    private static int smallestSizeSubsequence(int n, int[] A) {
        int result = -1;
        long total = 0;
        long[][] dp = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = A[i];
            total += A[i]; 
        }
        
        if (total % 2 == 0) return 0;
        
        for (int l = 1; result == -1 && l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                dp[i][j] = A[i] + dp[i][j - 1];
                
                if ((total - dp[i][j - 1]) % 2 == 0) {
                    result = j - i;
                    break;
                }
                
                if ((total - dp[i][j]) % 2 == 0) {
                    result = j - i + 1;
                    break;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int result = smallestSizeSubsequence(n, A);
        System.out.println(result);
    }
}
