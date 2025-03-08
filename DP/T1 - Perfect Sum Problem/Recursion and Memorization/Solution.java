import java.util.Arrays;

class Solution {
    static int f(int index, int arr[], int target, int[][] dp) {
        if (index == 0) {
            // System.out.println("Base case reached: index=0, target=" + target);
            if (target == 0 && arr[0] == 0)
                return 2; // Two ways: pick or not pick zero
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notTake = f(index - 1, arr, target, dp);
        int take = 0;
        if (target >= arr[index]) {
            // System.out.println("Trying to take: index=" + index + ", target=" + target + ", arr[index]=" + arr[index]);
            take = f(index - 1, arr, target - arr[index], dp);
        }
        dp[index][target] = notTake + take;
        return dp[index][target];
    }

    public static int perfectSum(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        int x = f(arr.length - 1, arr, target, dp);
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return x;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 3, 10, 6, 8 };
        int target = 10;
        System.out.println(perfectSum(arr, target));
    }
}