class Solution{
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend==divisor)   return 1;
        boolean isNegative = false;
        if(dividend>=0 && divisor<0){
            isNegative = true;
        }
        if(dividend<0 && divisor>0){
            isNegative = true;
        }
        long n = Math.abs((long) dividend);
        int d = Math.abs(divisor);
        int ans = 0;
        while(n>=d){
            int count = 0;
            while(n>=(d<<(count+1))){
                count++;
                // int d1 = d<<(count+1);
            }
            ans+=1<<count;
            n-=d<<(count);
        }
        return isNegative?-ans:ans;
    }
    public static void main(String[] args){
        System.out.println(divide(-70,2));
        System.out.println(divide1(-70,2));
    }
    public static int divide1(int dividend, int divisor) {
        // int n = 0;
        long c = 0;
        long sign = 1;
        if (divisor == 1) return dividend;
        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) sign = -1;
        long dd = Math.abs((long) dividend);
        long dr = Math.abs((long) divisor);
        for (int i = 30; i >= 0; i--) {
            if (dd >= (dr << i)) {
                c += (1 << i);
                dd -= (dr << i);
            }
        }
        return (int) (c * sign);
    }
}