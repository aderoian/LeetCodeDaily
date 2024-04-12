class Solution103 {

	public static void main(String[] args) {
		var solution = new Solution103();
		System.out.println(solution.isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(3), new TreeNode(4)))));
	}

	public boolean isSymmetric(TreeNode root) {
		if (root.left == null && root.right == null) return true;
		else if (root.left == null || root.right == null) return false;

		return isEqual(root.left, root.right);
	}

	public boolean isEqual(TreeNode a, TreeNode b) {
		if (a == null && b == null) return true;
		else if (a == null || b == null) return false;

		if (a.val != b.val) return false;
		return isEqual(a.right, b.left) && isEqual(a.left, b.right);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}