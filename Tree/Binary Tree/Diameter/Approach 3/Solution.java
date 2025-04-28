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

    public static int f(TreeNode node, int[] maxi) {
        if (node == null) {
            return 0;
        }
        int lH = f(node.left, maxi);
        int rH = f(node.right, maxi);
        maxi[0] = Math.max(maxi[0], lH + rH);
        return 1 + (Math.max(lH, rH));
    }

    public static int diameterOfBinaryTree(TreeNode node) {
        int[] maxi = { 0 };
        f(node, maxi);
        return maxi[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(diameterOfBinaryTree(root));
    }
}