class StringCompression{
    public static void print(String str){
        StringBuilder sb = new StringBuilder("");
        sb.append(str.charAt(0));
        int c = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                c++;
            }
            else{
                if(c!=1){
                    sb.append(c);
                }
                sb.append(str.charAt(i));
                c=1;
            }
        }

        sb.toString();
        System.out.println(sb);
    }
    public static void main(String[] args){
        String str = "aabcccdde";
        print(str);
    }
}