import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] start={3,0,5,8,1,5};
        int[] end={4,6,7,9,2,9};
        int n = start.length;
        int[][] activity=new int[n][3];

        for(int i=0;i<n;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }

        Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));
        int count=1;
        int prevEnd=activity[0][2];
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(activity[0][0]);
        for(int i=1;i<n;i++){
            if(activity[i][1]>prevEnd){
                count++;
                prevEnd=activity[i][2];
                arr.add(activity[i][0]);
            }
        }
        System.out.println("Total "+count);
        for(int i=0;i<arr.size();i++){
            System.out.print("A"+arr.get(i)+" ");
        }
    }
}