package com.algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QueriesWithFixedLength {

	private static int[] getSegmentTree(int n) {
		int power = 2;
		while (power < n) {
			power *= 2;
		}

		return new int[power * 2 - 1];
	}

	private static int buildSegmentTree(int[] arr, int[] segTree, int low, int high, int pos) {
		if (low == high) {
			segTree[pos] = arr[low];
			return arr[low];
		}

		int mid = (high + low) / 2;
		int childLeft = 2 * pos + 1;
		int childRight = 2 * pos + 2;

		int max = Math.max(
				      buildSegmentTree(arr, segTree, low, mid, childLeft),
		              buildSegmentTree(arr, segTree, mid + 1, high, childRight));

		segTree[pos] = max;
		return max;
	}

	private static int processQuery(int[] segTree, int i, int j, int low, int high, int pos) {
		if (i <= low && high <= j) // Total overlap
			return segTree[pos];
		
		if (high < i || j < low) // No overlap
			return Integer.MIN_VALUE;
		
		int mid = (high + low) / 2;
		int childLeft = 2 * pos + 1;
		int childRight = 2 * pos + 2;
		
		return Math.max(
				processQuery(segTree, i, j, low, mid, childLeft),
				processQuery(segTree, i, j, mid + 1, high, childRight));
	}

	private static int getQueryWithFixedLength(int arr[], int[] segTree, int q, int n) {
		Set<String> result = new HashSet<String>();
		
		int min = Integer.MAX_VALUE,
				i = 0, 
				ii = i + q - 1, 
				j = arr.length - 1, 
				jj = j - q + 1;

		while (ii < arr.length && !result.contains(i + "-" + ii) && !result.contains(jj + "-" + j)) {
			boolean exist_i = result.add(i + "-" + ii);
			boolean exist_j = result.add(jj + "-" + j);

			if (exist_i && exist_j) {
				int max_i = processQuery(segTree, i, ii, 0, n - 1, 0);
				int max_j = processQuery(segTree, jj, j, 0, n - 1, 0);

				min = Math.min(min, max_i);
				min = Math.min(min, max_j);

				i++;
				j--;
				jj = j - q + 1;
				ii = i + q - 1;
			} else {
				int max_i = processQuery(segTree, i, ii, 0, n - 1, 0);
				min = Math.min(min, max_i);
				break;
			}
		}

		return min;
	}

	public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int q = in.nextInt();
      
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
          arr[i] = in.nextInt();
      }
      
      int[] segTree = getSegmentTree(n);
      buildSegmentTree(arr, segTree, 0, n - 1, 0);
      
      for (int i = 0; i < q; i++) {
          System.out.println(getQueryWithFixedLength(arr, segTree, in.nextInt(), n));
      }
      
      in.close();
  }
}
