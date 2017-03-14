package com.algorithms.hackerrank;

import java.util.Arrays;
import java.util.Comparator;

public class QueryString {
	
	private static Comparator<String> COMPARATOR = new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			String[] s1RatingValues = s1.split("-");
			String[] s2RatingValues = s2.split("-");
			return Integer.parseInt(s1RatingValues[1]) - Integer.parseInt(s2RatingValues[1]);
		}
	};

	public static void main(String[] args) {
		String[] ratingsRestaurants = {"A-1", "B-2", "C-3", "D-4", "E-4", "F-5", "G-4", "H-4"};
		Arrays.sort(ratingsRestaurants, COMPARATOR);
		for (String rating: ratingsRestaurants) {
			System.out.print(rating + ", ");
		}
	}
	
//	public static void main(String[] args) {
//		String paragraph = "I had bread and eggs for breakfast today. I also had bread and eggs yesterday.";
//		String query = "bread and eggs";
//		
//		Pattern p = Pattern.compile(query);
//		Matcher m = p.matcher(paragraph);
//		
//		while (m.find()) {
//			String s = paragraph.substring(0,  m.start());
//			System.out.println(s.split(" ").length);
//		}
//		
//		StringBuilder s = new StringBuilder(query);
//		System.out.println(s.reverse());
//	}
}
