public class DiamondPattern_11 {
    public static void main(String[] args)
    {
        int a=4,b=7;
        for(int i=1;i<=a;i++)
        {
            for(int j=1;j<=b;j++)
            {
                if((j>=a-i+1) && (j<=a+i-1))
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for(int i=a;i>=1;i--)
        {
            for(int j=b;j>=1;j--)
            {
                if((j>=a-i+1) && (j<=a+i-1))
                {
                    System.out.print("* ");
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
