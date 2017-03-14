package com.algorithms.dijkstra;

import java.util.LinkedList;
import java.util.List;

public class DirectedWeightedGraph {
	private List<Edge>[] coordinates;
	
	@SuppressWarnings("unchecked")
	public DirectedWeightedGraph(int coordinates) {
		this.coordinates = new LinkedList[coordinates];
		for (int i = 0; i < this.coordinates.length; i++) {
			this.coordinates[i] = new LinkedList<Edge>();
		}
	}
	
	public int length() {
		return this.coordinates.length;
	}
	
	public List<Edge> adj(int coordinate) {
		return this.coordinates[coordinate];
	}
	
	public void add(Edge edge) {
		this.coordinates[edge.getCoordinateFrom()].add(edge);
	}

}
