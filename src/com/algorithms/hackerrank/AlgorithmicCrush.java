package com.algorithms.hackerrank;

import java.util.Scanner;

public class AlgorithmicCrush {

	static class Operation {
        public int a;
        public int b;
        public int k;
    
        public Operation(int a, int b, int k) {
            this.a = a;
            this.b = b;
            this.k = k;
        }
    }
    
    public static long crush(int n, int m, Operation[] ops) {
        long[] crushState = new long[n+1];
        
        for(int i=0; i < m; i++) {
            crushState[ops[i].a-1] += ops[i].k;
            crushState[ops[i].b] -= ops[i].k;
        }
        
        long max = crushState[0];
        long sum = max;
        for(int i=1; i < n; i++) {
            sum += crushState[i];
            if(sum > max) {
                max = sum;
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Operation[] ops = new Operation[m];
        
        for(int i=0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            ops[i] = new Operation(a, b, k);
        }
        
        long max = crush(n, m, ops);
        System.out.println(max);
        
        in.close();
    }
}
