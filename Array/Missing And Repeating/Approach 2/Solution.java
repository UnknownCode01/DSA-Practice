import java.util.*;

class Solution {
    static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int rep = 0;
        int miss = 0;
        long sum = 0;
        long squareSum = 0;
        for (int i : arr) {
            sum += (long)i;
            squareSum += (long) i * i;
        }
        long total = (long)n * (n + 1) / 2;// 1+2+...+n
        long singleDiff = sum - total;// rep-miss
        total = (long)n * (n + 1) * (2 * n + 1) / 6;// 1^2+2^2+...+n^2
        long squareDiff = squareSum - total;// rep^2-miss^2
        long add = squareDiff / singleDiff;// rep+miss
        rep = (int)(singleDiff + add) / 2;
        miss = (int)(add - rep);
        ans.add(rep);
        ans.add(miss);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 6, 2, 1, 1 };
        System.out.println(findTwoElement(arr));
    }
}