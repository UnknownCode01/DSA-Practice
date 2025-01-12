class Solution{
    static int setBit(int n) {
        int ans=(n|(n+1));
        return ans;
    }
    public static void main(String[] args){
        System.out.println(setBit(4));
    }
}