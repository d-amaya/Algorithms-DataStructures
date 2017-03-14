package com.algorithms.dijkstra;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class DijkstraShorestPath {

	private DirectedWeightedGraph graph;
	private int coordinateOrigin;

	private PriorityQueue<Edge> pq;
	private int[] distanceTo;
	private Edge[] pathTo;
	private boolean[] visited;

	public DijkstraShorestPath(DirectedWeightedGraph graph, int coordinateOrigin) {
		this.visited = new boolean[graph.length()];
		this.distanceTo = new int[graph.length()];
		this.pathTo = new Edge[graph.length()];
		this.pq = new PriorityQueue<Edge>();

		this.coordinateOrigin = coordinateOrigin;
		this.graph = graph;
		processShorestPath();
	}

	public Stack<Edge> getPathTo(int coordinateDestination) {
		Stack<Edge> path = new Stack<Edge>();
		for (Edge edge = this.pathTo[coordinateDestination]; edge != null; edge = this.pathTo[edge.getCoordinateFrom()]) {
			path.push(edge);
		}
		return path;
	}

	private void processShorestPath() {
		visit(this.coordinateOrigin);

		while (!pq.isEmpty()) {
			Edge edge = this.pq.remove();
			if (!this.visited[edge.getCoordinateTo()]
			    || this.distanceTo[edge.getCoordinateTo()] > this.distanceTo[edge.getCoordinateFrom()] + edge.getWeight()) {
				this.pathTo[edge.getCoordinateTo()] = edge;
				this.distanceTo[edge.getCoordinateTo()] = this.distanceTo[edge.getCoordinateFrom()] + edge.getWeight();
				visit(edge.getCoordinateTo());
			}
		}
	}

	private void visit(int coordinate) {
		List<Edge> adjacentCoordinates = this.graph.adj(coordinate);
		this.visited[coordinate] = true;
		for (Edge edge : adjacentCoordinates) {
			this.pq.add(edge);
		}
	}
}
