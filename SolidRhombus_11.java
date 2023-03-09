public class SolidRhombus_11 {
    public static void main(String[] args)
    {
        int a=5,b=9;
        for(int i=1;i<=a;i++)
        {
            for(int j=1;j<=b;j++)
            {
                if((j<=b-i+1) && (j>=a-i+1))
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
