package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {
	
	public static int solution(List<List<Integer>> sequences, int lastAns, int queryType, int x, int y) {
		int seqIndex = (x ^ lastAns) % sequences.size();
		List<Integer> sequence = sequences.get(seqIndex);
		
		if (queryType == 1) {
			sequence.add(y);
		} else {
			lastAns = sequence.get(y % sequence.size());
			System.out.println(lastAns);
		}
		
		return lastAns;
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int lastAns = 0;
        int N = in.nextInt();
        int Q = in.nextInt();
        
        List<List<Integer>> sequences = new ArrayList<List<Integer>>(N);
        for (int i = 0; i < N; i++) {
        	sequences.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < Q; i++) {
        	lastAns = solution(sequences, lastAns, in.nextInt(), in.nextInt(), in.nextInt());
        }
        
        in.close();
    }
}
