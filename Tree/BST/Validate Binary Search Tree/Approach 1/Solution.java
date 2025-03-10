class Solution{
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
    public static void f(TreeNode root, long[] counter, boolean[] ans) {
        if (root == null) {
            return;
        }

        f(root.left, counter, ans);
        if(counter[0]<root.val ){
            counter[0] = root.val;
        }else{
            ans[0] = false;
            return;
        }
        f(root.right, counter, ans);
    }

    public static boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        boolean[] ans = {true};
        long[] counter = {(long)Integer.MIN_VALUE-1};
        f(root,counter,ans);
        return ans[0];
    }
    public static void main(String[] args){
        TreeNode root= new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);
        System.out.println(isValidBST(root));
    }
}