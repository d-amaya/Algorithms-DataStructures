package com.algorithms.hackerrank;
import java.util.LinkedList;
import java.util.Queue;

public class RebuildTree {
	
	public static class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void printPreorder(Node root) {
		if (root == null) return;
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	public static Node buildTree(Queue<Integer> q, int[] indexes, int[] inOrderValues, int i, int j) {
		int data = q.remove();
		Node root = new Node(data);
		
		int indexData = indexes[data];
		if (indexData > i) 
			root.left = buildTree(q, indexes, inOrderValues, i, indexData-1);
		if (indexData < j) 
			root.right = buildTree(q, indexes, inOrderValues, indexData+1, j);
		return root;
	}

	public static void main(String[] args) {
		int maxNumber = 15;
		int[] indexes = new int[maxNumber];
		int[] preOrder = {1, 2, 4, 5, 3};
		int[] inOrder =  {4, 2, 5, 1, 3};
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < preOrder.length; i++) {
			q.add(preOrder[i]);
			indexes[inOrder[i]] = i;
		}
		
		Node root = buildTree(q, indexes, inOrder, 0, inOrder.length - 1);
		printPreorder(root);
		System.out.println();
		
		//-----------------------------------------
		
		int[] preOrder2 = {1,2,4,8,5,9,3,6,7,10,11};
		int[] inOrder2 =  {4,8,2,9,5,1,6,3,10,7,11};
		int[] indexes2 = new int[maxNumber];
		
		q = new LinkedList<Integer>();
		for (int i = 0; i < preOrder2.length; i++) {
			q.add(preOrder2[i]);
			indexes2[inOrder2[i]] = i;
		}
		
		root = buildTree(q, indexes2, inOrder2, 0, inOrder2.length - 1);
		printPreorder(root);
		System.out.println();
	}
}
