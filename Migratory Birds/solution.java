/*
Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.

Example
arr=[1,1,2,2,3]
There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.s
*/

import java.util.*;
class solution{
    public static int migratoryBirds(List<Integer> arr) {
        int max=arr.get(0);
        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        int[] a=new int[max+1];
        for(int i:arr){
            a[i]++;
        }
        max=a[0];
        int ans=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
                ans=i;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        System.out.println(migratoryBirds(arr));
    }

}
    