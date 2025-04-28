class Solution {
    static class TreeNode {
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

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Height(root) == -1)
            return false;
        return true;
    }

    public static int Height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = Height(root.left);
        int rightHight = Height(root.right);
        if (leftHeight == -1 || rightHight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHight) > 1)
            return -1;
        return Math.max(leftHeight, rightHight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
}