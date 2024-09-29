import java.util.*;
class Solution{
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        ArrayList<Integer> arr1=new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(2);
        ArrayList<Integer> arr2=new ArrayList<>();
        arr2.add(3);
        arr2.add(4);
        ArrayList<Integer> arr3=new ArrayList<>();
        arr3.add(5);
        arr3.add(6);
        arr3.add(7);
        arr3.add(8);
        mainList.add(arr1);
        mainList.add(arr2);
        mainList.add(arr3);

        System.out.println(mainList);

        for(int i=0;i<mainList.size();i++){
            for(int j=0;j<mainList.get(i).size();j++){
                System.out.print(mainList.get(i).get(j)+" ");
            }
                System.out.println();
        }
    }
}