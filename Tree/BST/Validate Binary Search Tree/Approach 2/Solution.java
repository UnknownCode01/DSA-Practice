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
    public static boolean f(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        // System.out.println(root.val+" "+min+" "+max);
        if(root.val<=min || root.val>=max)  return false;
        return f(root.left,min, root.val) && f(root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return f(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static void main(String[] args){
        TreeNode root= new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);
        System.out.println(isValidBST(root));
    }
}