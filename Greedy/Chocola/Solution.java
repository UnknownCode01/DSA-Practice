import java.util.*;
class Solution{
    public static void main(String[] args){
        int n = 4;//row
        int m = 6;//col
        Integer[] costVer={2,1,3,1,4};//m-1
        Integer[] costHor={4,1,2};//n-1

        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h=0; int v=0;
        int hp=1; int vp=1;
        int cost=0;

        while(h<n-1 && v<m-1){
            if(costHor[h]<costVer[v]){
                cost+=hp*costVer[v];
                v++;
                vp++;
            }
            else{
                cost+=vp*costHor[h];
                h++;
                hp++;
            }
        }
        while(h<n-1){
            cost+=vp*costHor[h];
            h++;
            hp++;
        }
        while(v<m-1){
            cost+=hp*costVer[v];
            v++;
            vp++;
        }

        System.out.println(cost);
    }
}