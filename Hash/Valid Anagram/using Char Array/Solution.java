import java.util.*;
class Solution{
    public static void main(String[] args){
        String str1 ="care";
        String str2 ="race";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(arr1.length!=arr2.length){
            System.out.println("False");
            return;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}