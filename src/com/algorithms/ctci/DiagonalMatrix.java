package com.algorithms.ctci;

public class DiagonalMatrix {

	public static String[][] createDiagonalMatrix(String s) {
		int n = s.length();
		String[][] m = new String[n][n];
		
		for (int i = 0; i < n; i++) m[i][i] = s.charAt(i) + "";
		
		for (int l = 1; l < n; l++) {
			for (int j = 0; j + l < n; j++) {
				m[j][j + l] = m[j][j + l - 1] + s.charAt(j + l);
			}
		}
		
		return m;
	}
	
	public static void main(String[] args) {
		String s = "abcde";
		String[][] m = createDiagonalMatrix(s);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + "-");
			}
			System.out.println();
		}
	}
}
