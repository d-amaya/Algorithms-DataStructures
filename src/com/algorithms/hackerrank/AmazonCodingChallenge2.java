package com.algorithms.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Find the how many numbers in nums are less or equal to every single number in maxes.
 * */
public class AmazonCodingChallenge2 {
	
	public static void main(String[] args) {
		int[] nums = {2, 10, 5, 4, 8};
		int[] maxes = {3, 1, 7, 8};
		int[] res = counts(nums, maxes);
		for (int i = 0; i < res.length; i++) System.out.print(res[i] + " ");
	}

	static int[] counts(int[] nums, int[] maxes) {
    	Map<Integer, LinkedList<Integer>> positions = new HashMap<>();
    	for (int i = 0; i < maxes.length; i++) {
    		LinkedList<Integer> pos = positions.get(maxes[i]);
    		if (pos == null) pos = new LinkedList<>();
    		pos.add(i);
    		positions.put(maxes[i], pos);
    	}
    	
    	Arrays.sort(nums);
    	Arrays.sort(maxes);
    	
    	int[] result = new int[maxes.length];
    	int lastIndex = 0;
    	int lastCounter = 0;
    	for (int i = 0; i < maxes.length; i++) {
    		int max = maxes[i];
    		for (int j = lastIndex; lastIndex < nums.length && nums[j] <= max ; j++) {
    			lastIndex += 1;
    			lastCounter += 1;
    		}
    		result[positions.get(max).removeLast()] = lastCounter;
    	}
        
        return result;
    }
}
