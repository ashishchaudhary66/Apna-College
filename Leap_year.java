import java.util.Scanner;

public class Leap_year {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter year : ");
        int num=sc.nextInt();
        if(num%4==0)
        {
            if(num%100==0)
            {
                if(num%400==0)
                {
                    System.out.println("Leap Year");
                } else {
                    System.out.println("Non Leap Year");
                }
            } else {
                System.out.println("Leap Year");
            }
        }
    }
}
