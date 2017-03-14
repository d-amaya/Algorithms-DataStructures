package com.algorithms.hackerrank;
import java.math.BigDecimal;
import java.util.Scanner;

public class FibonacciModified {

	private static void calculateFibonacci(String[] serie, int index) {
		if (index > serie.length - 1) return;
		serie[index] = new BigDecimal(serie[index - 2]).add(new BigDecimal(serie[index - 1]).pow(2)).toString();
		calculateFibonacci(serie, index + 1);
	}

	private static String fibonacci(String t1, String t2, int n) {
		String[] serie = new String[n];
		serie[0] = t1;
		serie[1] = t2;
		calculateFibonacci(serie, 2);
		return serie[n - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		System.out.print(fibonacci(input[0], input[1], Integer.parseInt(input[2])));
		scanner.close();
	}
}
