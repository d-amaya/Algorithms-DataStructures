package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopFiveNumbers {

	private static class HeapQueue<T extends Comparable<T>> {
		private List<T> elements = null;

		public HeapQueue(int initialCapacity) {
			this.elements = new ArrayList<T>(initialCapacity);
			this.elements.add(null);
		}

		public void add(T element) {
			this.elements.add(element);
			swim(size());
		}

		public T remove() {
			T priorityElement = this.elements.get(1);
			exchange(1, size());
			this.elements.remove(size());
			sink(1);
			return priorityElement;
		}

		private int size() {
			return this.elements.size() - 1;
		}

		private void swim(int i) {
			while (i > 1) {
				int parent = i / 2;
				if (less(i, parent))
					break;
				exchange(i, parent);
				i = parent;
			}
		}

		private void sink(int i) {
			int j = i * 2;
			while (j <= size()) {
				if (less(j, j + 1))
					j = j + 1;
				if (!less(i, j))
					break;
				exchange(i, j);
				i = j;
				j = i * 2;
			}
		}

		private boolean less(int i, int j) {
			if (i <= size() && j <= size())
				return this.elements.get(i).compareTo(this.elements.get(j)) < 0;
			return false;
		}

		private void exchange(int i, int j) {
			T tmp = this.elements.get(i);
			this.elements.set(i, this.elements.get(j));
			this.elements.set(j, tmp);
		}
	}

	private static int[] printTopFiveNumbersPriorityQueue(int[] numbers, int top) {
		// Queue<Integer> q = new PriorityQueue<Integer>(numbers.length, (o1, o2) -> o2 - o1);
		HeapQueue<Integer> q = new HeapQueue<Integer>(numbers.length);
		for (int number : numbers) {
			q.add(number);
		}

		int[] topMaxNumbers = new int[top];
		for (int i = 0; i < top; i++) {
			topMaxNumbers[i] = q.remove();
		}

		return topMaxNumbers;
	}

	private static int[] printTopFiveNumbersInsertionSort(int[] numbers, int top) {
		int[] topMaxNumbers = new int[top];

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > topMaxNumbers[top - 1]) {
				topMaxNumbers[top - 1] = numbers[i];
				for (int j = top - 1; j > 0; j--) {
					if (topMaxNumbers[j - 1] >= topMaxNumbers[j])
						break;
					topMaxNumbers[j] = topMaxNumbers[j - 1];
					topMaxNumbers[j - 1] = numbers[i];
				}
			}
		}

		StringBuilder s = new StringBuilder("");
		s.delete(s.length() - Integer.parseInt("3"), s.length());
		s.substring(s.length() - Integer.parseInt("3"), s.length());
		s.replace(0, s.length(), "");
		System.out.println(s.charAt(2));
		return topMaxNumbers;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int[] numbers = new int[count];
		for (int i = 0; i < count; i++) {
			numbers[i] = scanner.nextInt();
		}

		System.out.println();

		long initialTime = System.currentTimeMillis();
		printTopFiveNumbersPriorityQueue(numbers, 20000);
		System.out.println("printTopFiveNumbersPriorityQueue method takes " + (System.currentTimeMillis() - initialTime)
				+ " milliseconds to get things done.");
		System.out.println();

		initialTime = System.currentTimeMillis();
		printTopFiveNumbersInsertionSort(numbers, 20000);
		System.out.println("printTopFiveNumbersInsertionSort method takes " + (System.currentTimeMillis() - initialTime)
				+ " milliseconds to get things done.");
		System.out.println();

		scanner.close();
	}
}