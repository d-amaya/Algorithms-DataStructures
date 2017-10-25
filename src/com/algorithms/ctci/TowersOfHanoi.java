package com.algorithms.ctci;

import java.util.Stack;

public class TowersOfHanoi {

	private Stack<Integer> first = new Stack<>();
	private Stack<Integer> second = new Stack<>();
	private Stack<Integer> third = new Stack<>();
	
	public TowersOfHanoi(int disks) {
		if (disks <= 0) throw new IllegalArgumentException();
		for (int i = disks; i > 0; i--) first.push(i);
	}
	
	private Stack<Integer> getStack(int stack) {
		return stack == 1 ? first : (stack == 2 ? second : third);
	}
	
	private void moveRight(int stack) {
		if (stack == 3) return;
		
		Stack<Integer> current = getStack(stack);
		Stack<Integer> next = getStack(stack + 1);
		
		while (!next.isEmpty() && next.peek() < current.peek()) moveLeft(stack + 1);
		next.push(current.pop());
		moveRight(stack + 1);
	}

	private void moveLeft(int stack) {
		if (stack == 1) return;
		
		Stack<Integer> current = getStack(stack);
		Stack<Integer> prev = getStack(stack - 1);
		
		while (!prev.isEmpty() && prev.peek() < current.peek()) moveRight(stack - 1);
		prev.push(current.pop());
		moveLeft(stack - 1);
	}
	
	public Stack<Integer> processTowers() {
		while (!first.isEmpty()) moveRight(1);
		return third;
	}
	
	public static void main(String[] args) {
		TowersOfHanoi toh = new TowersOfHanoi(4);
		Stack<Integer> stack = toh.processTowers();
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
