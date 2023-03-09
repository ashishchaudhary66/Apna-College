import java.util.Scanner;

public class PalindromicPattern_11 {
    public static void main(String[] args)
    {
        int n=5;
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<=n;i++)
        {
            int count=i;
            for(int j=1;j<=n;j++)
            {

                if(j>=n-i+1)
                {
                    System.out.print(count-- + " ");
                }
                else
                {
                    System.out.print("  ");
                }
            }

            for(int j=1;j<=i-1;j++)
            {
                count=j+1;
                if(j<=n+i-1)
                {
                    System.out.print(count++ + " ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
