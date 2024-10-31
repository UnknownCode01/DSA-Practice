import java.util.*;
class Solution{
    static class MinHeap{
        static ArrayList<Integer> arr = new ArrayList<>();
        public static void add(int data){
            arr.add(data);
            int childIndex = arr.size()-1;
            int parentIndex = (childIndex-1)/2;
            while(arr.get(childIndex)<arr.get(parentIndex)){
                int temp = arr.get(childIndex);
                arr.set(childIndex,arr.get(parentIndex));
                arr.set(parentIndex,temp);
                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;
            }
        }
        private static void MinHeapify(int i){
            int left = i*2+1;
            int right = i*2+2;
            int mini = i;
            if(left<arr.size() && arr.get(mini)>arr.get(left)){
                mini = left;
            }
            if(right<arr.size() && arr.get(mini)>arr.get(right)){
                mini = right;
            }
            if(mini!=i){
                int temp = arr.get(mini);
                arr.set(mini,arr.get(i));
                arr.set(i,temp);
                MinHeapify(mini);
            }
        }
        public static int remove(){
            int data = arr.get(0);
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            arr.remove(arr.size()-1);
            MinHeapify(0);
            return data;
        }
        public static int peek(){
            return arr.get(0);
        }
        public static boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args){
        MinHeap hp = new MinHeap();
        hp.add(7);
        hp.add(2);
        hp.add(5);
        hp.add(9);
        hp.add(1);
        hp.add(3);
        while(!hp.isEmpty()){
            System.out.print(hp.peek()+" ");
            hp.remove();
        }
    }
}