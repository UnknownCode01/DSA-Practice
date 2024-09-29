import java.util.*;
class Solution{
    public static void ps(ArrayList<Integer> arr,int x){
        int a=0,b=arr.size()-1;
        while(a<b){
            if(arr.get(a)+arr.get(b)==x){
                System.out.println(arr.get(a)+" + "+arr.get(b));
            }
            if(arr.get(a)+arr.get(b)<x){
                a++;
            }
            else{
                b--;
            }
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        ps(arr,5);
    }
}