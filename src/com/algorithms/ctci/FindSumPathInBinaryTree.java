package com.algorithms.ctci;

import java.util.LinkedList;
import java.util.Stack;

public class FindSumPathInBinaryTree {
	
	private static class Path {
		LinkedList<TreeNode> currentPath = new LinkedList<>();
		int currentSum = 0;
		
		public void printPath() {
			for (TreeNode node : currentPath) System.out.print(node.getValue() + " ");
			System.out.println();
		}
	}

	public static void findSumePaths(TreeNode root, int sum, Path path) {
		if (root == null) return;
		
		Stack<TreeNode> s = new Stack<>();
		
		while (!path.currentPath.isEmpty() && path.currentSum + root.getValue() > sum) {
			TreeNode head = path.currentPath.removeFirst();
			path.currentSum -= head.getValue();
			s.add(head);
		}
		
		path.currentPath.add(root);
		path.currentSum += root.getValue();
		
		if (path.currentSum == sum) path.printPath();
		
		findSumePaths(root.getLeft(), sum, path);
		findSumePaths(root.getRight(), sum, path);
		
		while (!s.isEmpty()) {
			path.currentSum += s.peek().getValue();
			path.currentPath.addFirst(s.pop());
		}
		
		path.currentPath.removeLast();
		path.currentSum -= root.getValue();
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(60)
				.addNode(30).addNode(20)
				.addNode(10).addNode(25)
				.addNode(50).addNode(40)
				.addNode(55).addNode(90)
				.addNode(70).addNode(80)
				.addNode(100);
		
		findSumePaths(root, 90, new Path());
	}
}
