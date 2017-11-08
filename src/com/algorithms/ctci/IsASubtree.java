package com.algorithms.ctci;

public class IsASubtree {

	private static boolean isSubtree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return true;
		if (t1 != null && t2 == null) return true;
		if (t1 == null && t2 != null) return false;
		
		return t1.getValue() == t2.getValue()
				&& isSubtree(t1.getLeft(), t2.getLeft())
				&&isSubtree(t1.getRight(), t2.getRight());
	}
	
	public static boolean verifyIsSubtree(TreeNode t1, TreeNode t2) {
		if (t1 == null) return false;
		
		return (t1.getValue() == t2.getValue() && isSubtree(t1, t2)
				|| verifyIsSubtree(t1.getLeft(), t2)
				|| verifyIsSubtree(t1.getRight(), t2));
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(60)
				.addNode(30).addNode(20)
				.addNode(10).addNode(25)
				.addNode(50).addNode(40)
				.addNode(55).addNode(90)
				.addNode(70).addNode(80)
				.addNode(100);
		
		TreeNode t2 = new TreeNode(60)
				.addNode(30).addNode(50)
				.addNode(90).addNode(100)
				.addNode(70).addNode(80);
		
		System.out.println(verifyIsSubtree(t1, t2) ? "YES" : "NO");
	}
}
