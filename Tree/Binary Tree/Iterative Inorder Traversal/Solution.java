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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while (true) {
            if(temp!=null){
                st.push(temp);
                temp = temp.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                temp = st.pop();
                res.add(temp.val);
                temp = temp.right;
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
        List<Integer> res = inorderTraversal(root);
        for (int j : res) {
            System.out.print(j + " ");
        }
        System.out.println();

    }
}