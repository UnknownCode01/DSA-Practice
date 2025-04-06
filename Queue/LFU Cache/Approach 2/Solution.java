import java.util.*;

class LFUCache {

    public LFUCache(int capacity) {
        
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }
}

class Solution {
    public static void main(String[] args) {
        LFUCache obj = new LFUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1)); // 1
        obj.put(3, 3); // Removes key 2
        System.out.println(obj.get(2)); // -1
        System.out.println(obj.get(3)); // 3
        obj.put(4, 4); // Removes key 1
        System.out.println(obj.get(1)); // -1
        System.out.println(obj.get(3)); // 3
        System.out.println(obj.get(4)); // 4
    }
}
