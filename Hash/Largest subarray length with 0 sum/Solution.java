import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] arr = {15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> hm = new HashMap<>();  //<sum,index>
        int sum = 0;
        int len = 0;
        int temp = 0;
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                temp = i-hm.get(sum);
                len = Math.max(temp,len);
            }else{
                hm.put(sum,i);
            }
        }
    //Doesnot take the whole array as subarray
        System.out.println(len);
    }
}