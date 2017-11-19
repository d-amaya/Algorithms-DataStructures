package com.algorithms.ctci;

public class LowerUpperCases {
	
	public static String toLowerCase(String s) {
		StringBuilder sb = new StringBuilder(s.length());
		for (char c : s.toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				sb.append((char)('a' + (c - 'A')));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static String toUpperCase(String s) {
		StringBuilder sb = new StringBuilder(s.length());
		for (char c : s.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				sb.append((char)('A' + (c - 'a')));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(toLowerCase("D-AmAya"));
		System.out.println(toLowerCase("DANIEL ROLDAN AMAYA"));
		
		System.out.println(toUpperCase("d-aMaYa"));
		System.out.println(toUpperCase("Daniel Roldan Amaya"));
	}

}
