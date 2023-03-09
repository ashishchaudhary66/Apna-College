public class RepeatedIntegers_14 {
    public static boolean isRepeated(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        int array[]={1,2,3,3};
        System.out.println(isRepeated(array));
    }
}
