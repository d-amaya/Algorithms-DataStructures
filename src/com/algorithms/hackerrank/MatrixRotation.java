package com.algorithms.hackerrank;

public class MatrixRotation {
	
	public void rotate(int[][] matrix) {
		rotateMatrix(matrix, 0);
	}
	
	private int[] saveTop(int[][] matrix, int layer, int i, int j) {
		int[] top = new int[j + 1];
		for (int x = layer; x < top.length; x++) {
			top[x] = matrix[layer][x]; 
		}
		return top;
	}
	
	private void rotateMatrix(int[][] matrix, int layer) {
		int i = layer, j = matrix.length - 1 - layer;
		if (j <= i) return;
		
		int[] top = saveTop(matrix, layer, i, j);

		// Rotate left to top
		for (int x = layer; x <= j; x++) {
			matrix[i][matrix.length - 1 - x] = matrix[x][i];
		}
		
		// Rotate bottom to left
		for (int x = layer; x <= j; x++) {
			matrix[x][i] = matrix[j][x];
		}
		
		// Rotate right to bottom
		for (int x = j; x >= layer; x--) {
			matrix[j][matrix.length - 1 - x] = matrix[x][j];
		}
		matrix[j][matrix.length - 1 - layer] = top[j];
		
		// Rotate top to right
		for (int x = j; x >= layer; x--) {
			matrix[x][j] = top[x];
		}
		
		rotateMatrix(matrix, layer + 1);
		
	}

	public static void main(String[] args) {
		//int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		int[][] matrix = { {1,   2,  3,  4,  5}, 
                       {6,   7,  8,  9, 10}, 
                       {11, 12, 13, 14, 15}, 
                       {16, 17, 18, 19, 20}, 
                       {21, 22, 23, 24, 25} };
                       
		MatrixRotation matrixRotation = new MatrixRotation();
		matrixRotation.rotate(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
