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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static TreeNode cloneTree(TreeNode node) {
        if (node == null)
            return null;

        TreeNode newNode = new TreeNode(node.val);
        newNode.left = cloneTree(node.left);
        newNode.right = cloneTree(node.right);
        return newNode;
    }

    public static void print(TreeNode head) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(head);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(9);
        System.out.println("Original Tree");
        print(head);
        System.out.println("Inverted Tree1");
        TreeNode newhead = cloneTree(head);
        newhead = invertTree(newhead);
        print(newhead);
        System.out.println("Inverted Tree2");
        TreeNode newhead2 = cloneTree(head);
        newhead2 = invertTree2(newhead2);
        print(newhead2);
    }
}