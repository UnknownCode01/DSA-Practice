class FriendsPairing{
    public static int f(int n){
        if(n==1 || n==2){
            return n;
        }
        int single_pair = f(n-1);
        int double_pair = f(n-2);
        int pair_ways = (n-1) * double_pair;
        int total_ways = single_pair + pair_ways;
        return total_ways;
    }
    public static void main(String[] args){
        int n = 5;
        int ans = f(n);
        System.out.println(ans);
    }
}