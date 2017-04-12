package com.algorithms.graphs.prim;

public class Node {
	private String point;
	private long weight;
	
	public Node(String point, long weight) {
		this.point = point;
		this.weight = weight;
	}

	public String getPoint() {
		return point;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}
}
