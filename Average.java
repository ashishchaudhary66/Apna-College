import java.util.Scanner;
public class Average {
    public static void main(String[] args)
    {
        int a,b,c,avg;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a: ");
        a=sc.nextInt();
        System.out.print("Enter b: ");
        b=sc.nextInt();
        System.out.print("Enter c: ");
        c=sc.nextInt();
        avg=(a+b+c)/3;
        System.out.println("Average: "+avg);
    }
}
