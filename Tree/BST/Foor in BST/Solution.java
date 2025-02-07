class Solution {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static int f(Node root, int key, int ans) {
        if(root==null)  return ans;
        if(root.data==key){
            return root.data;
        }else if(root.data>key){
            return f(root.left, key, ans);
        }else if(root.data<key){
            ans = root.data;
            return f(root.right, key, ans);
        }
        return -1;
    }
    static int floor(Node root, int key) {
        if (root == null)
            return -1;
        return f(root,key,-1);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.right = new Node(8);
        System.out.println(floor(root,6));
    }
}