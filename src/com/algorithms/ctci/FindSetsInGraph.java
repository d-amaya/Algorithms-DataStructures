package com.algorithms.ctci;

import java.util.HashSet;
import java.util.Set;

public class FindSetsInGraph {

	private static void findSet(Integer v, Set<Integer> visited, UndirectedGraph<Integer> g) {
		visited.add(v);
		for (Integer adj: g.getEdges(v)) {
			if (!visited.contains(adj)) {
				findSet(adj, visited, g);
			}
		}
	}
	
	public static int findSet(UndirectedGraph<Integer> g) {
		int counter = 0;
		Set<Integer> visited = new HashSet<Integer>();
		for (Integer v: g.getVertices()) {
			if (!visited.contains(v)) {
				findSet(v, visited, g);
				counter += 1;
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		UndirectedGraph<Integer> graph = new UndirectedGraph<Integer>(15);
		graph.addEdge(0, 1);
		graph.addEdge(1, 5);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 6);
		graph.addEdge(7, 7);
		graph.addEdge(8, 9);
		graph.addEdge(9, 10);
		
		System.out.println(findSet(graph));
	}
}
