import java.util.Scanner;

class Factorial
{
 public static void main(String[] args) 
 {
  Scanner sc = new Scanner(System.in);
  
  System.out.print("Enter the value of n: ");
  int n = sc.nextInt();
  
  double fact = 1;
  for(int i=1; i<=n; i++)
  {
   fact *= i;
  }
  System.out.printf("Factorial of %d = %.1f", n, fact);
 }
}
