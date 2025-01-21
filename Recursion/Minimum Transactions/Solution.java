import java.util.*;

public class Solution {
    public static int getMinTransactions(int n, List<List<Integer>> debts) {
        // Step 1: Calculate net balances for each person
        long[] balance = new long[n]; 
        for (List<Integer> debt : debts) {
            int from = debt.get(0);
            int to = debt.get(1);
            int amount = debt.get(2);
            balance[from] -= amount; // Person "from" owes money
            balance[to] += amount;   // Person "to" is owed money
        }

        // Step 2: Filter out zero balances (only keep unsettled debts)
        List<Long> balances = new ArrayList<>();
        for (long b : balance) {
            if (b != 0) {
                balances.add(b);
            }
        }

        // Step 3: Minimize transactions using backtracking
        int ans = settleBalances(balances, 0);
        return ans;
    }

    private static int settleBalances(List<Long> balances, int index) {
        // Skip already settled balances
        while (index < balances.size() && balances.get(index) == 0) {
            index++;
        }

        if (index == balances.size()) {
            return 0;
        }

        int minTransactions = Integer.MAX_VALUE;
        for (int i = index + 1; i < balances.size(); i++) {
            if ((balances.get(index) > 0 && balances.get(i) < 0) || (balances.get(index) < 0 && balances.get(i) > 0)) {
                balances.set(i, balances.get(i) + balances.get(index));
                minTransactions = Math.min(minTransactions, 1 + settleBalances(balances, index + 1));
                // Backtrack
                balances.set(i, balances.get(i) - balances.get(index));
            }
        }
        return minTransactions;
    }

    public static void main(String[] args) {
        int n1 = 3;
        List<List<Integer>> debts1 = Arrays.asList(
            Arrays.asList(0, 1, 10),
            Arrays.asList(2, 0, 5)
        );
        System.out.println(getMinTransactions(n1, debts1)); // Output: 2
    }
}
