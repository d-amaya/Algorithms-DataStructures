package com.algorithms.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cruh {

//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		long[] array = new long[scanner.nextInt()];
//
//		long maxNumber = 0;
//		long M = scanner.nextLong();
//
//		for (int i = 0; i < M; i++) {
//			int a = scanner.nextInt();
//			int b = scanner.nextInt();
//			long k = scanner.nextLong();
//			for (int j = a - 1; j <= b - 1; j++) {
//				array[j] = array[j] + k;
//				maxNumber = Math.max(maxNumber, array[j]);
//			}
//		}
//
//		System.out.println(maxNumber);
//	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Long> ranges = new HashMap<String, Long>();

		String[] firstLine = scanner.nextLine().split(" ");
		
		long maxNumber = 0;
		String minRange = "1";
		String maxRange = firstLine[0];
		ranges.put(minRange + "-" + maxRange, 0L);

		Map.Entry<String, Long> startRange = null;
		Map.Entry<String, Long> finalRange = null;
		for (int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
			String[] operation = scanner.nextLine().split(" ");
			startRange = null;
			finalRange = null;
			
			for (Map.Entry<String, Long> entry : ranges.entrySet()) {
				String[] range = entry.getKey().split("-");
				if (startRange == null 
						&& Long.parseLong(operation[0]) >= Long.parseLong(range[0]) 
						&& Long.parseLong(operation[0]) <= Long.parseLong(range[1])) {
					startRange = entry;
				}
				if (finalRange == null 
						&& Long.parseLong(operation[1]) >= Long.parseLong(range[0]) 
						&& Long.parseLong(operation[1]) <= Long.parseLong(range[1])) {
					finalRange = entry;
				}
				if (Long.parseLong(operation[0]) < Long.parseLong(range[0]) 
						&& Long.parseLong(operation[1]) > Long.parseLong(range[1])) {
					long newValue = entry.getValue() + Long.parseLong(operation[2]);
					maxNumber = Math.max(maxNumber, newValue);
					entry.setValue(newValue);
				}
			}
			
			String[] keyStart = startRange.getKey().split("-");
			String[] keyFinal = finalRange.getKey().split("-");
			if (startRange == finalRange) {
				ranges.remove(startRange.getKey());
				
				if (Integer.parseInt(keyStart[0]) < Integer.parseInt(operation[0]))
					ranges.put(keyStart[0] + "-" + (Integer.parseInt(operation[0])-1), startRange.getValue());
				
				if ((Integer.parseInt(operation[1])) < Integer.parseInt(keyFinal[1]))
					ranges.put((Integer.parseInt(operation[1])+1) + "-" + keyFinal[1], finalRange.getValue());
				
				long newValue = Long.parseLong(operation[2]) + startRange.getValue();
				maxNumber = Math.max(maxNumber, newValue);
				ranges.put(operation[0] + "-" + operation[1], newValue);
				
			} else {
				
				ranges.remove(startRange.getKey());
				ranges.remove(finalRange.getKey());
				
				if (Integer.parseInt(keyStart[0]) < Integer.parseInt(operation[0]))
					ranges.put(keyStart[0] + "-" + (Integer.parseInt(operation[0])-1), startRange.getValue());
				
				long newValue1 = Long.parseLong(operation[2]) + startRange.getValue();
				long newValue2 =Long.parseLong(operation[2]) + finalRange.getValue();
				ranges.put(operation[0] + "-" + keyStart[1], newValue1);
				ranges.put(keyFinal[0] + "-" + operation[1], newValue2);
				maxNumber = Math.max(maxNumber, newValue1);
				maxNumber = Math.max(maxNumber, newValue2);
				
				if ((Integer.parseInt(operation[1])) < Integer.parseInt(keyFinal[1]))
					ranges.put((Integer.parseInt(operation[1])+1) + "-" + keyFinal[1], finalRange.getValue());
			}
		}
		
		System.out.println(maxNumber);
		
		scanner.close();
	}
	
}
