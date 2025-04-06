import java.util.*;

class Node {
    int key;
    int value;
    Node prev, next;

    Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

class LRUCache {
    private Map<Integer, Node> hm;
    private int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        Node temp;
        int ans = -1;
        if (hm.containsKey(key)) {
            temp = hm.get(key);
            ans = temp.value;
            remove(temp);
            insert(temp);
        }
        // System.out.println("Get done: "+ans);
        return ans;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            remove(hm.get(key));
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        hm.put(key, newNode);
        if (hm.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            hm.remove(lru.key);
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