package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class IndexPriorityQueue<T> {

	private Map<T, Set<Integer>> indexes = new HashMap<T, Set<Integer>>();
	private Comparator<T> comparator;
	private List<T> elements;
	
	public IndexPriorityQueue(Comparator<T> comparator) {
		this.elements = new ArrayList<T>();
		this.comparator = comparator;
	}
	
	public IndexPriorityQueue(int size, Comparator<T> comparator) {
		this.elements = new ArrayList<T>(size);
		this.comparator = comparator;
	}
	
	public void push(T element) {
		elements.add(element);
		siftUp(elements.size() - 1);
	}
	
	public T pop() {
		if (elements.isEmpty()) throw new NoSuchElementException();
		
		int index = 0;
		T peek = elements.get(index);
		indexes.get(peek).remove(index);
		if (elements.size() == 1) {
			indexes.clear();
			return peek;
		}
		
		removeElement(index);
		return peek;
	}
	
	public void remove(T element) {
		if (elements.isEmpty()) throw new NoSuchElementException();
		
		Set<Integer> positions = indexes.get(element);
		if (positions == null || positions.isEmpty()) throw new NoSuchElementException();
			
		int index = positions.iterator().next();
		positions.remove(index);
		if (elements.size() == 1) indexes.clear();
		
		removeElement(index);
	}

	public T peek() {
		if (elements.isEmpty()) throw new NoSuchElementException();
		return elements.get(0);
	}
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	private void removeElement(int index) {
		int lastIndex = elements.size() - 1;
		if (index == lastIndex) {
			elements.remove(index);
			return;
		}
		
		T lastElement = elements.get(lastIndex);
		indexes.get(lastElement).remove(lastIndex);
		elements.set(index, lastElement);
		elements.remove(lastIndex);
		siftDown(index);
	}

	private void siftUp(int index) {
		if (index < 0 || index >= elements.size()) throw new IndexOutOfBoundsException();
		
		int parent = (index - 1) / 2;
		while (index > 0 && comparator.compare(elements.get(index), elements.get(parent)) < 0) {
			swap(index, parent);
			index = parent;
			parent = (index - 1) / 2;
		}
		updateIndex(index);
	}
	
	private void siftDown(int index) {
		if (index < 0 || index >= elements.size()) throw new IndexOutOfBoundsException();
		
		int child = (2 * index) + 1;
		while (child < elements.size()) {
			if (child < elements.size() - 1 && comparator.compare(elements.get(child + 1), elements.get(child)) < 0) 
				child += 1;
			if (comparator.compare(elements.get(child), elements.get(index)) < 0) {
				swap(index, child);
				index = child;
				child = (2 * index) + 1;
				continue;
			}
			break;
		}
		updateIndex(index);
	}

	private void swap(int index, int swapElement) {
		T aux = elements.get(swapElement);
		elements.set(swapElement, elements.get(index));
		elements.set(index, aux);
		
		Set<Integer> positions = indexes.get(aux);
		positions.remove(swapElement);
		positions.add(index);
	}

	private void updateIndex(int index) {
		Set<Integer> positions = indexes.get(elements.get(index));
		if (positions == null) {
			positions = new HashSet<Integer>();
			indexes.put(elements.get(index), positions);
		}
		positions.add(index);
	}
}
