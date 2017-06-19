package com.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;

public class StockBuySell {

	private static long findMaximumProfit(int[] stock) {
        int n = stock.length;
        long maxProfit = 0;
        int maxPrice = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, stock[i]);
            maxProfit += maxPrice - stock[i];
        }
        
        return maxProfit;
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for (; t > 0; t--) {
            int[] stock = new int[in.nextInt()];
            for (int i = 0; i < stock.length; i++) stock[i] = in.nextInt();
            System.out.println(findMaximumProfit(stock));
        }
        
        in.close();
    }
}
