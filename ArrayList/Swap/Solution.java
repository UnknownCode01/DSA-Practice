import java.util.*;
class Solution{
    public static void swap(ArrayList<Integer> list, int i1, int i2){
        int temp=list.get(i1);
        list.set(i1,list.get(i2));
        list.set(i2,temp);

    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        swap(list,0,1);
        System.out.println(list);
    }
}