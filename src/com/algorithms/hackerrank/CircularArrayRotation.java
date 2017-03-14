package com.algorithms.hackerrank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircularArrayRotation {

	private static List<Integer> rotateArray(int[] a, int rotations) {
		List<Integer> rotated = new ArrayList<Integer>(a.length);

		rotations = rotations <= a.length ? rotations : rotations - ((rotations / a.length) * a.length);
		for (int i = a.length - rotations; i < a.length; i++) {
			rotated.add(a[i]);
		}

		for (int i = 0; i < a.length - rotations; i++) {
			rotated.add(a[i]);
		}

		return rotated;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] a = new int[in.nextInt()];
		int k = in.nextInt();
		int q = in.nextInt();

		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}

		List<Integer> rotated = rotateArray(a, k);

		for (int a0 = 0; a0 < q; a0++) {
			System.out.println(rotated.get(in.nextInt()));
		}
		
		in.close();
	}
}
