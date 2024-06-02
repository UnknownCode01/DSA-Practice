import java.util.Scanner;

public class Calculator_for_2_numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();
        boolean t = true;
        while (t) {
            System.out.println("Enter the operator \n1. +\n2. -\n3. *\n4. /");
            char operator = input.next().charAt(0);
            char op='n';
            if (operator == '1')
                op = '+';
            else if (operator == '2')
                op = '-';
            else if (operator == '3')
                op = '*';
            else if (operator == '4')
                op = '/';
            else{
                t=false;
            }
            double result=0;
            if(t){
            switch (operator) {
                case '1':
                    result = num1 + num2;
                    break;
                case '2':
                    result = num1 - num2;
                    break;
                case '3':
                    result = num1 * num2;
                    break;
                case '4':
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operator");
                    return;
            }
        }
        
        if(t)
        System.out.println(num1 + " " + op + " " + num2 + " = " + result);
        if(t==true)
        t=false;
        else{
        t=true;
        System.out.println("Invalid Operator\n");
        }
    }
    }
}
