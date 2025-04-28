class Solution {
    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];// to be safe 4 times the elements is taken
    }

    public static int buildST(int[] arr, int i, int start, int end) {
        if (start == end) {
            return tree[i] = arr[start];
        }
        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid);
        buildST(arr, 2 * i + 2, mid + 1, end);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    public static int getSumUtil(int index, int i, int j, int m, int n) {
        if (i > n || m > j) {
            return 0;
        } else if (m >= i && n <= j) {
            return tree[index];
        } else {
            int mid = (m + n) / 2;
            int left = getSumUtil(index * 2 + 1, i, j, m, mid);
            int right = getSumUtil(index * 2 + 2, i, j, mid + 1, n);
            return left + right;
        }
    }

    public static int getSum(int[] arr, int i, int j) {
        int n = arr.length;
        return getSumUtil(0, i, j, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n - 1);
        System.out.println(getSum(arr, 2, 5));
    }
}