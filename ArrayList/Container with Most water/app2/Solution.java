import java.util.*;
class Solution{
    public static void storeWater(ArrayList<Integer> height){
        int max=0;
        int l=0,r=height.size()-1;
        while(l<r){
            int h=Math.min(height.get(l),height.get(r));
            int w=r-l;
            int area=h*w;
            max=Math.max(area,max);
            if(l<r){
                l++;
            }
            else{
                r--;
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args){
        ArrayList<Integer> height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        storeWater(height);

    }
}