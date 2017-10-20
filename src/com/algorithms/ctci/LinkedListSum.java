package com.algorithms.ctci;

public class LinkedListSum {

	private static class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		public Node addNode(int nodeValue) {
			Node temp = this;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(nodeValue);
			return this;
		}
	}
	
	private static Node sumNodes(Node n1, Node n2, int carrier) {
		if (n1 == null && n2 == null) {
			if (carrier == 0) return null;
			return new Node(carrier);
		}
		
		int carry = 0;
		int value = carrier + (n1 == null ? 0 : n1.value) + (n2 == null ? 0 : n2.value);
		
		if (value >= 10) {
			value -= 10;
			carry = 1;
		}
		
		Node result = new Node(value);
		result.next = sumNodes(n1 == null ? null : n1.next, n2 == null ? null : n2.next, carry);
		return result;
	}
	
	private static Node reverseLinkedList(Node previous, Node node) {
		if (node == null) return previous;
		Node tmpNext = node.next;
		node.next = previous;
		return reverseLinkedList(node, tmpNext);
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(9).addNode(9).addNode(9).addNode(9);
		Node n2 = new Node(9).addNode(9).addNode(9);
		
		Node sum = sumNodes(n1, n2, 0);
		while (sum != null) {
			System.out.print(sum.value + " ");
			sum = sum.next;
		}
		
		System.out.println();
		
		Node head = reverseLinkedList(null, n1);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}
