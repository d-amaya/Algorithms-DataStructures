package com.algorithms.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CastleOnTheGrid {

	private static Coordinate[][] visitedFrom;
	private static int[][] weightedVisit;
	private static char[][] matrix;

	private static class Coordinate {
		public int x;
		public int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	private static void getAdjacentPaths(Queue<Coordinate> q, Coordinate c) {
		
		if (c.x > 0 && matrix[c.x - 1][c.y] == '.') {
			int weight = (visitedFrom[c.x][c.y] == null || c.y == visitedFrom[c.x][c.y].y) ? weightedVisit[c.x][c.y] : weightedVisit[c.x][c.y] + 1;
			if (weightedVisit[c.x - 1][c.y] == 0 || weightedVisit[c.x - 1][c.y] > weight) {
				visitedFrom[c.x - 1][c.y] = c;
				q.add(new Coordinate(c.x - 1, c.y));
				weightedVisit[c.x - 1][c.y] = weight;
			}
		}

		if (c.y > 0 && matrix[c.x][c.y - 1] == '.') {
			int weight = (visitedFrom[c.x][c.y] == null || c.x == visitedFrom[c.x][c.y].x) ? weightedVisit[c.x][c.y] : weightedVisit[c.x][c.y] + 1;
			if (weightedVisit[c.x][c.y - 1] == 0 || weightedVisit[c.x][c.y - 1] > weight) {
				visitedFrom[c.x][c.y - 1] = c;
				weightedVisit[c.x][c.y - 1] = weight;
				q.add(new Coordinate(c.x, c.y - 1));
			} 
		}

		if (c.y < matrix.length - 1 && matrix[c.x][c.y + 1] == '.') {
			int weight = (visitedFrom[c.x][c.y] == null || c.x == visitedFrom[c.x][c.y].x) ? weightedVisit[c.x][c.y] : weightedVisit[c.x][c.y] + 1;
			if (weightedVisit[c.x][c.y + 1] == 0 || weightedVisit[c.x][c.y + 1] > weight) {
				visitedFrom[c.x][c.y + 1] = c;
				q.add(new Coordinate(c.x, c.y + 1));
				weightedVisit[c.x][c.y + 1] = weight;
			}
		}
		
		if (c.x < matrix.length - 1 && matrix[c.x + 1][c.y] == '.') {
			int weight = (visitedFrom[c.x][c.y] == null || c.y == visitedFrom[c.x][c.y].y) ? weightedVisit[c.x][c.y] : weightedVisit[c.x][c.y] + 1;
			if (weightedVisit[c.x + 1][c.y] == 0 || weightedVisit[c.x + 1][c.y] > weight) {
				visitedFrom[c.x + 1][c.y] = c;
				q.add(new Coordinate(c.x + 1, c.y));
				weightedVisit[c.x + 1][c.y] = weight;
			}
		}
	}

	private static int shorestPathMovements(int x1, int y1, int x2, int y2) {
		if ((x1 == x2 && y1 == y2) || (matrix[x2][y2] == 'X'))
			return 0;

		Queue<Coordinate> q = new LinkedList<Coordinate>();
		q.add(new Coordinate(x1, y1));
		weightedVisit[x1][y1] = 1;

		while (!q.isEmpty()) {
			getAdjacentPaths(q, q.remove());
		}
		
		return weightedVisit[x2][y2];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = Integer.parseInt(in.nextLine());
		visitedFrom = new Coordinate[n][n];
		weightedVisit = new int[n][n];
		matrix = new char[n][n];

		for (int i = 0; i < n; i++) {
			String value = in.nextLine();
			for (int j = 0; j < n; j++) {
				matrix[i][j] = value.charAt(j);
			}
		}

		int movements = shorestPathMovements(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		System.out.print(movements);

		in.close();
	}
}
