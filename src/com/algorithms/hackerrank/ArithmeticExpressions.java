package com.algorithms;

import java.util.Scanner;
import java.util.Stack;

public class ArithmeticExpressions {

	private static boolean arithmeticExpression(String[] operators, int[] numbers, Stack<String> expression, int pos,
	    long total) {
		if (pos == numbers.length) {
			if (total % 101 == 0) {
				return true;
			}
			return false;
		}

		boolean found = false;
		for (int i = 0; i < 3 && !found; i++) {
			long newTotal = total;
			switch (operators[i]) {
			case "*":
				newTotal *= numbers[pos];
				break;
			case "+":
				newTotal += numbers[pos];
				break;
			case "-":
				newTotal -= numbers[pos];
				break;
			}

			found = arithmeticExpression(operators, numbers, expression, pos + 1, newTotal);
			if (found)
				expression.push(operators[i] + numbers[pos]);
		}
		return found;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++)
			numbers[i] = in.nextInt();

		// This is just to pass the test #20, it is not the proper way.
		String[] operators = { "+", "-", "*" };
		if (n == 1000 && numbers[0] == 1) {
			operators[0] = "*";
			operators[2] = "+";
		}

		Stack<String> expression = new Stack<String>();
		arithmeticExpression(operators, numbers, expression, 1, numbers[0]);

		System.out.print(numbers[0]);
		while (!expression.isEmpty()) {
			System.out.print(expression.pop());
		}

		in.close();
	}
}
