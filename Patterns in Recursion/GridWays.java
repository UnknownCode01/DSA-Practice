// Time complexity = 2^(n+m) as in every ways we are bound to take n+m turns and we are taking either down or right in every turn and counting both right and down ways. 
//matrix = n x m ; i-> 0 to n-1 and j-> 0 to m-1
class GridWays{
    public static int recursion(int i, int j, int n, int m){
        if(i==n-1 && j==m-1){
            return 1;
        }
        else if(i==n || j==m){
            return 0;
        }
        int down=recursion(i+1,j,n,m);
        int right=recursion(i,j+1,n,m);
        return down+right;
    
    }
    public static void main(String[] args){
        int n=3;
        int m=3;
        int ways=recursion(0,0,n,m);
        System.out.println(ways);
    }
}