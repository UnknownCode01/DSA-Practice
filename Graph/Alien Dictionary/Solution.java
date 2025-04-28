import java.util.*;

class Solution {
    public static boolean dfsTopo(int node, int[] vis, List<List<Integer>> adj, Stack<Integer> s) {
        vis[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 1) {
                return true;
            }
            if (vis[i] == 0) {
                if (dfsTopo(i, vis, adj, s)) {
                    return true;
                }
            }
        }
        vis[node] = 2;
        s.push(node);
        return false;
    }

    public static ArrayList<Integer> topoSort(List<List<Integer>> adj) {
        int[] vis = new int[adj.size()];
        ArrayList<Integer> ls = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] == 0) {
                if (dfsTopo(i, vis, adj, s)) {
                    return new ArrayList<>();
                }
            }
        }
        while (!s.isEmpty()) {
            ls.add(s.pop());
        }
        return ls;
    }

    public static String findOrder(String[] words) {
        int n = words.length;
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                st.add(words[i].charAt(j));
            }
        }
        int m = st.size();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }
        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<Integer, Character> indexToChar = new HashMap<>();
        int idx = 0;
        for (char c : st) {
            charToIndex.put(c, idx);
            indexToChar.put(idx, c);
            idx++;
        }
        for (int i = 0; i < n - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int length = Math.min(a.length(), b.length());
            for (int j = 0; j < length; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    adj.get(charToIndex.get(a.charAt(j))).add(charToIndex.get(b.charAt(j)));
                    break;
                }
                if (j == length - 1 && a.length() > b.length()) {
                    return "";
                }
            }
        }
        List<Integer> topo = topoSort(adj);
        if (topo.isEmpty()) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for (int i : topo) {
            ans.append(indexToChar.get(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] words = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println(findOrder(words));
    }
}