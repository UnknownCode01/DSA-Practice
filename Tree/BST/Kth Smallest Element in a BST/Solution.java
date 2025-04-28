class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void f(TreeNode root, int k, int[] counter, int[] ans) {
        if (root == null || counter[0] > k) {
            return;
        }

        f(root.left, k, counter, ans);
        counter[0]++;
        if (counter[0] == k) {
            ans[0] = root.val;
        }
        f(root.right, k, counter, ans);
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] ans = { 0 };
        int[] counter = { 0 };
        f(root, k, counter, ans);//In-Order Traversal
        return ans[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        System.out.println(kthSmallest(root, k));
    }
}