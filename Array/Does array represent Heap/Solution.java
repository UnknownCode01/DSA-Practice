class Solution {
    public static boolean countSub(long arr[], long n) {
        int i = 0;
        int j = i + 1;
        if (arr.length == 1) {
            return true;
        }
        while (j < n - 1) {
            if (arr[i] >= arr[j] && arr[i] >= arr[j + 1]) {
                i++;
                j += 2;
                continue;
            }
            return false;
        }
        if (n % 2 == 0) {
            if (arr[i] < arr[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long arr[] = { 4,4,3 };
        long n = 3;
        System.out.println(countSub(arr, n));
    }
}