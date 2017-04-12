package com.algorithms.graphs.prim;

public class Edge {

	private String fromPoint;
	private String toPoint;
	private int weight;
	
	public Edge(String fromPoint, String toPoint, int weight) {
		this.fromPoint = fromPoint;
		this.toPoint = toPoint;
		this.weight = weight;
	}
	
	public String getAdjacentPoint(String from) {
		if (fromPoint.equals(from))
			return toPoint;
		return fromPoint;
	}

	public int getWeight() {
		return weight;
	}
}
