package com.algorithms.ctci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MinimumValidPartitions {
	
	private static class Range {
		private int hashcode = 1;
		public int from;
		public int to;
		
		public Range(int from, int to) {
			this.from = from;
			this.to= to;
			this.hashCode();
		}

		@Override
		public int hashCode() {
			if (hashcode == 1) {
				final int prime = 31;
				hashcode = prime * hashcode + from;
				hashcode = prime * hashcode + to;
			}
			return hashcode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			
			Range other = (Range) obj;
			if (from != other.from) return false;
			if (to != other.to) return false;
			return true;
		}

		@Override
		public String toString() {
			return "Range [from=" + from + ", to=" + to + "]";
		}
		
	}

	private static Map<Range, String> getPartitions(String word) {
		Map<Range, String> partitions = new HashMap<>();
		
		for (int i = 0; i < word.length(); i++) 
			partitions.put(new Range(i, i), String.valueOf(word.charAt(i)));
		
		for (int l = 1; l < word.length(); l++) {
			for (int r = 0; r + l < word.length(); r++) {
				partitions.put(new Range(r, r + l), partitions.get(new Range(r, r + l - 1)) + word.charAt(r + l));
			}
		}
		
		return partitions;
	}
	
	private static boolean getMinimumValidPartitions(Map<Range, String> partitions, Set<String> dictionary, Stack<String> s, int from, int to) {
		if (from > to) return true;
		
		boolean done = false;
		for (int j = to; j >= from; j--) {
			String permutation = partitions.get(new Range(from, j));
			if (dictionary.contains(permutation)) {
				done = getMinimumValidPartitions(partitions, dictionary, s, j + 1, to);
				if (done) {
					s.push(permutation);
					return done;
				}
			}
		}
		return done;
	}

	public static String[] getMinimumValidPartitions(String word, Set<String> dictionary) {
		Map<Range, String> partitions = getPartitions(word);
		
		Stack<String> s = new Stack<>();
		getMinimumValidPartitions(partitions, dictionary, s, 0, word.length() - 1);
		
		int pos = 0;
		String[] result = new String[s.size()];
		while (!s.isEmpty()) {
			result[pos] = s.pop();
			pos += 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] minimumPartitions = null;
		Set<String> dictionary = null;
		
		dictionary = new HashSet<>(Arrays.asList("Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"));
		minimumPartitions = getMinimumValidPartitions("CatMat", dictionary);
		for (String partition : minimumPartitions) System.out.print(partition + "-");
		
		System.out.println();
		
		dictionary = new HashSet<>(Arrays.asList("Cat", "M", "Ca", "tM", "at", "C", "Dog", "og", "Do"));
		minimumPartitions = getMinimumValidPartitions("CatMat", dictionary);
		for (String partition : minimumPartitions) System.out.print(partition + "-");

		System.out.println();
		
		dictionary = new HashSet<>(Arrays.asList("Ca", "tM", "C", "a", "t", "M"));
		minimumPartitions = getMinimumValidPartitions("CatMat", dictionary);
		for (String partition : minimumPartitions) System.out.print(partition + "-");

		System.out.println();
		
		dictionary = new HashSet<>(Arrays.asList("C", "a", "t", "M"));
		minimumPartitions = getMinimumValidPartitions("CatMat", dictionary);
		for (String partition : minimumPartitions) System.out.print(partition + "-");
	}
}
