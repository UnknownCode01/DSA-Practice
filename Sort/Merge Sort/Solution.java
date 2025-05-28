class Solution {
    public static void merge(int arr[], int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int[] arr2 = new int[r - l + 1];
        int index = 0;
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                arr2[index] = arr[i];
                i++;
                index++;
            } else {
                arr2[index] = arr[j];
                j++;
                index++;
            }
        }
        while (i <= m) {
            arr2[index] = arr[i];
            i++;
            index++;
        }
        while (j <= r) {
            arr2[index] = arr[j];
            j++;
            index++;
        }
        // Copy back to original array
        for (int k = 0; k < arr2.length; k++) {
            arr[l + k] = arr2[k];
        }
    }

    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 6 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}