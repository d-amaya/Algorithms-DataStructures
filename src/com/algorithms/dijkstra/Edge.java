package com.algorithms.dijkstra;

public class Edge implements Comparable<Edge> {

	private int coordinateFrom;
	private int coordinateTo;
	private int weight;
	
	public Edge(int coordinateFrom, int coordinateTo, int weight) {
		this.coordinateFrom = coordinateFrom;
		this.coordinateTo = coordinateTo;
		this.weight = weight;
	}

	public int getCoordinateFrom() {
		return coordinateFrom;
	}

	public int getCoordinateTo() {
		return coordinateTo;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge that) {
		return this.weight - that.weight;
	}
}
