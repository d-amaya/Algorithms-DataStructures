package com.algorithms.hackerrank;

import java.util.*;

public class BigSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i = 0; unsorted_i < n; unsorted_i++) unsorted[unsorted_i] = in.next();
        
        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length()) return -1;
                if (s1.length() > s2.length()) return 1;
                
                int i = 0;
                for (; i < s1.length() && s1.charAt(i) == s2.charAt(i); i++);
                
                if (i == s1.length()) return 0;
                return ((int) s1.charAt(i)) < ((int) s2.charAt(i)) ? -1 : 1;
            }
        });
        
        for (int i = 0; i < unsorted.length; i++) System.out.println(unsorted[i]);
        
        in.close();
    }
}
