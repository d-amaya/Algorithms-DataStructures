package com.algorithms.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Make it anagrams
 * */
public class AmazonCodingChallenge3 {

	static int[] getMinimumDifference(String[] a, String[] b) {
		Map<Character, Integer> map = null;
        int[] result = new int[a.length];
        
        for (int i = 0; i < a.length; i++) {
            result[i] = -1;
            if (a[i].length() == b[i].length()) {
            	map = new HashMap<>();
            	
                for(char c : a[i].toCharArray()) {
                	Integer count = map.get(c);
                	if (count == null) count = 0;
                	count += 1;
                	map.put(c, count);
                }
                
                for (char c : b[i].toCharArray()) {
                	Integer count = map.get(c);
                	if (count != null) {
                		count -= 1;
                		if (count == 0) map.remove(c);
                		if (count > 0) map.put(c, count);
                	}
                }
                
                int difference = 0;
                if (map.size() > 0) {
                	for(Entry<Character, Integer> entry: map.entrySet()) {
                		difference += entry.getValue();
                	}
                }
                
                result[i] = difference;
            }
        }
        return result;
    }
}
