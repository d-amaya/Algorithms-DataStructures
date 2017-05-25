package com.algorithms.hackerrank;

import java.util.*;

public class TwoArrays {
    
    private static boolean possiblePermutation(Integer[] a, Integer[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2.intValue() - n1.intValue();
            }
        });
        
        for (int i = 0; i < a.length; i++) {
            if (a[i].intValue() + b[i].intValue() < k) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();
        for (int qq = 0; qq < q; qq++) {
            int n = in.nextInt(), 
                k = in.nextInt();
            
            Integer[] a = new Integer[n], 
                      b = new Integer[n];
            
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int j = 0; j < n; j++) b[j] = in.nextInt();
            
            System.out.println(possiblePermutation(a, b, k) ? "YES" : "NO");
        }
        
        in.close();
    }
}
