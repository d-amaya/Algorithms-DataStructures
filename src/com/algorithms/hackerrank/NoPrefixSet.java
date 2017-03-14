package com.algorithms.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoPrefixSet {

	private static class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		public boolean isFinal = false;
		public char value;

		public TrieNode(char value) {
			this.value = value;
		}

		public void addChild(TrieNode node) {
			children.put(node.value, node);
		}

		public TrieNode getChild(char value) {
			return children.get(value);
		}
	}

	private static class Trie {
		private Map<Character, TrieNode> root = new HashMap<Character, TrieNode>();

		public boolean addWord(String word) {
			char[] letters = word.toCharArray();

			TrieNode node = root.get(letters[0]);
			if (node == null) {
				node = new TrieNode(letters[0]);
				root.put(letters[0], node);
			} else if (letters.length == 1 && node.isFinal) {
				return false;
			}

			return isGoogSet(1, letters, node);
		}

		private boolean isGoogSet(int index, char[] letters, TrieNode node) {
			if (index == letters.length) {
				node.isFinal = true;
				return true;
			}

			TrieNode nextNode = node.getChild(letters[index]);
			if (nextNode == null) {
				nextNode = new TrieNode(letters[index]);
				node.addChild(nextNode);
			} else if (nextNode.isFinal) {
				return false;
			}

			return isGoogSet(index + 1, letters, nextNode);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		Trie trie = new Trie();

		for (int i = 0; i < n; i++) {
			String word = in.nextLine();
			if (!trie.addWord(word)) {
				System.out.println("BAD SET");
				System.out.println(word);
				in.close();
				return;
			}
		}

		System.out.print("GOOD SET");
		in.close();
	}
}
