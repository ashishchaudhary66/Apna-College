import java.util.Scanner;

public class palindrome_12 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number : ");
        int num=sc.nextInt();
        if(isPalindrome(num))
            System.out.println("Number is : Palindrome");
        else
            System.out.println("Number is : Not a Palindrome");
    }
    public static boolean isPalindrome(int n)
    {
        int num=n;
        int reverse=0;
        while(n>0)
        {
            int rem=n%10;
            reverse=reverse*10+rem;
            n=n/10;
        }
        System.out.println("Reversed Number : "+reverse);
        if(reverse==num)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
