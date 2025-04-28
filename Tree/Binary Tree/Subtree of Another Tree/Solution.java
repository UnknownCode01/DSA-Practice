import java.util.*;

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

    public static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        boolean left = isSame(root.left, subRoot.left);
        boolean right = isSame(root.right, subRoot.right);
        return left && right;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean ans = false;
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.val == subRoot.val) {
                ans = isSame(temp, subRoot);
                if (ans == true) {
                    return ans;
                }
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(4);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(2);
        TreeNode subHead = new TreeNode(4);
        subHead.left = new TreeNode(1);
        subHead.right = new TreeNode(2);
        System.out.println(isSubtree(head, subHead));
    }
}