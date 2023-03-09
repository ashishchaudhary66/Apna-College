import java.util.Scanner;

public class Check_positivity {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Number : ");
        int num=sc.nextInt();

        if( num > 0)
        {
            System.out.println("Number is Positive");
        }
        else if(num<0)
        {
            System.out.println("Number is Negative");
        }
        else
        {
            System.out.println("Neither Positive nor Negative");
        }
    }

}
