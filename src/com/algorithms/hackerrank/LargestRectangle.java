package com.algorithms.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] heights = new int[scanner.nextInt()];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = scanner.nextInt();
		}
		System.out.println(maxRectangleArea(heights));
		scanner.close();
	}

	public static int maxRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(heights[0]);

		int adjacentBuildings = 0;
		int maxRectangleArea = 0;
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] >= stack.peek()) {
				stack.push(heights[i]);
				continue;
			}

			adjacentBuildings = 0;
			while (!stack.isEmpty() && stack.peek() > heights[i]) {
				adjacentBuildings += 1;
				maxRectangleArea = Math.max(maxRectangleArea, (adjacentBuildings * stack.pop()));
			}

			for (int j = 0; j < adjacentBuildings + 1; j++) {
				stack.push(heights[i]);
			}
		}

		adjacentBuildings = 0;
		while (!stack.isEmpty()) {
			adjacentBuildings += 1;
			maxRectangleArea = Math.max(maxRectangleArea, (adjacentBuildings * stack.pop()));
		}

		return maxRectangleArea;
	}
}
