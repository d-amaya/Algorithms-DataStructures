package com.algorithms.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int lines = scanner.nextInt();
		scanner.nextLine();

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> max = new Stack<Integer>();

		for (int i = 0; i < lines; i++) {
			String[] values = scanner.nextLine().split(" ");
			switch (Integer.parseInt(values[0])) {
			case 1:
				int newValue = Integer.parseInt(values[1]);
				stack.add(newValue);
				if (max.isEmpty() || newValue >= max.peek())
					max.add(newValue);
				break;
			case 2:
				int removed = stack.pop();
				if (!max.isEmpty() && removed == max.peek())
					max.pop();
				break;
			case 3:
				if (!max.isEmpty())
					System.out.println(max.peek());
				break;
			}
		}
		
		scanner.close();
	}
}
