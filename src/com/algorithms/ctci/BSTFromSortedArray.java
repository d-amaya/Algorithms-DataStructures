package com.algorithms.ctci;

public class BSTFromSortedArray {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode root = turnArrayIntoBST(array);
		root.printPreOrder();
	}

	public static TreeNode turnArrayIntoBST(int[] array) {
		return buildBST(array, 0, array.length - 1);
	}

	private static TreeNode buildBST(int[] arr, int i, int j) {
		if (j < i) return null;
		if (i == j) return new TreeNode(arr[j]);
		
		int middle = (j + i) / 2;
		TreeNode treeNode = new TreeNode(arr[middle]);
		treeNode.setLeft(buildBST(arr, i, middle - 1));
		treeNode.setRight(buildBST(arr, middle + 1, j));
		return treeNode;
	}
}
