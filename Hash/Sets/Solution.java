import java.util.*;
class Solution{
    public static void main(String[] args){
        HashSet<Integer> hs = new HashSet<>();
        hs.add(12);
        hs.add(91);
        hs.add(8);
        hs.add(1);
        hs.add(2);
        System.out.println("Hash Map-> "+hs);

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(12);
        lhs.add(91);
        lhs.add(8);
        lhs.add(1);
        lhs.add(2);
        System.out.println("Linked Hash Map-> "+lhs);

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(12);
        ts.add(91);
        ts.add(8);
        ts.add(1);
        ts.add(2);
        System.out.println("Tree Map-> "+ts);
        Iterator it = ts.iterator();
        System.out.print("Iterator-> ");
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}