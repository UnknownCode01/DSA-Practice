class Solution{
    public static int min(int[] arr) {
        int a = arr[0];
        for(int i:arr){
            if(i<a){
                a=i;
            }
        }
        return a;
    }
    public static int numberOfSubstrings(String s) {
        int count = 0;
        int[] lastSeen = {-1,-1,-1};
        for(int i=0; i<s.length(); i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                count+=1+min(lastSeen);
            }
        }
        return count;        
    }
    public static void main(String[] args){
        System.out.println(numberOfSubstrings("bbacba"));
    }
}