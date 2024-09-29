import java.util.*;
class Solution{
    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        //put(key,value)
        hm.put("India",150);
        hm.put("China",200);
        hm.put("US",190);
        //print
        System.out.println("Hash Map -> "+hm);
        //Iteration Set get(key)
        Set<String> s = hm.keySet();
        System.out.println("Set -> "+s);
        for (String str : s){
            System.out.print(str+"->"+hm.get(str)+" ");
        }
        //value of ith index of Set
        //get(key)
        Integer x = hm.get("India");
        System.out.println("\nIndia -> "+x);
        //containsKey(key)
        System.out.println(hm.containsKey("US"));
        //size()
        System.out.println("size -> "+hm.size());
        //remove(key)
        System.out.println("US -> "+hm.remove("US"));
        System.out.println(hm.containsKey("US"));
        //clear()
        hm.clear();
        System.out.println("size -> "+hm.size());
        System.out.println(hm);
    }
}