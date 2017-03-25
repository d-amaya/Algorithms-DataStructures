import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClosestNumbers {
  
  private static String smallestDifferencePairs(int[] arr) {
		StringBuilder sb = new StringBuilder();

		int smallestDifference = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (Math.abs(arr[i] - arr[i + 1]) < smallestDifference) {
				sb.setLength(0);
				sb.append(arr[i] + " " + arr[i + 1] + " ");
				smallestDifference = Math.abs(arr[i] - arr[i + 1]);
			} else if (Math.abs(arr[i] - arr[i + 1]) == smallestDifference) {
				sb.append(arr[i] + " " + arr[i + 1] + " ");
			}
		}

		return sb.toString();
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (high <= low)
			return;

		int pivot = arr[high];
		int i = low - 1, j = low;

		for (; j < high; j++) {
			if (arr[j] <= pivot) {
				i += 1;
				int aux = arr[j];
				arr[j] = arr[i];
				arr[i] = aux;
			}
		}

		arr[high] = arr[i + 1];
		arr[i + 1] = pivot;
		
		quickSort(arr, low, i);
		quickSort(arr, i + 2, high);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		quickSort(arr, 0, n - 1);
		System.out.print(smallestDifferencePairs(arr));

		in.close();
	}
}
