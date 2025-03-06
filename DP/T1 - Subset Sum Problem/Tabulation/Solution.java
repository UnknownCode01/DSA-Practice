class Solution {
    static Boolean isSubsetSum1(int arr[], int k) {
        int n = arr.length;
        boolean dp[][] = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }
        // Printing the DP table
        // System.out.println("DP Table:");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= k; j++) {
        //         System.out.print((dp[i][j] ? "T " : "F "));
        //     }
        //     System.out.println();
        // }
        return dp[n - 1][k];
    }

    static Boolean isSubsetSum2(int arr[], int k) {
        int n = arr.length;
        boolean dp[] = new boolean[k + 1];
        dp[0] = true; // Base case: sum 0 can always be achieved (empty subset)

        if (arr[0] <= k) {
            dp[arr[0]] = true; // If the first element is <= k, mark it as achievable
        }
        for (int ind = 1; ind < n; ind++) {
            // Traverse `dp` array **backwards** to avoid overwriting results from the same iteration
            for (int target = k; target >= arr[ind]; target--) {
                dp[target] = dp[target] || dp[target - arr[ind]];
            }
        }
        return dp[k];
    }

    public static void main(String args[]) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int k = 9;
        System.out.println(isSubsetSum1(arr, k));
        System.out.println(isSubsetSum2(arr, k));
    }
}
