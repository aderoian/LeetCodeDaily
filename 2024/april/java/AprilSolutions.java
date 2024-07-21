public class AprilSolutions {

	/**
	 * Problem 205
	 * Date: 04/02/2024
	 */
	public boolean isIsomorphic(String s, String t) {
		// Create arrays to store the index of characters in both strings
		int[] indexS = new int[200]; // Stores index of characters in string s
		int[] indexT = new int[200]; // Stores index of characters in string t

		// Get the length of both strings
		int len = s.length();

		// If the lengths of the two strings are different, they can't be isomorphic
		if (len != t.length()) {
			return false;
		}

		// Iterate through each character of the strings
		for (int i = 0; i < len; i++) {
			// Check if the index of the current character in string s
			// is different from the index of the corresponding character in string t
			if (indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
				return false; // If different, strings are not isomorphic
			}

			// Update the indices of characters in both strings
			indexS[s.charAt(i)] = i + 1; // updating index of current character
			indexT[t.charAt(i)] = i + 1; // updating index of current character
		}

		// If the loop completes without returning false, strings are isomorphic
		return true;
	}

	/**
	 * Problem 1544
	 * Date: 04/05/2024
	 */
	public String makeGood(String s) {
		if (s.length() < 2) return s;

		for (int i = 0; i <= s.length() - 2; i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);

			if ((String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))) && !(Character.isLowerCase(c1) && Character.isLowerCase(c2) || Character.isUpperCase(c1) && Character.isUpperCase(c2))) {
				return makeGood(s.substring(0, i) + s.substring(i + 2));
			}
		}

		return s;
	}

	/**
	 * Problem 2073
	 * Date: 04/09/2024
	 */
	public int timeRequiredToBuy(int[] tickets, int k) {
		int time = 0;

		while (tickets[k] != 0) {
			for (int i = 0; i < tickets.length; i++) {
				if (tickets[i] == 0) continue;

				tickets[i]--;
				time++;

				if (i == k && tickets[i] == 0) return time;
			}
		}

		return time;
	}

	/**
	 * Problem 103
	 * Date: 04/12/2024
	 */
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

	/**
	 * Problem 623
	 * Date: 04/16/2024
	 */
	public TreeNode add(TreeNode root, int val, int depth, int curr) {
		if (root == null)
			return null;

		if (curr == depth - 1) {
			TreeNode lTemp = root.left;
			TreeNode rTemp = root.right;

			root.left = new TreeNode(val);
			root.right = new TreeNode(val);
			root.left.left = lTemp;
			root.right.right = rTemp;

			return root;
		}

		root.left = add(root.left, val, depth, curr + 1);
		root.right = add(root.right, val, depth, curr + 1);

		return root;
	}

	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}

		return add(root, val, depth, 1);
	}

	/**
	 * Problem 200
	 * Date: 04/19/2024
	 */
	int[][] checkedTiles;

	public int numIslands(char[][] grid) {
		checkedTiles = new int[grid.length][grid[0].length];

		int numIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				char t = grid[i][j];
				if (verifyIsland(i, j, grid)) numIslands++;
			}
		}

		return numIslands;
	}

	public boolean verifyIsland(int i, int j, char[][] grid) {
		if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return false;
		if (checkedTiles[i][j] == 1) return false;

		char t = grid[i][j];
		checkedTiles[i][j] = 1;
		if (t == '1') {
			verifyIsland(i + 1, j, grid);
			verifyIsland(i - 1, j, grid);
			verifyIsland(i, j + 1, grid);
			verifyIsland(i, j - 1, grid);
			return true;
		}

		return false;
	}

	/**
	 * Problem 112
	 * Date: 04/23/2024
	 */
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return targetSum == root.val;

		if (hasPathSum(root.left, targetSum - root.val)) return true;
		return hasPathSum(root.right, targetSum - root.val);
	}

	/**
	 * Problem 292
	 * Date: 04/23/2024
	 */
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}

	/**
	 * Problem 2000
	 * Date: 04/30/2024
	 */
	public String reversePrefix(String word, char ch) {
		int location = word.indexOf(ch);
		if (location == -1) return word;

		StringBuilder newReversed = new StringBuilder();
		for (int i = location; i >= 0; i--) {
			newReversed.append(word.charAt(i));
		}
		newReversed.append(word.substring(location + 1));
		return newReversed.toString();
	}

	/**
	 * Utility Classes
	 */
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
