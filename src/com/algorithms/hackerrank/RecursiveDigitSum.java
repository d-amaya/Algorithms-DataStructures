package com.algorithms.hackerrank;

import java.util.*;

public class RecursiveDigitSum {
    
    private static String getdigitSum(String n, int k) {
        long digitSum = 0;
        for (int i = 0; i < n.length(); i++) {
            digitSum += n.charAt(i) - '0';
        }
        digitSum *= k;
        
        return String.valueOf(digitSum);
    }
    
    private static long calculateSuperDigit(String n) {
        if (n.length() == 1) return Integer.parseInt(n);
        
        long superDigit = 0;
        for (int i = 0; i < n.length(); i++) {
            superDigit += n.charAt(i) - '0';
        }
        
        return calculateSuperDigit(String.valueOf(superDigit));
    }
    
    private static long superDigit(String n, int k) {
        String digitSum = getdigitSum(n, k);
        return calculateSuperDigit(digitSum);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] values = in.nextLine().split(" ");
        
        String n = values[0];
        int k = Integer.parseInt(values[1]);
        
        System.out.println(superDigit(n, k));
        in.close();
    }
}
