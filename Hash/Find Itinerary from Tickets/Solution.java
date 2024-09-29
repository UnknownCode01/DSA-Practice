import java.util.*;
class Solution{
    public static String findStartingPoint(HashMap<String,String> tickets){
        HashMap<String,String> rev = new HashMap<>();
        for(String str:tickets.keySet()){
            rev.put(tickets.get(str),str);
        }    
        for(String str:tickets.keySet()){
            if(!rev.containsKey(str)){
                return str;
            }
        }
        return null;
    }
    public static void main(String[] args){
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bangaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        String StartingPoint = findStartingPoint(tickets);
        System.out.print(StartingPoint);
        for(String str:tickets.keySet()){
            System.out.print("->"+tickets.get(StartingPoint));
            StartingPoint=tickets.get(StartingPoint);
        }
        System.out.println();
    }
}