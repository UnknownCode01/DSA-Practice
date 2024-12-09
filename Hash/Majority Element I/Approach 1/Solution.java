import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] arr = {2,2,1,1,1,2,2};
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            // if(hm.containsKey(arr[i])){
            //     hm.put(arr[i],hm.get(arr[i])+1);
            // }
            // else{
            //     hm.put(arr[i],1);
            // }
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        System.out.println(hm);
        int limiter = arr.length/2;
        System.out.print("Numbes appearing > "+limiter+" times are: ");
        for(Integer x:hm.keySet()){
            if(hm.get(x)>limiter){
                System.out.print(x+" ");
            }
        }
    }
}