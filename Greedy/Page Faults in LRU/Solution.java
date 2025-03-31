import java.util.*;

class Solution {
    static int pageFaults(int n, int c, int pages[]) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        int ans = 0;
        for (int i : pages) {
            if (lhs.contains(i)) {
                lhs.remove(i);
                lhs.add(i);
            } else {
                ans++;
                if (lhs.size() == c) {
                    Iterator<Integer> it = lhs.iterator();
                    it.next();
                    it.remove();
                }
                lhs.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] pages = { 5, 0, 1, 3, 2, 4, 1, 0, 5 };
        System.out.println(pageFaults(pages.length, 4, pages));
    }
}