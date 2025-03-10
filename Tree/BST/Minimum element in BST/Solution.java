class Solution{
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
    static int minValue(Node root) {
        if(root.left==null){
            return root.data;
        }else{
            return minValue(root.left);
        }

    }
    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(2);

        System.out.println(minValue(root));
    }
}


