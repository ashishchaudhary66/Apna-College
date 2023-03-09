public class HollowRhombus_11 {
    public static void main(String[] args)
    {
        int a=5,b=20;
        for(int i=1;i<=a;i++)
        {
            for(int j=1;j<=b;j++)
            {
                if((i==1 && j>=a)||(i==a && j<=b-i+1)||(j==a-i+1)||(j==b-i+1))
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
