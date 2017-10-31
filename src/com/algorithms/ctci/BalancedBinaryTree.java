package com.algorithms.ctci;

public class BalancedBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(15)
				.addNode(13)
				.addNode(25)
				.addNode(20)
				.addNode(35)
				.addNode(7)
				.addNode(30);
		System.out.println(isBalancedBinaryTree(root) ? "YES" : "NO");
	}
	
	private static boolean isBalancedBinaryTree(TreeNode root) {
		return getHeight(root) != -1;
	}
	
	private static int getHeight(TreeNode node) {
		if (node == null) return 0;
		
		int heightLeft = getHeight(node.getLeft());
		int heightRight = getHeight(node.getRight());
		if (heightLeft == -1 || heightRight == -1) return -1;
		if (Math.abs(heightLeft - heightRight) > 1) return -1;
		return Math.max(heightLeft, heightRight) + 1;
	}
}
