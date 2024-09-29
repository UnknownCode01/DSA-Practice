import java.util.Scanner;

public class Diamond_of_special_characters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the special character: ");
        char specialChar = input.next().charAt(0);
        System.out.print("Enter the number of rows: ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(specialChar);
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(specialChar);
            }
            System.out.println();
        }
    }
}
