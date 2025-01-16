import java.util.*;
class Solution{
    static List<Integer> get(int a,int b)
    {
         List<Integer> l= new ArrayList<>();
         a=a^b;
         b=a^b;
         a=a^b;
         l.add(a);
         l.add(b);
         return l;
    }
    public static void main(String[] args){
        List<Integer> ans = get(4,7);
        System.out.println(ans.get(0)+" "+ans.get(1));
    }
}