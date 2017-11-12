package com.algorithms.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Graph<T> {

	protected Map<T, Set<T>> vertices;
	
	public Graph(int initialCapacity) {
		this.vertices = new HashMap<>(initialCapacity);
	}
	
	public abstract void addEdge(T origin, T dest);
	
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
