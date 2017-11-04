package com.algorithms.ctci;

public class TreeNode {
	private int value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public TreeNode addNode(int value) {
		if (value <= this.value) {
			if (this.left != null) {
				this.left.addNode(value);
			} else {
				this.left = new TreeNode(value);
			}
		} else {
			if (this.right != null) {
				this.right.addNode(value);
			} else {
				this.right = new TreeNode(value);
			}
		}
		return this;
	}
	
	public void printPreOrder() {
		preOrderTraversal(this);
	}
	
	private void preOrderTraversal(TreeNode node) {
		if (node == null) return;
		System.out.print(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}
