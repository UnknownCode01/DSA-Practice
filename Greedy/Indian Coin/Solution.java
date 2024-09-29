import java.util.*;
class Solution{
    public static void main(String[] args){
        Integer[] coins = {1,2,5,10,20,50,100,200,2000};
        Arrays.sort(coins,Collections.reverseOrder());
        int count=0;
        int amount=590;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                count++;
                arr.add(coins[i]);
                amount-=coins[i];
                i--;
            }
        }
        
        System.out.println("no of coins "+count);
        System.out.println(arr);
    }
}