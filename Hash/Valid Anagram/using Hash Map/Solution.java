import java.util.*;
class Solution{
    public static void main(String[] args){
        String str1 = "care";
        String str2 = "race";
        if(str1.length()!=str2.length()){
            System.out.println("False");
            return;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str2.length();i++){
            char ch = str2.charAt(i);
            if(hm.get(ch)!=null){
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }
                else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }
            else{
                System.out.println("False");
                return;
            }
        }
        if(hm.isEmpty()){
            System.out.println("True");
            return;
        }
        System.out.println("False");
    }
}