public class Solution100 {

    public static void Main(string[] args) {
        var solution = new Solution100();
        Console.WriteLine(solution.IsSameTree(null, null));
    }

    public bool IsSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) return false;

        if (p == null && q == null) return true;

        if (p.val != q.val) return false;

        if (!IsSameTree(p.left, q.left)) return false;

        if (!IsSameTree(p.right, q.right)) return false;

        return true;
    }

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