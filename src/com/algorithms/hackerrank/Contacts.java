package com.algorithms.hackerrank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {

	private static class Node {
		private char letter;
		private int wordsCounter = 0;
		private Map<Character, Node> children = new HashMap<Character, Node>();

		public Node(char letter) {
			this.letter = letter;
		}

		public Node getChild(char letter) {
			return this.children.get(letter);
		}

		public Node addChild(Node child) {
			return this.children.put(child.getLetter(), child);
		}

		public char getLetter() {
			return this.letter;
		}

		public void incrementWordsCounter() {
			this.wordsCounter++;
		}

		public int getWordsCounter() {
			return this.wordsCounter;
		}
	}

	private static class Trie {
		private Map<Character, Node> dictionary = new HashMap<Character, Node>();

		public int find(String prefix) {
			char[] letters = prefix.toCharArray();
			Node node = dictionary.get(letters[0]);

			for (int i = 1; i < letters.length && node != null; i++) {
				node = node.getChild(letters[i]);
			}

			if (node != null) {
				return node.getWordsCounter();
			}

			return 0;
		}

		public void add(String word) {
			char[] letters = word.toCharArray();

			Node node = dictionary.get(letters[0]);
			if (node == null) {
				node = new Node(letters[0]);
				dictionary.put(letters[0], node);
			}

			addNewLetter(node, letters, 1);
		}

		private void addNewLetter(Node node, char[] letters, int index) {
			node.incrementWordsCounter();

			if (index >= letters.length)
				return;

			Node nextNode = node.getChild(letters[index]);
			if (nextNode == null) {
				nextNode = new Node(letters[index]);
				node.addChild(nextNode);
			}
			addNewLetter(nextNode, letters, index + 1);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String[] operation = in.nextLine().split(" ");
			if (operation[0].equals("add")) {
				trie.add(operation[1]);
			} else {
				System.out.println(trie.find(operation[1]));
			}
		}
		
		in.close();
	}
}
