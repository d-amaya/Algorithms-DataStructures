package com.algorithms.ctci;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS<T> {
	
	private DirectedGraph<T> graph;
	private Set<T> visited;
	
	public BFS(DirectedGraph<T> graph) {
		this.visited = new HashSet<>(graph.size());
		this.graph = graph;
	}
	
	public boolean isThereAnyPath(T origin, T dest) {
		if (origin == null || dest == null) throw new IllegalArgumentException();
		
		if (this.graph.getEdges(origin) == null) return false;
		if (origin.equals(dest)) return true;
		
		Queue<T> q = new LinkedList<T>();
		q.add(origin);
		
		while (!q.isEmpty()) {
			T v = q.poll();
			this.visited.add(v);
			
			for (T adj: this.graph.getEdges(v)) {
				if (adj.equals(dest)) return true;
				if (!this.visited.contains(adj)) q.add(adj);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		DirectedGraph<Integer> graph = new DirectedGraph<>(4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 1);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 3);
		graph.addEdge(5, 4);
		
		BFS<Integer> bfs = new BFS<>(graph);
		System.out.println(bfs.isThereAnyPath(1, 4) ? "YES" : "NO"); // YES
		bfs = new BFS<>(graph);
		System.out.println(bfs.isThereAnyPath(4, 1) ? "YES" : "NO"); // YES
		bfs = new BFS<>(graph);
		System.out.println(bfs.isThereAnyPath(3, 3) ? "YES" : "NO"); // YES
		bfs = new BFS<>(graph);
		System.out.println(bfs.isThereAnyPath(1, 5) ? "YES" : "NO"); // NO
	}
}
