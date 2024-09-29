class FindPermutation{
    public static void backtrack(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String omitted = str.substring(0,i)+str.substring(i+1);
            backtrack(omitted,ans+curr);
        }
    }
    public static void main(String[] args){
        String str = "abc";
        backtrack(str,"");
        System.out.println();
    }
}