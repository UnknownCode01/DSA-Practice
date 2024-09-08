import java.util.*;
class Solution{
    static class Node{
        int data;
        Node Left;
        Node Right;
        Node(int data){
            this.data = data;
            this.Left = null;
            this.Right = null;
        }
    }
    public static boolean isIdentical(Node pr, Node sr){
        if(pr==null && sr==null){
            return true;
        }
        else if(pr==null || sr==null || pr.data!=sr.data){
            return false;
        }
        return isIdentical(pr.Left,sr.Left) && isIdentical(pr.Right,sr.Right);
    }
    public static boolean isSubtree(Node pr, Node sr){
        if(pr==null){
            return false;
        }
        if(pr.data==sr.data){
            if(isIdentical(pr,sr)){
                return true;
            }
        }
        
        return isSubtree(pr.Left,sr) || isSubtree(pr.Right,sr);
    }
    public static void main(String[] args){
        Node pr = new Node(1);
        pr.Left = new Node(2);
        pr.Right = new Node(3);
        pr.Left.Left= new Node(4);
        pr.Left.Right= new Node(5);
        pr.Right.Left= new Node(6);
        pr.Right.Right= new Node(7);
        Node sr = new Node(3);
        sr.Left = new Node(6);
        // sr.Right = new Node(7);
        System.out.println(isSubtree(pr,sr));
        
    }
}