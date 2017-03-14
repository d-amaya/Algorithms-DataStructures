package com.algorithms.dijkstra;

import java.util.Scanner;
import java.util.Stack;

public class MainDijkstra {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		DirectedWeightedGraph graph = new DirectedWeightedGraph(23);
		int edges = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < edges; i++) {
			String[] edge = scanner.nextLine().split(",");
			graph.add(new Edge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Integer.parseInt(edge[2])));
		}

		DijkstraShorestPath dsp = new DijkstraShorestPath(graph, 1);
		Stack<Edge> path = dsp.getPathTo(14);
		while (!path.isEmpty()) {
			Edge edge = path.pop();
			System.out.println(edge.getCoordinateFrom() + "-" + edge.getCoordinateTo());
		}
		
		scanner.close();
	}

	
}
