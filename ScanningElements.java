import java.util.*;
class ScanningElements{
public static void main(String args[]) 
{
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the size of array: ");
    int n=sc.nextInt();
    boolean a[]=new boolean[n];
    System.out.print("Enter the elements of the array: ");
    for(int i=0; i<a.length; i++)
    {
        a[i]=sc.nextBoolean();
    }
    for(int i=0; i<a.length; i++)
    {
        System.out.print(a[i]+" ");
    }
}
}