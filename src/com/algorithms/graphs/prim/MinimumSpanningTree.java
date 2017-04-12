package com.algorithms.graphs.prim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinimumSpanningTree {
	
	private IndexedPriorityQueue priorityQueue;
	private Map<String, String> path;
	private UndirectedGraph graph;
	
	public MinimumSpanningTree(UndirectedGraph graph) {
		this.priorityQueue = new IndexedPriorityQueue(graph.size());
		this.path = new HashMap<String, String>(graph.size());
		this.graph = graph;
		prepareData();
	}

	private String findMinimumSpaningTree() {
		String result = "";
		
		Node node = this.priorityQueue.removeElement();
		while (!this.priorityQueue.isEmpty()) {
			for (Edge edge : graph.getEdges(node.getPoint())) {
				String adjacentPoint = edge.getAdjacentPoint(node.getPoint());
				if (this.priorityQueue.contains(adjacentPoint)) {
					boolean updated = this.priorityQueue.updateElement(adjacentPoint, edge.getWeight());
					if (updated) {
						this.path.put(adjacentPoint, node.getPoint());
					}
				}
			}
			
			node = this.priorityQueue.removeElement();
			result += this.path.get(node.getPoint()) + node.getPoint() + "  ";
		}
		
		return result;
	}

	private void prepareData() {
		Iterator<String> iterator = this.graph.getVertices().iterator();
		String initialVertice = iterator.next();
		this.priorityQueue.addElement(initialVertice, 0);
		while (iterator.hasNext()) {
			this.priorityQueue.addElement(iterator.next(), Long.MAX_VALUE);
		}
	}
	
	public static void main(String[] args) {
		
		// Test 1 - Expected result = AB  BC  CD  BE 
		UndirectedGraph graph = new UndirectedGraph(5);
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "C", 2);
		graph.addEdge("C", "D", 5);
		graph.addEdge("C", "B", 1);
		graph.addEdge("B", "D", 7);
		graph.addEdge("E", "B", 10);
		
		MinimumSpanningTree primMST = new MinimumSpanningTree(graph);
		System.out.println(primMST.findMinimumSpaningTree());
		
		// Test 2 - Expected result = AD  DC  CB  CF  FE
		graph = new UndirectedGraph(6);
		graph.addEdge("A", "B", 3);
		graph.addEdge("A", "D", 1);
		graph.addEdge("B", "D", 3);
		graph.addEdge("B", "C", 1);
		graph.addEdge("D", "C", 1);
		graph.addEdge("E", "D", 6);
		graph.addEdge("E", "C", 5);
		graph.addEdge("C", "F", 4);
		graph.addEdge("F", "E", 2);
		
		primMST = new MinimumSpanningTree(graph);
		System.out.println(primMST.findMinimumSpaningTree());
	}
}
