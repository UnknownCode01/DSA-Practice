class Solution{
    public static int unset(int n){
        return n&(n-1);
    } 
    public static void main(String[] args){
        System.out.println(unset(16));
        System.out.println(unset(10));
    }
}