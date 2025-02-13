import java.util.*;

public class Solution {
    public static int findLIS(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        
        // Compute LIS values for all indexes
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Find the maximum value in dp array
        int maxLength = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    
    // Method to print the actual sequence (bonus functionality)
    public static List<Integer> printLIS(int[] arr) {     
        int[] dp = new int[arr.length];
        int[] previousIndex = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.fill(previousIndex, -1);
        
        int maxLength = 1;
        int maxIndex = 0;
        
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    previousIndex[i] = j;
                    
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        
        // Reconstruct the sequence
        List<Integer> sequence = new ArrayList<>();
        while (maxIndex != -1) {
            sequence.add(0, arr[maxIndex]);
            maxIndex = previousIndex[maxIndex];
        }
        
        return sequence;
    }
    
    public static void main(String[] args) {
        // int[] arr = {1, 200, 30, 40, 20};
        int[] arr = {1000, 200, 100, 200, 300};
        System.out.println("Length of LIS: " + findLIS(arr));
        System.out.println("One possible LIS: " + printLIS(arr));
    }
}