package com.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NucleoBase {

	public static class Nucleo {
		public int start;
		public int end;
		public String nucleo;

		public Nucleo(int start, String nucleo) {
			this.start = start;
			this.end = start + 2;
			this.nucleo = nucleo;
		}
	}

	public static String find_genes(String dna) {
		int start = -1, end = -1, length = Integer.MAX_VALUE;

		Set<String> set = new HashSet<String>();
		List<Nucleo> nucleos = findNucleos(dna);
		for (int i = 0; i < nucleos.size(); i++) {
			set.add(nucleos.get(i).nucleo);

			int j = i + 1;
			for (; j < nucleos.size() && set.size() < 3; j++)
				set.add(nucleos.get(j).nucleo);
			j -= 1;

			if (set.size() == 3) {
				int newLength = nucleos.get(j).end - nucleos.get(i).start;
				if (newLength < length) {
					start = nucleos.get(i).start;
					end = nucleos.get(j).end;
					length = newLength;
				}
			}

			set.clear();
		}

		String answer = "";
		if (start >= 0)
			answer = dna.substring(start, end + 1);

		return answer;
	}

	private static List<Nucleo> findNucleos(String dna) {
		List<Nucleo> nucleos = new ArrayList<Nucleo>();

		StringBuilder sb = new StringBuilder(dna.substring(0, 3));
		validateNucleo(sb, nucleos, 0);

		for (int i = 3; i <= dna.length() - 3; i++) {
			sb.deleteCharAt(0);
			sb.append(dna.charAt(i));
			validateNucleo(sb, nucleos, i - 2);
		}
		return nucleos;
	}

	private static void validateNucleo(StringBuilder sb, List<Nucleo> nucleos, int start) {
		String nucleo = sb.toString();
		if (nucleo.equals("ACT") || nucleo.equals("CGT") || nucleo.equals("AGT"))
			nucleos.add(new Nucleo(start, nucleo));
	}

	public static void main(String[] args) {
		System.out.println(find_genes("ACTACGTTTAGTAACTCGTCT"));
	}
}
