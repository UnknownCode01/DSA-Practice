class Solution {
    static int merge(int arr[], int l, int m, int r) {
        int cnt = 0;
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                cnt += n1 - i;
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return cnt;
    }

    static int sort(int arr[], int l, int r) {
        int cnt = 0;
        if (l >= r) {
            return cnt;
        }
        int m = l + (r - l) / 2;
        cnt += sort(arr, l, m);
        cnt += sort(arr, m + 1, r);
        cnt += merge(arr, l, m, r);
        return cnt;
    }

    static int inversionCount(int arr[]) {
        return sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };
        System.out.println(inversionCount(arr));
    }
}