import java.util.Scanner;

public class DigitsSum_12 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number : ");
        int num=sc.nextInt();
        int total=digitSum(num);
        System.out.println("Sum of digits : "+total);

    }
    public static int digitSum(int n)
    {
        int sum=0;
        while(n>0)
        {
            int digit=n%10;
            sum+=digit;
            n/=10;
        }
        return sum;
    }
}
