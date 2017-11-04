package com.algorithms.ctci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph<T> {
	private Map<T, Set<T>> vertices;
	
	public DirectedGraph(int initialCapacity) {
		this.vertices = new HashMap<>(initialCapacity);
	}
	
	public void addEdge(T origin, T dest) {
		if (origin == null || dest == null) throw new IllegalArgumentException();
		
		Set<T> edges = this.vertices.get(origin);
		if (edges == null) edges = new HashSet<T>();
		edges.add(dest);
		this.vertices.put(origin, edges);
	}
	
	public Set<T> getVertices() {
		return this.vertices.keySet();
	}
	
	public Set<T> getEdges(T vertice) {
		return this.vertices.get(vertice);
	}
	
	public int size() {
		return this.vertices.size();
	}
}
