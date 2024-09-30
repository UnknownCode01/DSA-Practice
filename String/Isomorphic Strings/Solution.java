import java.util.*;
class Solution {
    public static boolean isIsomorphic(String s, String t) {
        int[] indexS = new int[200]; 
        int[] indexT = new int[200]; 

        int len = s.length();
        if(len != t.length()) {
            return false;
        }

        for(int i = 0; i < len; i++) {
            // System.out.println("Previously");
            // System.out.println(s.charAt(i)+"-"+indexS[s.charAt(i)]);
            // System.out.println(t.charAt(i)+"-"+indexT[t.charAt(i)]);
            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                System.out.println("Error");
                return false; 
            }
            
            indexS[s.charAt(i)] = i + 1; 
            indexT[t.charAt(i)] = i + 1; 
            // System.out.println("Now");
            // System.out.println(s.charAt(i)+"-"+indexS[s.charAt(i)]);
            // System.out.println(t.charAt(i)+"-"+indexT[t.charAt(i)]);
        }
        return true;
    }
    public static void main(String[] args){
        String a = "bob";
        String b = "bkk";
        System.out.println(isIsomorphic(a,b));
        // System.out.println("\n............Another.............\n");
        String c = "boo";
        String d = "egg";
        System.out.println(isIsomorphic(c,d));
    }
}

