import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();
        
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String numStr = Integer.toString(i);
            int count2 = 0, count4 = 0, count8 = 0;

            for (char ch : numStr.toCharArray()) { 
                switch (ch) {
                    case '2': count2++; break;
                    case '4': count4++; break;
                    case '8': count8++; break;
                }
            }

            if (count2 == count4 && count4 == count8 && count2 > 0) {
                count++;
                arr.add(Integer.parseInt(numStr));
            }
        }

        System.out.println("Count of 248 numbers between 1 and " + N + ": " + count);
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        scanner.close();
    }
}
