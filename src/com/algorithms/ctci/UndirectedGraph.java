package com.algorithms.ctci;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph<T> extends Graph<T> {

	public UndirectedGraph(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public void addEdge(T origin, T dest) {
		if (origin == null || dest == null) throw new IllegalArgumentException();
		add(origin, dest);
		add(dest, origin);
	}
	
	private void add(T origin, T dest) {
		Set<T> edges = this.vertices.get(origin);
		if (edges == null) edges = new HashSet<T>();
		edges.add(dest);
		this.vertices.put(origin, edges);
	}

}
