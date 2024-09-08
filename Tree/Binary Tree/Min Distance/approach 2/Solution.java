import java.util.*;

class Solution{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node lca(Node root, int x, int y){
        if(root==null){
            return null;
        }
        if(root.data==x || root.data==y){
            return root;
        }
        Node leftLca = lca(root.left,x,y);
        Node rightLca = lca(root.right,x,y);
        if(rightLca==null){
            if(leftLca!=null){
            }
            return leftLca;
        }
        if(leftLca==null){
            if(rightLca!=null){
            }
            return rightLca;
        }
        return root;
    }
    public static int distance(Node node, int k){
        if(node==null){
            return -1;
        }
        if(node.data==k){
            return 0;
        }
        int leftDistance = distance(node.left, k);
        int rightDistance = distance(node.right, k);
        if(leftDistance==-1 && rightDistance==-1){
            return -1;
        }else if(leftDistance==-1){
            return rightDistance+1;
        }else{
            return leftDistance+1;
        }
    }
    public static int minDistance(Node root, int x, int y){
        Node lca = lca(root,x,y);
        int leftDistance = distance(lca,x);
        int rightDistance = distance(lca,y);
        return leftDistance+rightDistance;    
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x = 5;
        int y = 7;
        System.out.println(minDistance(root,x,y));
    }
}