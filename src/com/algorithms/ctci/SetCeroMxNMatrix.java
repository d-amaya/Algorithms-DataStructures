package com.algorithms.ctci;

import java.util.HashSet;
import java.util.Set;

public class SetCeroMxNMatrix {

	public static void main(String[] args) {
		int[][] m = {
				{0,   2,  3,  4,  5},
				{6,   7,  0,  9,  0},
				{11, 12, 13, 14, 10}
		};
		
		setCeroMatrix(m);
		
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[r].length; c++) {
				System.out.print(m[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	private static void setCeroMatrix(int[][] m) {
		Set<Integer> rows = new HashSet<>();
		Set<Integer> columns = new HashSet<>();
		
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[r].length; c++) {
				if (m[r][c] == 0) {
					rows.add(r);
					columns.add(c);
				}
			}
		}
		
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[r].length; c++) {
				if (rows.contains(r) || columns.contains(c)) {
					m[r][c] = 0;
				}
			}
		}
	}
}
