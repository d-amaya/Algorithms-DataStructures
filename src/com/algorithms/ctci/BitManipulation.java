package com.algorithms.ctci;

public class BitManipulation {
	
	private static boolean duplicateCharacters(String s) {
		byte result = 0;
		for (int i = 0; i < s.length(); i++) {
			int bit = s.charAt(i) - 'a';
			if ((result & (1 << bit)) > 0) return true;
			result |= 1 << bit;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(duplicateCharacters("abcdefghij") ? "Duplicated" : "Unique");
		System.out.println(duplicateCharacters("abcdefghijd") ? "Duplicated" : "Unique");
		System.out.println(Integer.toBinaryString(32000)); 
		// 111110100000000
		// 000001111101000
		int x = 0x1F;
		System.out.println(x);
	}

	public static void main1(String[] args) {
		int x = 3 << 2;
		System.out.println(x);
		x = x >> 2;
		System.out.println(x);
		
		int y = 12; // 1100
		System.out.println((y & (1 << 2)) > 0 ? 1 : 0);
	}
}
