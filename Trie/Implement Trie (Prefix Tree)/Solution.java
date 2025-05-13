class Node {
    Node[] arr;
    boolean flag;

    Node() {
        arr = new Node[26];
        flag = false;
    }

    boolean containsKey(char ch) {
        return arr[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        arr[ch - 'a'] = node;
    }

    Node get(char ch) {
        return arr[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.containsKey(word.charAt(i))) {
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.containsKey(word.charAt(i))) {
                return false;
            }
            temp = temp.get(word.charAt(i));
        }
        return temp.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!temp.containsKey(prefix.charAt(i))) {
                return false;
            }
            temp = temp.get(prefix.charAt(i));
        }
        return true;
    }
}

class Solution {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.startsWith("app"));
    }
}