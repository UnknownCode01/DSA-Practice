import java.util.*;

class LRUCache {
    private LinkedHashMap<Integer, Integer> lhm;
    private int capacity;

    public LRUCache(int capacity) {
        this.lhm = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int ans = -1;
        if(lhm.containsKey(key)){
            ans = lhm.getOrDefault(key,-1);
            lhm.remove(key);
            lhm.put(key, ans); 
        }
        // System.out.println("Get done: "+ans);
        return ans;
    }

    public void put(int key, int value) {
        if(lhm.containsKey(key)){
            lhm.remove(key);
        }
        lhm.put(key, value);
        if (lhm.size() > capacity) {
            Iterator<Integer> it = lhm.keySet().iterator();
            if (it.hasNext()) {
                lhm.remove(it.next());
            }
        }
        // System.out.println("Put done");
    }
}

class Solution {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3, 3);
        obj.get(2);
        obj.put(4, 4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
        System.out.println();
    }
}