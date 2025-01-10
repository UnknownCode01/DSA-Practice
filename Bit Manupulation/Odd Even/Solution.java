class Solution{
    static String oddEven(int n) {
        if((n & 1) == 1){
            return "odd";
        }
        return "even";
    }
    public static void main(String[] args){
        System.out.println(oddEven(6));
        System.out.println(oddEven(9));
    }
}