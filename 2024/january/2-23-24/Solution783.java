import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution783 {

	public static void main(String[] args) {
		var solution = new Solution783();
		System.out.println(solution.minDiffInBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
		System.out.println(solution.minDiffInBST(new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)))));
	}

	List<Integer> values = new ArrayList<>();

	public int minDiffInBST(TreeNode root) {
		readNodeValue(root);

		Collections.sort(values);

		int min = (int) (10e6 + 1);
		for (int i = 0; i < values.size() - 1; i++)
			min = Math.min(min, Math.abs(values.get(i) - values.get(i + 1)));

		return min;
	}

	public void readNodeValue(TreeNode node) {
		values.add(node.val);
		if (node.left != null) readNodeValue(node.left);
		if (node.right != null) readNodeValue(node.right);
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
