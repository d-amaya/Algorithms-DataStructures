package com.algorithms.graphs.prim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UndirectedGraph {

	private Map<String, Collection<Edge>> vertices = null;
	private int size = 0;
	
	public UndirectedGraph(int n) {
		this.vertices = new HashMap<String, Collection<Edge>>(n);
		this.size = n;
	}
	
	public void addEdge(String from, String to, int weight) {
		Edge edge = new Edge(from, to, weight);
		addEdge(from, edge);
		addEdge(to, edge);
	}
	
	public Collection<String> getVertices() {
		return this.vertices.keySet();
	}
	
	public Collection<Edge> getEdges(String vertice) {
		return this.vertices.get(vertice);
	}

	public int size() {
		return this.size;
	}
	
	private void addEdge(String vertice, Edge edge) {
		Collection<Edge> edges = this.vertices.get(vertice);
		if (edges == null) {
			edges = new ArrayList<Edge>(this.size - 1);
			this.vertices.put(vertice, edges);
		}
		edges.add(edge);
	}
}
