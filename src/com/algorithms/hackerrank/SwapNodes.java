package com.algorithms.hackerrank;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {

	public static class Node {
		public int level;
		public int data;
		public Node left;
		public Node right;
		
		public Node(int level, int data) {
			this.level = level;
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Queue<Node> queue = new LinkedList<Node>();
        Node root = new Node(1, 1);
        queue.add(root);
        
        int data = -1;
        int maxLevel = 1;
        int amountNodes = in.nextInt(); 
        for (int i = 0; i < amountNodes; i++) {
        	Node node = queue.remove();
        	
        	data = in.nextInt();
        	if (data != -1) {
        		Node left = new Node(node.level + 1, data);
        		maxLevel = Math.max(left.level, maxLevel);
        		node.left = left;
        		queue.add(left);
        	}
        	
        	data = in.nextInt();
        	if (data != -1) {
        		Node right = new Node(node.level + 1, data);
        		maxLevel = Math.max(right.level, maxLevel);
        		node.right = right;
        		queue.add(right);
        	}
        }
        
        int swapOperations = in.nextInt();
        for (int i = 0; i < swapOperations; i++) {
        	int swapLevel = in.nextInt();
        	int count = 1;
        	while ((swapLevel*count) < maxLevel) {
        		swap(root, (swapLevel*count));
        		count += 1;
        	}
        	print(root);
        	System.out.println();
        }
        
        in.close();
    }

	private static void swap(Node root, int swapLevel) {
		if (root == null) return;
		
		if (root.level < swapLevel) {
			swap(root.left, swapLevel);
			swap(root.right, swapLevel);
		} else {
			Node tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}
	}
	
	private static void print(Node root) {
		if (root == null) return;
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);
	}
}
