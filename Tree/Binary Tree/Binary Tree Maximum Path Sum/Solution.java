class Solution {
    static class TreeNode {
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

    public static int f(TreeNode root, int[] maxi) {
        if (root == null) {
            return 0;
        }
        int leftSum =  Math.max(0,f(root.left, maxi));
        int rightSum =  Math.max(0,f(root.right, maxi));
        maxi[0] = Math.max(maxi[0], root.val + leftSum + rightSum);
        return (root.val + Math.max(leftSum, rightSum));
    }

    public static int maxPathSum(TreeNode root) {
        int[] maxi = { root.val };
        f(root, maxi);
        return maxi[0];
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(-10);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        System.out.println(maxPathSum(head));
    }
}