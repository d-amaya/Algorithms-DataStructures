package com.algorithms.hackerrank;
import java.util.LinkedList;
import java.util.List;

public class Fibonacci {
	
	private static final long NUMBER_TEST = 1000000000000000000L;

	public static void main(String[] args) {
		List<Long> serie = fibonacci(NUMBER_TEST);
		serie.forEach(number -> System.out.print(number + " "));
	}

	private static List<Long> fibonacci(long top) {
		LinkedList<Long> serie = new LinkedList<Long>();
		serie.add(0L);
		serie.add(1L);
		getFibonacciSerie(serie, top, 2);
		return serie;
	}

	private static void getFibonacciSerie(List<Long> serie, long top, int index) {
		long result = serie.get(index - 2) + serie.get(index - 1);
		if (result > top)
			return;
		serie.add(result);
		getFibonacciSerie(serie, top, index + 1);
	}

}
