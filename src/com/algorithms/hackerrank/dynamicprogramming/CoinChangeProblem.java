package com.algorithms.hackerrank.dynamicprogramming;

import java.util.*;

public class CoinChangeProblem {

    static long getWays(int n, int[] c) {
        long[] dp = new long[n + 1];
        for (int i = 0; i < c.length; i++) {
            int coin = c[i];
            if (coin <= n) {
                dp[coin] += 1;
                for (int j = coin + 1; j < dp.length; j++) dp[j] += dp[j - coin];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        
        for(int i = 0; i < m; i++)c[i] = in.nextInt();
        
        System.out.print(getWays(n, c));
        in.close();
    }
}
