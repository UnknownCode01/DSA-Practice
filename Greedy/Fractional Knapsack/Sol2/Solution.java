import java.util.*;
class Solution{
    static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        double ans = 0;
        int n = val.size();
        double[][] ratio = new double[n][2];
        for(int i=0;i<n;i++){
            ratio[i][0]=i;
            ratio[i][1]=(double)val.get(i)/wt.get(i);
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        for(int i=n-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=wt.get(idx)){
                ans+=val.get(idx);
                capacity-=wt.get(idx);
                if(capacity==0){
                    break;
                }
            }else{
                ans+=capacity*ratio[i][1];
                capacity=0;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        List<Integer> val = Arrays.asList(100,60,100,200);
        List<Integer> wt = Arrays.asList(20,10,50,50);
        int capacity = 90;
        System.out.println(fractionalKnapsack(val,wt,capacity));
    }
}