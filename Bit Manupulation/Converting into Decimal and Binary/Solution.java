class Solution{
    public static String decimal2Binary(String s){
        String ans = "";
        int n = Integer.parseInt(s);
        while(n>0){
            int temp= n%2;
            ans+=temp;
            n=n/2;
        }
        StringBuilder sb = new StringBuilder(ans);
        ans=sb.reverse().toString();
        return ans;
    }
    public static String binary2Decimal(String s){
        String ans = "";
        // int n = Integer.parseInt(s);
        int temp=0;
        int p=1;
        for(int i=s.length()-1;i>=0;i--){
            temp+=p*(s.charAt(i)-'0');
            p*=2;
        }
        ans=Integer.toString(temp);
        return ans;
    }
    public static void main(String[] args){
        String s1 = "13";
        String s2 = "1101";
        System.out.println(decimal2Binary(s1));
        System.out.println(binary2Decimal(s2));
        
    }
}