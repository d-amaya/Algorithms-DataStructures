package com.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;

public class MrKMarsh {

	private static class Fence {
		int vertical = 0;
		int horizontal = 0;

		public Fence(int vertical, int horizontal) {
			this.vertical = vertical;
			this.horizontal = horizontal;
		}

		@Override
		public String toString() { return "" + this.vertical + "|" + this.horizontal; }
	}

	private static long calculatePerimeter(Fence[][] dp) {
		long longestPerimeter = Long.MIN_VALUE;
		long maxSumBorders = 0;
		
		for (int r = dp.length - 1; r > 0; r--) {
			for (int c = dp[0].length - 1; c > 0; c--) {
				int vertical = dp[r][c].vertical - 1;
				int horizontal = dp[r][c].horizontal - 1;
				long sumBorders = vertical + horizontal;
				if (sumBorders >= 2 && sumBorders > maxSumBorders) {
					for (int i = r - vertical; i < r; i++) {
						if (dp[i][c].horizontal >= 2) {
							horizontal = Math.min(dp[r][c].horizontal - 1, dp[i][c].horizontal - 1);
							sumBorders = vertical + horizontal;
							if (sumBorders > maxSumBorders) {
								for (int j = c - horizontal; j < c; j++) {
									sumBorders = vertical + horizontal;
									if (sumBorders <= maxSumBorders) break;
									
									if (dp[r][j].vertical >= vertical) {
										maxSumBorders = sumBorders;
										longestPerimeter = Math.max(longestPerimeter, (horizontal + vertical) * 2);
									}
									
									horizontal--;
								}
							}
						}
						vertical--;
					}
				}
			}
		}
		
		return longestPerimeter;
	}

	private static long findLargesPerimeter(char[][] land, int rows, int columns) {
		Fence[][] dp = new Fence[rows][columns];
		
		dp[0][0] = (land[0][0] == '.') ? new Fence(1, 1) : new Fence(0, 0);
		for (int c = 1; c < columns; c++) 
			dp[0][c] = (land[0][c] == '.') ? new Fence(1, dp[0][c - 1].horizontal + 1) : new Fence(0, 0);
		for (int r = 1; r < rows; r++) 
			dp[r][0] = (land[r][0] == '.') ? new Fence(dp[r - 1][0].vertical + 1, 1) : new Fence(0, 0);
			
		for (int r = 1; r < rows; r++) {
			for (int c = 1; c < columns; c++) {
				dp[r][c] = (land[r][c] == '.') ? new Fence(dp[r - 1][c].vertical + 1, dp[r][c - 1].horizontal + 1) : new Fence(0, 0);
			}
		}
		
		return calculatePerimeter(dp);
	}

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		int r = in.nextInt();
		int c = in.nextInt();
		in.nextLine();

		char[][] land = new char[r][c];
		for (int i = 0; i < r; i++) {
			land[i] = in.nextLine().toCharArray();
		}

		long perimeter = findLargesPerimeter(land, r, c);
		System.out.println(perimeter > 0 ? perimeter : "impossible");
		in.close();
	}
}
