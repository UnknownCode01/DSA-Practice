import java.util.*;

class Solution {
    static class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = id.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(id[i], deadline[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        // for (int i = 0; i < n; i++) {
        //     System.out.println(jobs[i].id + " " + jobs[i].deadline + " " + jobs[i].profit);
        // }
        int[] arr = new int[n+1];
        arr[0]=-1;
        int maxProfit = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int k = jobs[i].deadline;
            for (int j = k; j > 0; j--) {
                if (arr[j] == 0) {
                    arr[j] = jobs[i].id;
                    maxProfit += jobs[i].profit;
                    count++;
                    break;
                }
            }
        }
        ans.add(count);
        ans.add(maxProfit);

        return ans;
    }

    public static void main(String[] args) {
        int[] id = { 1, 2, 3, 4, 5 };
        int[] deadline = { 2, 1, 2, 1, 1 };
        int[] profit = { 100, 19, 27, 25, 15 };
        System.out.println(JobSequencing(id, deadline, profit));
    }
}