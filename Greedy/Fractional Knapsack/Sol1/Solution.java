import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] val={60,100,120};
        int[] weight={10,20,30};
        int w = 50; 
        int capacity = w;
        int n = val.length;
        double[][] ratio = new double[n][2];
        for(int i=0;i<n;i++){
            ratio[i][0]=i;
            ratio[i][1]=(double)val[i]/weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double maxProfit=0;
        for(int i=n-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                maxProfit+=val[idx];
                capacity-=weight[idx];
                if(capacity==0){
                    break;
                }
            }else{
                maxProfit+=capacity*ratio[i][1];
                capacity=0;
                break;
            }
        }
        //or
        // int j=n-1;
        // int idx=(int)ratio[j][0];
        // while(capacity>weight[idx] && j>=0){
        //     capacity-=weight[idx];
        //     maxProfit+=val[idx];
        //     j--;
        //     idx = (int) ratio[j][0];
        // }
        // if(capacity>0){
        //     maxProfit+=(ratio[j][1])*capacity;
        //     capacity=0;
        // }
        System.out.println(maxProfit);
    }
}