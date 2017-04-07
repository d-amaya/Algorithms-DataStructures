package com.algorithms.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class ElectionWinner {

	public static String electionWinner(String[] votes) {
		Map<String, Integer> votesMap = new HashMap<String, Integer>();

		String winner = "";
		int maxVote = 0;

		for (int i = 0; i < votes.length; i++) {
			String candidate = votes[i];

			Integer vote = votesMap.get(candidate);
			if (vote == null) {
				vote = 0;
			}
			vote += 1;
			votesMap.put(candidate, vote);

			if (vote > maxVote) {
				winner = candidate;
				maxVote = vote;
			} else if (vote == maxVote) {
				winner = candidate.compareTo(winner) > 0 ? candidate : winner;
			}
		}

		return winner;
	}

	public static void main(String[] args) {
		String[] votes = { "Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary" };
		System.out.println(electionWinner(votes));
	}
}
