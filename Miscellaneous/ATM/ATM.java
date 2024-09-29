import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double balance = 0.0; // initial balance
        
        while (true) { // loop until user selects exit
            System.out.println("Select an option:");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Exit");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = input.nextDouble();
                    if (withdrawAmount > balance) {
                        System.out.println("Transaction failed. Insufficient balance.");
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("Withdrawal successful. Payable cash: $%.2f, Available balance: $%.2f\n", withdrawAmount, balance);
                    }
                break;
                    
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();
                    balance += depositAmount;
                    System.out.printf("Deposit successful. Current balance: $%.2f\n", balance);
                    break;
                    
                case 3:
                    System.out.printf("Current balance: $%.2f\n", balance);
                    break;
                    
                case 4:
                    System.out.println("Exiting ATM program.");
                    return;
                    
                default:
                    System.out.println("Invalid option.");
            
            }
            
 }
}
}