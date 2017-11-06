package com.algorithms.ctci;

public class LowestCommonAncestor {
	
	private static class LCA {
		boolean x;
		boolean y;
	}

	private static TreeNode getLCA(TreeNode root, int x, int y, LCA dp) {
		if (root == null) return null;
		if (dp.x && dp.y) return null;
		
		TreeNode left = getLCA(root.getLeft(), x, y, dp);
		TreeNode right = getLCA(root.getRight(), x, y, dp);
		
		if (root.getValue() == x) dp.x = true;
		if (root.getValue() == y) dp.y = true;

		if (left != null && left.getValue() != x && left.getValue() != y) return left;
		if (right != null && right.getValue() != x && right.getValue() != y) return right;
		
		if ((left != null && (left.getValue() == x || left.getValue() == y))
				&& (right != null && (right.getValue() == x || right.getValue() == y))) {
			return root;
		}
		
		if (root.getValue() == x || root.getValue() == y) return root;
		if (dp.x || dp.y) return left != null ? left : right;
		
		return null;
	}
	
	public static int getLCA(TreeNode root, int x, int y) {
		LCA lca = new LCA();
		TreeNode result = getLCA(root, x, y, lca);
		return lca.x && lca.y ? result.getValue() : -1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(60)
				.addNode(30).addNode(20)
				.addNode(10).addNode(25)
				.addNode(50).addNode(40)
				.addNode(55).addNode(90)
				.addNode(70).addNode(80)
				.addNode(100);
		
		System.out.println(getLCA(root, 50, 55)); // 50
		System.out.println(getLCA(root, 25, 40)); // 30
		System.out.println(getLCA(root, 20, 100)); // 60
		System.out.println(getLCA(root, 20, 20)); // 20
		System.out.println(getLCA(root, 20, 0)); // -1
		System.out.println(getLCA(root, -15, 0)); // -1
	}
	
}
