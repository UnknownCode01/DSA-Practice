import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] arr = {2,2,1,1,1,2,2};
        int counter = 0;
        int element=arr[0];
        for(int i=0;i<arr.length;i++){
            if(counter==0){
                counter++;
                element=arr[i];
            }else if(element==arr[i]){
                counter++;
            }else{
                counter--;
            }
        }
        counter=0;
        for(int i:arr){
            if(i==element){
                counter++;
            }
        }
        if(counter>arr.length/2){
            //do nothing
        }else{
            element=-1;
        }
        int limiter = arr.length/2;
        System.out.print("Numbe appearing > n/2="+limiter+" times is: ");
        System.out.println(element);
        
    }
}