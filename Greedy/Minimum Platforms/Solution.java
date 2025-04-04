import java.util.*;

class Solution {
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr); 
        Arrays.sort(dep); 
  
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        while (i < n && j < n) { 
        
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; 
            } 
  
            else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; 
            } 
  
            if (plat_needed > result) {
                result = plat_needed; 
            }
        } 
  
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 646, 1812, 1953, 1859, 46, 1935, 1624, 617, 1645, 628 };
        int dep[] = { 805, 2200, 2106, 2333, 1554, 2047, 2020, 1900, 2048, 2351 };
        System.out.println(findPlatform(arr, dep));
    }
}