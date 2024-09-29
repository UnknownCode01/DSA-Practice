class DublicateCharRemover{
    public static void print(String str){
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        int[] ch = new int[26];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' ' && ch[str.charAt(i)-'a']==0){
                sb.append(str.charAt(i));
                ch[str.charAt(i)-'a']=1;
            }
        }
        sb.toString();
        System.out.print(sb);
    }
    public static void main(String[] args){
        String str = "Hello There";
        print(str);
    }
}