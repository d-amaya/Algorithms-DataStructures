package com.algorithms.hackerrank;

import java.util.*;

public class CutTheTree {

    private static long result = Long.MAX_VALUE;

    private static long cutTheTree(int i, long total, boolean[] visited, int[] data, List<Set<Integer>> edges) {
        visited[i] = true;
        if (edges.get(i) == null || edges.get(i).size() == 0) return 0;

        long subtreeSum = data[i];
        for (int adjacent : edges.get(i)) {
            if (!visited[adjacent]) {
                long childrenTotal = cutTheTree(adjacent, total, visited, data, edges);
                subtreeSum += childrenTotal;
                result = Math.min(result, Math.abs((total - childrenTotal) - childrenTotal));
            }
        }
        return subtreeSum;
    }

    private static void cutTheTree(int[] data, List<Set<Integer>> edges) {
        long total = 0;
        for (int i = 0; i < data.length; i++) total += data[i];
        boolean[] visited = new boolean[data.length];
        cutTheTree(0, total, visited, data, edges);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i++) data[i] = in.nextInt();

        List<Set<Integer>> edges = new ArrayList<>(n);
        for(int i = 0; i < n; i++) edges.add(new HashSet<>());

        for(int i = 0; i < n-1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        cutTheTree(data, edges);
        System.out.println(result);

        in.close();
    }
}
