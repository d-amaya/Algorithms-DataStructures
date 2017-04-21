package com.algorithms.hackerrank;

public class SortingLinkedList {
	
	private static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node sort(Node a) {
		if (a == null || a.next == null) return a;
		
		Node headLower = null, tailLower = null, headHigher = null, tailHigher = null;
		Node pivot = a;
		
		a = a.next;
		pivot.next = null;
		
		while (a != null) {
			if (a.data <= pivot.data) {
				if (headLower == null) {
					headLower = tailLower = a;
				} else {
					tailLower.next = a;
					tailLower = tailLower.next;
				}
				
				a = a.next;
				tailLower.next = null;
				
			} else {
				if (headHigher == null) {
					headHigher = tailHigher = a;
				} else {
					tailHigher.next = a;
					tailHigher = tailHigher.next;
				}
				
				a = a.next;
				tailHigher.next = null;
			}
			
		}
		
		headLower = sort(headLower);
		headHigher = sort(headHigher);
		
		Node x = headLower;
		if (x != null) {
			while (x.next != null) {
				x = x.next;
			}
			x.next = pivot;
			
		} else {
			headLower = pivot;
		}
		
		pivot.next = headHigher;
		return headLower;
	}
	
	public static void main(String args[]) {
		Node a = new Node(9);
		a.next = new Node(3);
		a.next.next = new Node(4);
		a.next.next.next = new Node(1);
		a.next.next.next.next = new Node(-2);
		a.next.next.next.next.next = new Node(0);
		a.next.next.next.next.next.next = new Node(1);
		a.next.next.next.next.next.next.next = new Node(8);
		a.next.next.next.next.next.next.next.next = new Node(10);
		
		a = sort(a);
		while (a != null) {
			System.out.print(a.data + " ");
			a = a.next;
		}
		
	}
}
