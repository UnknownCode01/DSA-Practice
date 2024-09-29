import java.util.*;
class Solution{
    public static void ps(ArrayList<Integer> arr,int x){
       int bp=-1;
       int n=arr.size();
       for(int i=0;i<n;i++){
        if(arr.get(i)>arr.get(i+1)){
            bp=i;
            break;
        }
       }
       int lp=bp+1;
       int rp=bp;
       while(lp!=rp){
        if(arr.get(lp)+arr.get(rp)==x){
            System.out.println(arr.get(lp)+" + "+arr.get(rp)+" = "+x);
            return;
        }
        else if(arr.get(lp)+arr.get(rp)<x){
            lp=(lp+1)%n;
        }
        else{
            rp=(n+rp-1)%n;
        }
       }
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);

        ps(arr,16);
    }
}