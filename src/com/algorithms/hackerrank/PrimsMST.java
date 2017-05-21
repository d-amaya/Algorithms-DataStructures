package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class PrimsMST {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		Map<Integer, List<Edge>> graph = new HashMap<Integer, List<Edge>>(n);
		for (int i = 0; i < m; i++) {
			Edge edge = new Edge(in.nextInt(), in.nextInt(), in.nextInt());

			List<Edge> adjacent = graph.get(edge.x);
			if (adjacent == null) {
				adjacent = new ArrayList<Edge>();
				graph.put(edge.x, adjacent);
			}
			adjacent.add(edge);

			adjacent = graph.get(edge.y);
			if (adjacent == null) {
				adjacent = new ArrayList<Edge>();
				graph.put(edge.y, adjacent);
			}
			adjacent.add(edge);
		}

		int s = in.nextInt();

		System.out.println(findMST(graph, s));
		in.close();
	}

	private static int findMST(Map<Integer, List<Edge>> graph, int s) {
		
		Map<Integer, Integer> pathMap = new HashMap<Integer, Integer>();
		StringBuilder pathResponse = new StringBuilder();
		int totalWeight = 0;
		
		IPQ<Element> q = createPriorityQueue(graph, s);
		Element element = q.pop();
		
		while (!q.isEmpty()) {
			for (Edge edge : graph.get(element.vertice)) {
				Element adjElement = new Element(edge.getAdjacent(element.vertice), edge.weight);
				int index = q.getElementIndex(adjElement);
				if (index >= 0 && q.getElement(index).weight > adjElement.weight) {
					q.updateElement(index, adjElement);
					pathMap.put(adjElement.vertice, element.weight);
				}
			}
			
			element = q.pop();
			totalWeight += element.weight;
			pathResponse.append(pathMap.get(element.vertice) + "->" + element.vertice + ":");
		}
		
		System.out.println("MST Path: " + pathResponse.substring(0, pathResponse.length() - 1));
		return totalWeight;
	}

	private static IPQ<Element> createPriorityQueue(Map<Integer, List<Edge>> graph, int s) {
		IPQ<Element> queue = new IPQ<Element>(new Comparator<Element>() {
			@Override
			public int compare(Element e1, Element e2) {
				return e1.weight - e2.weight;
			}
		});

		queue.push(new Element(s, 0));
		for (Entry<Integer, List<Edge>> entry : graph.entrySet()) {
			if (entry.getKey() != s)
				queue.push(new Element(entry.getKey(), Integer.MAX_VALUE));
		}

		return queue;
	}

	private static class Edge {
		public int x, y, weight;

		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		public int getAdjacent(int v) {
			if (v == this.x) return this.y;
			return this.x;
		}
	}

	private static class Element {
		public int vertice, weight;
		private int hash;

		public Element(int vertice, int weight) {
			this.hash = 31 * 7 + vertice;
			this.vertice = vertice;
			this.weight = weight;
		}
		
		@Override
		public int hashCode() {
			return this.hash;
		}
		
		@Override
		public boolean equals(Object obj) {
			Element el = (Element) obj;
			return this.vertice == el.vertice;
		}
	}

	private static class IPQ<T> {

		private Map<T, Set<Integer>> indexes = new HashMap<T, Set<Integer>>();
		private Comparator<T> comparator;
		private List<T> elements;

		public IPQ(Comparator<T> comparator) {
			this.elements = new ArrayList<T>();
			this.comparator = comparator;
		}

		public void push(T element) {
			elements.add(element);
			siftUp(elements.size() - 1);
		}

		public T pop() {
			if (elements.isEmpty())
				throw new NoSuchElementException();

			int index = 0;
			T peek = elements.get(index);
			indexes.get(peek).remove(index);

			removeElement(index);
			return peek;
		}

		public boolean isEmpty() {
			return elements.isEmpty();
		}

		private void removeElement(int index) {
			int lastIndex = elements.size() - 1;
			if (index == lastIndex) {
				elements.remove(index);
				return;
			}

			T lastElement = elements.get(lastIndex);
			indexes.get(lastElement).remove(lastIndex);
			elements.set(index, lastElement);
			elements.remove(lastIndex);
			siftDown(index);
		}

		private int getElementIndex(T element) {
			Set<Integer> index = indexes.get(element);
			if (index == null || index.isEmpty()) return -1;
			
			return index.iterator().next();
		}

		private T getElement(int index) {
			if (index < 0 || index >= elements.size()) throw new IndexOutOfBoundsException();
			return elements.get(index);
		}

		private void updateElement(int index, T element) {
			if (index < 0 || index >= elements.size()) throw new IndexOutOfBoundsException();
			
			elements.set(index, element);
			indexes.get(element).remove(index);
			index = siftUp(index);
		}

		private int siftUp(int index) {
			if (index < 0 || index >= elements.size()) throw new IndexOutOfBoundsException();

			int parent = (index - 1) / 2;
			while (index > 0 && comparator.compare(elements.get(index), elements.get(parent)) < 0) {
				swap(index, parent);
				index = parent;
				parent = (index - 1) / 2;
			}
			updateIndex(index);
			return index;
		}

		private int siftDown(int index) {
			if (index < 0 || index >= elements.size())
				throw new IndexOutOfBoundsException();

			int child = (2 * index) + 1;
			while (child < elements.size()) {
				if (child < elements.size() - 1 && comparator.compare(elements.get(child + 1), elements.get(child)) < 0)
					child += 1;
				if (comparator.compare(elements.get(child), elements.get(index)) < 0) {
					swap(index, child);
					index = child;
					child = (2 * index) + 1;
					continue;
				}
				break;
			}
			updateIndex(index);
			return index;
		}

		private void swap(int index, int swapElement) {
			T aux = elements.get(swapElement);
			elements.set(swapElement, elements.get(index));
			elements.set(index, aux);

			Set<Integer> positions = indexes.get(aux);
			positions.remove(swapElement);
			positions.add(index);
		}

		private void updateIndex(int index) {
			Set<Integer> positions = indexes.get(elements.get(index));
			if (positions == null) {
				positions = new HashSet<Integer>();
				indexes.put(elements.get(index), positions);
			}
			positions.add(index);
		}
	}
}
