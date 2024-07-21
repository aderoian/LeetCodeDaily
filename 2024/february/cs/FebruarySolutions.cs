public class FebruarySolutions {

    /**
     * Problem 100
     * Date: 02/25/2024
     */
    public bool IsSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) return false;

        if (p == null && q == null) return true;

        if (p.val != q.val) return false;

        if (!IsSameTree(p.left, q.left)) return false;

        if (!IsSameTree(p.right, q.right)) return false;

        return true;
    }

    /**
     * Utility Classes
     */
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}