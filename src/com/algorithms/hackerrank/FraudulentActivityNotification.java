package com.algorithms.hackerrank;

import java.util.Scanner;

public class FraudulentActivityNotification {

	private static double getMedianExpense(int[] counter, int d) {
		int medianPosition = (d % 2 != 0) ? (d / 2) + 1 : d / 2;
		int count = 0;
		int i = 0;

		for (; count < medianPosition; i++) {
			count += counter[i];
		}

		int j = i;
		i -= 1;

		if (count > medianPosition || d % 2 != 0)
			return i;

		for (; counter[j] == 0; j++) {
		}

		return (i + j) / 2d;
	}

	private static long fraudulentNotifications(int[] expenditures, int d) {

		int[] counter = new int[201];
		int i = 0, j = d;

		for (; i < j; i++) {
			counter[expenditures[i]] += 1;
		}
		i = 0;

		long notifications = 0;
		while (j < expenditures.length) {
			double median = getMedianExpense(counter, d);
			if (expenditures[j] >= (median * 2)) {
				notifications += 1;
			}

			counter[expenditures[i]] -= 1;
			counter[expenditures[j]] += 1;

			i++;
			j++;
		}

		return notifications;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();

		int[] expenditures = new int[n];
		for (int i = 0; i < n; i++) {
			expenditures[i] = in.nextInt();
		}

		System.out.print(fraudulentNotifications(expenditures, d));
		in.close();
	}
}
