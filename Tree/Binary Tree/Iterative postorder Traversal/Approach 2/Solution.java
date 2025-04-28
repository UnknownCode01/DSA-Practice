import java.util.*;

class Solution {
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

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode temp = root;
        while (curr != null || !st.isEmpty())
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    res.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        res.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;
        List<Integer> res = postorderTraversal(root);
        for (int j : res) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}