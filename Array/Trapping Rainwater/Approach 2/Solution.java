class Solution{
    public static int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = n-1;
        int total = 0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]<leftMax){
                    total+=leftMax-height[l];
                }else{
                    leftMax = height[l];
                }
                l++;
            }else{
                if(height[r]<rightMax){
                    total+=rightMax-height[r];
                }else{
                    rightMax = height[r];
                }
                r--;
            }
        }

        return total;
    }
    public static void main(String[] args) {
        int[] height = {4,2,0,6,3,2,5};
        int ans = trap(height);
        System.out.println("\nThe amount of water trapped is "+ans+" units");
     }
}