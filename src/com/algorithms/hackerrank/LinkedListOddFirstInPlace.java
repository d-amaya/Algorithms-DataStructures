package com.algorithms.hackerrank;

public class LinkedListOddFirstInPlace {

	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private static void oddFirst(Node head) {
		Node evenHead = head.next;

		Node x = head;
		Node y = evenHead;
		while (x.next != null && y.next != null) {
			x.next = y.next;
			x = x.next;
			y.next = x.next;
			y = y.next;
		}

		x.next = evenHead;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, null)))))));

		oddFirst(head);
		
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
