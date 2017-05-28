package com.algorithms.hackerrank;

import java.util.Stack;

public class AmazonCodingChallenge {
	
	public static void main(String[] args) {
		String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
		System.out.println(totalScore(blocks, 8));
		
		String[]blocks2 = {"1", "2", "+", "Z"};
		System.out.println(totalScore(blocks2, 4));
	}

	public static int totalScore(String[] blocks, int n) {
		Stack<Integer> scores = new Stack<Integer>();
		int totalScore = 0;

		for (int i = 0; i < n; i++) {
			if (blocks[i].matches("(-)?[0-9]+")) {
				scores.push(Integer.parseInt(blocks[i]));
				totalScore += scores.peek();

			} else if (blocks[i].equals("Z")) {
				int lastScore = scores.pop();
				totalScore -= lastScore;

			} else if (blocks[i].equals("X")) {
				int lastScore = scores.peek();
				lastScore *= 2;
				scores.push(lastScore);
				totalScore += (lastScore);

			} else if (blocks[i].equals("+")) {
				int score1 = scores.pop();
				int score2 = scores.peek();
				scores.push(score1);

				int lastScore = score1 + score2;
				scores.push(lastScore);
				totalScore += lastScore;
			}
		}

		return totalScore;
	}
}
