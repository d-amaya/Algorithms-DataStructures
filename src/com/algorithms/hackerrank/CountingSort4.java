package com.algorithms.hackerrank;

import java.util.Scanner;

public class CountingSort4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        
        StringBuilder[] arr = new StringBuilder[100];
        for (int i = 0; i < n; i++) {
            String[] values = in.nextLine().split(" ");
            int x = Integer.parseInt(values[0]);
            String s = values[1];
            
            if (i < (n / 2)) 
                s = "-";
            
            StringBuilder sb = arr[x];
            if (sb == null)  {
                sb = new StringBuilder(n);
                arr[x] = sb;
            }
            
            sb.append(s);
            sb.append(" ");
        }
        
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = arr[i];
            if (sb != null) {
                System.out.print(sb.toString());
            }
        }
        
        in.close();
    }
}
