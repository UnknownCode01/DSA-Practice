import java.util.*;

class Solution {
    public static void f(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
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