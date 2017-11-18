package com.algorithms.ctci;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeFromPreOrderString {

	private static TreeNode buildTreeFromPreOrderTraversal(String s) {
		Queue<Integer> q = new LinkedList<>();
		for (char c : s.toCharArray()) q.add(Character.getNumericValue(c));
		return buildTree(q);
	}

	private static TreeNode buildTree(Queue<Integer> q) {
		if (q.isEmpty() || q.peek() == 0) {
			q.poll();
			return null;
		}
		
		TreeNode node = new TreeNode(q.poll());
		node.setLeft(buildTree(q));
		node.setRight(buildTree(q));
		return node;
	}
	
	public static void main(String[] args) {
		// Every char is node to make it simpler. 0 value means null.
		String preOrder = "12045000360070800";
		TreeNode root = buildTreeFromPreOrderTraversal(preOrder);
		root.printPreOrder(); // 1 2 4 5 3 6 7 8 
	}
}
