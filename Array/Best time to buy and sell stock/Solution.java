/*
Sample Input 1:
6
7 1 5 4 3 6

Sample Output 1 :
5

Explanation Of Sample Input 1:
Purchase stock on day two, where the price is one, and sell it on day six, where the price is 6. Profit = 6 - 1 = 5.

Sample Input 2:
5
5 4 3 2 1

Sample Output 2 :
0

Expected time complexity :
The expected time complexity is O(n).
*/
public class Solution {
    public static int bestTimeToBuyAndSellStock(int []prices) {
        // Write your code here.
        int profit=0;
        int mini=prices[0];
        int cost;
        for(int i=0;i<prices.length;i++){
            cost=prices[i]-mini;
            profit=Math.max(profit,cost);
            mini=Math.min(mini,prices[i]);
        }
        return profit;
    }
}
