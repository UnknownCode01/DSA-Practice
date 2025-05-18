import java.util.*;

class TreeNode {
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

class Solution {
    public static TreeNode f(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, Map<Integer, Integer> hm) {
        if (is > ie || ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int inorderRootIndex = hm.get(root.val);
        int numsLeft = inorderRootIndex - is;
        root.left = f(inorder, postorder, is, inorderRootIndex - 1, ps, ps + numsLeft - 1, hm);
        root.right = f(inorder, postorder, inorderRootIndex + 1, ie, ps + numsLeft, pe - 1, hm);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        int n = inorder.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(inorder[i], i);
        }
        return f(inorder, postorder, 0, n - 1, 0, n - 1, hm);
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode root = buildTree(inorder, postorder);
    }
}