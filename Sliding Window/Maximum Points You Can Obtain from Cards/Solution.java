import java.util.*;
class Solution{
    public static int maxScore(int[] cardPoints, int k) {
        int count = 0;
        int ans = 0;
        int l = 0;
        int r = cardPoints.length-1;
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        count = leftSum+rightSum;
        ans = count;
        l = k-1;
        while(l>=0){
            count-=cardPoints[l];
            count+=cardPoints[r];
            l--;
            r--;
            ans = Math.max(count,ans);
        }

        return ans;
    }
    public static void main(String[] args){
        int[] cardPoints = {6,2,3,4,7,2,1,7,1};
        int k = 4;
        System.out.println(maxScore(cardPoints,k));
    }
}