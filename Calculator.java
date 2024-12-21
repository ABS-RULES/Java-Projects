import java.util.*;

class Calculator
{
 public static void main(String[] args)
 {
  Scanner sc = new Scanner(System.in);

  System.out.print("Welcome to the Simple Calculator!\n");

  System.out.print("Enter the value of number 1: ");
  float num1 = sc.nextFloat();

  System.out.print("Enter the value of num2: ");
  float num2 = sc.nextFloat();

  System.out.print("Choose an operation(+, -, *, /): ");
  char operation = sc.next().charAt(0);

  double result;

  switch(operation)
  {
    case '+':
    result = num1 + num2;
    System.out.printf("%.2f + %.2f = %.2f", num1, num2, result);
    break;

    case '-':
    result = num1 - num2;
    System.out.printf("%.2f - %.2f = %.2f", num1, num2, result);
    break;

    case '*':
    result = num1 * num2;
    System.out.printf("%.2f * %.2f = %.2f", num1, num2, result);
    break;

    case '/':
    if(num2 == 0)
    {
     System.out.println("Invalid Input!");
    }
    else{
     result = num1 / num2;
     System.out.printf("%.2f / %.2f = %.2f", num1, num2, result);
    }
    break;

    default:
    System.out.println("Invalid operator!");
    break;
  }
 }
}