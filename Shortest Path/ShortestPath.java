class ShortestPath{
    public static void distance(String str){
        int n = str.length();
        int x=0,y=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='N'){
                y++;
            }
            if(str.charAt(i)=='S'){
                y--;
            }
            if(str.charAt(i)=='W'){
                x--;
            }
            if(str.charAt(i)=='E'){
                x++;
            }
        }
        double ans = Math.sqrt(x*x+y*y);
        System.out.println(ans);
    }
    public static void main(String[] args){
        String str = "WNEENESENNN";
        distance(str);
        
    }
}