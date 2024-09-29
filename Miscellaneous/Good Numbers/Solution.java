class Solution {
    static int mod=(int)1e9+7;
    public static int countGoodNumbers(long n) {
        long first=(n%2==0?(n/2):(n/2)+1);
        long second=n/2;
        long mul1=power(5,first)%mod;//5 power n/2
        long mul2=power(4,second)%mod;//4 power n/2
        long ans=1;
        System.out.println("mul1->"+mul1);
        ans=(ans*mul1)%mod;//computing total product
        ans=(second!=0)?(ans*mul2)%mod:ans;//computing total product
        System.out.println("ans->"+ans);
        return (int)(ans%mod);
    }
    public static long power(long x,long n){
        if(n==0){
            System.out.println("1");
            return 1;  
        }
        else if(n==1){
            System.out.println(x+"="+x%mod);
            return x%mod;
        }
        else if(n%2==0){
            System.out.println(x+"x"+x+"="+(x*x)%mod);
            return (power((x*x)%mod,n/2))%mod;
        }
        else if(n%2!=0){
            System.out.println(x+"x"+x+"x"+x+"="+((x*x)%mod*x)%mod);
            return (x*power((x*x)%mod,n/2))%mod;
        }
         System.out.println(x);
        return power(x,n);
    }
    public static void main(String[] args){
        System.out.println(countGoodNumbers(1924));
    }
}