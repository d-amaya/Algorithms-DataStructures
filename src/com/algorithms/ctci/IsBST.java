package com.algorithms.ctci;

public class IsBST {

	public static boolean isBST(TreeNode node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(TreeNode node, int minValue, int maxValue) {
		if (node == null) return true;
		return node.getValue() >= minValue
			&& node.getValue() < maxValue
			&& isBST(node.getLeft(), minValue, node.getValue())
			&& isBST(node.getRight(), node.getValue(), maxValue);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(60)
				.addNode(30).addNode(20)
				.addNode(10).addNode(25)
				.addNode(50).addNode(40)
				.addNode(55).addNode(90)
				.addNode(70).addNode(80)
				.addNode(100);
		System.out.println(isBST(root) ? "YES" : "NO");
		
		//-------------------------- Not BST ----------------------
		TreeNode bad55Node = new TreeNode(55);
		bad55Node.setLeft(new TreeNode(25));  // Should be greater than 50
		
		root = new TreeNode(60)
				.addNode(30).addNode(20)
				.addNode(10).addNode(25)
				.addNode(50).addNode(40)
				.addNode(bad55Node)
				.addNode(90).addNode(70)
				.addNode(80).addNode(100);
		System.out.println(isBST(root) ? "YES" : "NO");
	}
}
