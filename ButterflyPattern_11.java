public class ButterflyPattern_11 {
    public static void main(String[] args)
    {
        int a=4,b=8;
        //Butterfly
        System.out.println("---Butterfly Pattern---");
        for(int i=1;i<=a;i++)
        {
            for(int j=1;j<=b;j++)
            {
                if(j<=i || j>=b-i+1)
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
                if(j<=i || j>=b-i+1)
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
        //Photo Frame
        System.out.println();
        System.out.println("---Photo Frame Pattern---");
        for(int i=a;i>=1;i--)
        {
            for(int j=b;j>=1;j--)
            {
                if(j<=i || j>=b-i+1)
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

        for(int i=1;i<=a;i++)
        {
            for(int j=1;j<=b;j++)
            {
                if(j<=i || j>=b-i+1)
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
