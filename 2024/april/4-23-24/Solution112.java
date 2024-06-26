public class Solution112 {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return targetSum == root.val;

		if (hasPathSum(root.left, targetSum - root.val)) return true;
		return hasPathSum(root.right, targetSum - root.val);
	}

	public class TreeNode {
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
