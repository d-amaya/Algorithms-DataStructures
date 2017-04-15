package com.algorithms.hackerrank;

public class FloydCycleLinkedList {

	private static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next.next = new Node(10);
		
		// Creating the cycle
		head.next.next.next.next.next.next.next.next.next.next = head.next.next.next.next.next;
		
		breakCycle(head);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private static void breakCycle(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (fast == slow) removeCycle(slow, head);
		}
	}

	private static void removeCycle(Node slow, Node head) {
		Node cycle = head;
		Node x = slow;
		
		while (cycle != null) {
			while (x != null) {
				if (x.next == cycle){
					x.next = null;
					return;
				}
				
				x = x.next;
				if (x == slow) break; 
			}
			cycle = cycle.next;
		}
	}
}
