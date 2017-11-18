package com.algorithms.ctci;

public class CountOnesInBinary {

	private static short countOnes(int number) {
		byte count = 0;
		
		if (number < 0) {
			number &= Integer.MAX_VALUE;
			count += 1; // sign
		}
		
		while (number > 0) {
			if ((number & 1) > 0) count += 1;
			number >>>= 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countOnes(-2147483648)); // 10000000000000000000000000000000 -> 1
		System.out.println(countOnes(3)); // 0011 -> 2
		System.out.println(countOnes(13)); // 1101 -> 3
		System.out.println(countOnes(-250)); // 11111111111111111111111100000101 -> 26
		System.out.println(countOnes(-850)); // 11111111111111111111111100000101 -> 27
		System.out.println(countOnes(250)); //                          11111010 -> 6
		System.out.println(countOnes(2147483647)); // 0111111111111111111111111111111 -> 31
	}
}
