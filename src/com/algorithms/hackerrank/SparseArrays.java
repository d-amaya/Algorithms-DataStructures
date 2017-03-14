package com.algorithms.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SparseArrays {

	public static class Node {
		public int data;
		public Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String values = in.nextLine();
		String[] data = values.split(" ");
		
		Node root = new Node(Integer.valueOf(data[0]));
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		try {
			for (int i = 1; i < data.length; i+=2) {
				Node node = q.remove();
				
				Node left = new Node(Integer.valueOf(data[i]));
				node.left = left;
				q.add(left);
				
				Node right = new Node(Integer.valueOf(data[i+1]));
				node.right = right;
				q.add(right);

			}
		} catch (Exception e) {
			System.out.print(checkBST(root) ? "Yes" : "No");
			in.close();
			return;
		}
		
		System.out.print(checkBST(root) ? "Yes" : "No");
		in.close();
	}
	
	// 4 2 6 1 3 5 7 yes
	// 8 4 13 2 6 10 14 1 3 5 7 9 11 12 15 yes
	// 8 4 13 2 6 10 16 1 3 5 7 9 11 12 15 No
	// 3 2 6 1 4 5 7
	public static boolean checkBST(Node root) {
		if (root == null)
			return true;
		
		if (root.left == null || root.left.data < root.data) {
			if (checkBST(root.left)) {
				if (root.right == null || root.right.data > root.data) {
					return checkBST(root.right);
				}
			}
		}
		return false;
	}
}
