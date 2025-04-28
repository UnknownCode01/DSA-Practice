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
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode temp = st1.pop(); 
            st2.push(temp);
            if(temp.left!=null){
                st1.push(temp.left);
            }
            if(temp.right!=null){
                st1.push(temp.right);
            }
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().val);
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