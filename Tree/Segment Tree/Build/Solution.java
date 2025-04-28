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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n - 1);
        for (int i : tree) {
            System.out.print(i + " ");
        }
    }
}