class Solution {
    public static void swapGreater(int[] arr1, int[] arr2, int index1, int index2) {
        if (arr1[index1] > arr2[index2]) {
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }

    public static void f(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int gap = (int) Math.ceil((n + m) / 2.0);
        // int gap = ((n + m + 1) / 2); // as ceil(a / b) = (a + b - 1) / b
        // int gap = (n / 2) + (n % 2); // does same as above
        while (gap > 0) {
            int left = 0;
            int right = (left + gap);
            while (right < (n + m)) {
                if (left < n && right >= n) {
                    swapGreater(arr1, arr2, left, right - n);
                } else if (left >= n) {// both in 2nd arr
                    swapGreater(arr2, arr2, left - n, right - n);
                } else {// both in 1st arr
                    swapGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) {
                break;
            } else {
                gap = (int) Math.ceil(gap / 2.0);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 0, 2, 6, 8, 9 };
        f(arr1, arr2);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}