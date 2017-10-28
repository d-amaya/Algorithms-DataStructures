package com.algorithms.ctci;

public class RotateTheMatrix {

	private static void rotateMatrix(int[][] m) {
		int n = m.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = m[i][j];
				m[i][j] = m[n - j - 1][i];
				m[n - j - 1][i] = m[n - i - 1][n - j - 1];
				m[n - i - 1][n - j - 1] = m[j][n - i -1];
				m[j][n - i - 1] = tmp;
			}
		}
	}
	 
	public static void main(String[] args) {
		int[][] m = {
				{1,   2,  3,  4,  5},
				{6,   7,  8,  9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}
		};
		rotateMatrix(m);
	}
}
