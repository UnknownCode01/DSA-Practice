class Solution{
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] ans = countBits(5);
        for(int i:ans){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}