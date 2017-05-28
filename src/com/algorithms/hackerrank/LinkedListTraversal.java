package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTraversal {

	private static class Node {
		int value;
		Node next;
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private static void printList(Node head) {
		Node x = head;
		while (x != null) {
			System.out.print(x.value + " ");
			x = x.next;
		}
		System.out.println();
	}
	
	private static void printMiddleValue(Node head) {
		if (head.next == null) {
			System.out.println("Middle value is: " + head.value);
			return;
		}
		
		List<Node> nodes = new ArrayList<Node>();
		Node x = head;
		int count = 0;
		while (x != null) {
			nodes.add(x);
			count += 1;
			x = x.next;
		}
		System.out.println("Middle value is: " + nodes.get(count/2 - 1).value);
	}
	
	public static void floydAlgorithm(Node head) {
		Node i = head, j = head;
		while (j != null && j.next != null) {
			j = j.next.next;
			if (j != null) i = i.next;
		}
		System.out.println("Middle value according to Floyd: " + i.value);
	}
	
	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, new Node(8, null))))))));
		printList(head);
		printMiddleValue(head);
		floydAlgorithm(head);
	}
}
