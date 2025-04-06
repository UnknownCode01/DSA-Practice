import java.util.*;

class Node {
    int key, value, freq;
    Node prev, next;

    Node(int k, int v) {
        this.key = k;
        this.value = v;
        this.freq = 1; // Initially set to 1 since it's used once
    }
}

class DoublyLinkedList {
    int size;
    Node head, tail;

    DoublyLinkedList() {
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void add(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node removeLast() {
        if (size > 0) {
            Node last = tail.prev;
            remove(last);
            return last;
        }
        return null;
    }
}

class LFUCache {
    Map<Integer, Node> keyNode;
    Map<Integer, DoublyLinkedList> freqListMap;
    int maxSizeCache, minFreq, currSize;

    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        currSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) return -1;
        Node node = keyNode.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (maxSizeCache == 0) return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (currSize >= maxSizeCache) {
                DoublyLinkedList minFreqList = freqListMap.get(minFreq);
                Node nodeToRemove = minFreqList.removeLast();
                keyNode.remove(nodeToRemove.key);
                currSize--;
            }

            Node newNode = new Node(key, value);
            keyNode.put(key, newNode);
            freqListMap.putIfAbsent(1, new DoublyLinkedList());
            freqListMap.get(1).add(newNode);
            minFreq = 1;
            currSize++;
        }
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqListMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqListMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqListMap.get(node.freq).add(node);
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
