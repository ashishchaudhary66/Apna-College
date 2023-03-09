import java.util.Scanner;

public class EvenOrOdd_12 {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n=sc.nextInt();
        if(isEven(n))
            System.out.println("Even Number");
        else
            System.out.println("Odd Number");
    }
    public static boolean isEven(int n)
    {
        if(n%2==0)
            return true;
        else
            return false;

    }
}
