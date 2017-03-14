package com.algorithms.hackerrank;
import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Board> neighbors = new ArrayList<Board>();
	private int[][] blocks;
	private int n = 0;
	
	private int rowBlank = 0;
	private int colBlank = 0;
	
	public Board(int[][] blocks) {
		this.n = blocks.length;
		this.blocks = new int[this.n][this.n];
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				this.blocks[i][j] = blocks[i][j];
				if (this.blocks[i][j] == 0) {
					this.rowBlank = i;
					this.colBlank = j;
				}
			}
		}
		
	}

	public int dimension() {
		return this.n;
	}

	public int hamming() {
		int wrongBlocks = 0;
		for (int row = 0; row < this.n; row++) {
			for (int col = 0; col < this.n; col++) {
				int expectedPosition = (this.n * row) + col + 1;
				if (this.blocks[row][col] != expectedPosition && this.blocks[row][col] != 0) {
					wrongBlocks++;
				}
			}
		}
		return wrongBlocks;
	}

	public int manhattan() {
		int distance = 0;
		for (int row = 0; row < this.n; row++) {
			for (int col = 0; col < this.n; col++) {
				int expectedPosition = (this.n * row) + col + 1;
				if (this.blocks[row][col] != expectedPosition && this.blocks[row][col] != 0) {
					int correctRow = ((int) Math.ceil((double) this.blocks[row][col] / (double) this.n));
					int correctCol = this.n - ((correctRow * this.n) - this.blocks[row][col]) - 1;
					correctRow--;
					distance += Math.abs(row - correctRow) + Math.abs(col - correctCol);
				}
			}
		}
		return distance;
	}

	public boolean isGoal() {
		return hamming() == 0;
	}

	public Board twin() {
		Board board = null;
		int firstX = -1;
		int firstY = -1;
		
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				if (this.blocks[i][j] != 0) {
					if (firstX == -1) {
						firstX = i;
						firstY = j;
					} else {
						int[][] clone = cloneBlocks();
						int aux = clone[firstX][firstY];
						clone[firstX][firstY] = clone[i][j];
						clone[i][j] = aux;
						board = new Board(clone);
					}
				}
			}
		}
		
		return board;
	}

	
	public boolean equals(Object y) {
		if (y == this) {
			return true;
		}
		
		if (y == null || y.getClass() != this.getClass()) {
			return false;
		}
		
		int [][] object = ((Board) y).blocks;
		if (object.length != this.n) 
			return false;
		
		for (int i = 0; i < this.blocks.length; i++) {
			for (int j = 0; j < this.blocks.length; j++) {
				if (this.blocks[i][j] != object[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public Iterable<Board> neighbors() {
		if (this.neighbors.isEmpty()) {
			getNeighbors();
		}
		return this.neighbors;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(20);
		sb.append(this.n).append("\n");
		for (int i = 0; i < this.blocks.length; i++) {
			for (int j = 0; j < this.blocks.length; j++) {
				if (this.blocks[i][j] < 10) {
					sb.append(" ");
				}
				sb.append(this.blocks[i][j]).append(" "); 
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private void getNeighbors() {
		int [][] clone = null;
		if (this.rowBlank - 1 >= 0) {
			clone = cloneBlocks();
			clone[this.rowBlank][this.colBlank] = clone[this.rowBlank - 1][this.colBlank];
			clone[this.rowBlank - 1][this.colBlank] = 0;
			this.neighbors.add(new Board(clone));
		}
		
		if (this.rowBlank + 1 < this.n) {
			clone = cloneBlocks();
			clone[this.rowBlank][this.colBlank] = clone[this.rowBlank + 1][this.colBlank];
			clone[this.rowBlank + 1][this.colBlank] = 0;
			this.neighbors.add(new Board(clone));
		}
		
		if (this.colBlank - 1 >= 0) {
			clone = cloneBlocks();
			clone[this.rowBlank][this.colBlank] = clone[this.rowBlank][this.colBlank - 1];
			clone[this.rowBlank][this.colBlank - 1] = 0;
			this.neighbors.add(new Board(clone));
		}
		
		if (this.colBlank + 1 < this.n) {
			clone = cloneBlocks();
			clone[this.rowBlank][this.colBlank] = clone[this.rowBlank][this.colBlank + 1];
			clone[this.rowBlank][this.colBlank + 1] = 0;
			this.neighbors.add(new Board(clone));
		}
	}
	
	private int[][] cloneBlocks() {
		int [][] clone = new int[n][n];
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				clone[i][j] = this.blocks[i][j];
			}
		}
		return clone;
	}
}
