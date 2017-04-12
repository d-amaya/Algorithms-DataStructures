package com.algorithms.graphs.prim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexedPriorityQueue {
	
	private Map<String, Integer> positions;
	private List<Node> elements;
	
	public IndexedPriorityQueue(int n) {
		this.elements = new ArrayList<Node>(n);
		this.positions = new HashMap<String, Integer>(n);
	}
	
	public void addElement(String point, long weight) {
		Node newNode = new Node(point, weight);
		this.elements.add(newNode);
		
		int index = this.elements.size() - 1;
		this.positions.put(newNode.getPoint(), index);
		goUp(index);
	}
	
	public Node removeElement() {
		int currentIndex = 0;
		int leftIndex = 1;
		
		Node removed = elements.get(currentIndex);
		Node last = elements.get(elements.size() - 1);
		
		elements.set(currentIndex, last);
		elements.remove(elements.size() - 1);
		positions.put(last.getPoint(), currentIndex);
		
		while (leftIndex < elements.size()) {
			int j = -1;
			if (last.getWeight() > elements.get(leftIndex).getWeight()) {
				j = leftIndex;
				if (elements.get(leftIndex).getWeight() > elements.get(leftIndex + 1).getWeight()) {
					j += 1;
				} 
			} else if (leftIndex < elements.size() -1 
					&& last.getWeight() > elements.get(leftIndex + 1).getWeight()) {
				j = leftIndex + 1;
			}
			
			if (j == -1) break;
			
			elements.set(currentIndex, elements.get(j));
			positions.put(elements.get(j).getPoint(), currentIndex);
			
			elements.set(j, last);
			positions.put(last.getPoint(), j);
			
			leftIndex = (2 * j) + 1;
			currentIndex = j;
		}
		
		positions.remove(removed.getPoint());
		return removed;
	}

	public boolean updateElement(String point, int weight) {
		Integer nodeIndex = this.positions.get(point);
		if (nodeIndex != null) {
			Node node = this.elements.get(nodeIndex);
			if (node.getWeight() > weight) {
				node.setWeight(weight);
				goUp(nodeIndex);
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(String point) {
		return this.positions.get(point) != null;
	}

	private void goUp(int index) {
		if (index <= 0) return;
		
		Node node = elements.get(index);
		
		int parentIndex = (index - 1) / 2;
		Node parentNode = elements.get(parentIndex);
		
		while (parentNode != null && parentNode.getWeight() > node.getWeight()) {
			this.elements.set(index, parentNode);
			this.positions.put(parentNode.getPoint(), index);
			
			this.elements.set(parentIndex, node);
			this.positions.put(node.getPoint(), parentIndex);
			
			index = parentIndex;
			if (index == 0) break;
			
			parentIndex = (index - 1) / 2;
			parentNode = elements.get(parentIndex);
		}
		
	}
	
	public boolean isEmpty() {
		return this.elements.size() == 0;
	}
	
}
