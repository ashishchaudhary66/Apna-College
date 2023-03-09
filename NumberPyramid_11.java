public class NumberPyramid_11 {
    public static void main(String[] args)
    {
        int n=5;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n+n-1;j++)
            {
                if(j>=n-i+1 && j<=n+i-1)
                {
                    if((i%2==0 && j%2==1)||(i%2==1 && j%2==0))
                    {
                        System.out.print("  ");
                    }
                    else
                    {
                        System.out.print(i+" ");
                    }
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
