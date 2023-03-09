public class IndexOfElement_14 {

    public static void main(String[] args)
    {
    //Rotation Of the Array
        int nums[]={3,4,5,6,7,8};
        rotateArray(nums,3);
        System.out.print("Rotated Array : ");
        for (int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }
        System.out.println();

    //Searching the index of the target Element
        int target=3;
        int ans=indexElement(nums,target);
        System.out.println("Index : "+ans);

    }
    public static void rotateArray(int arr[],int k)
    {

        int rotated[]=new int[arr.length];
        int j=0;
        for(int i=k;i<arr.length;i++,j++)
        {
            rotated[j]=arr[i];
        }
        for(int i=0;i<k;i++,j++)
        {
            rotated[j]=arr[i];
        }
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=rotated[i];
        }

    }

    public static int indexElement(int arr[],int target)
    {

        int k=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]>arr[i])
            {
                k=i;
            }
        }
        rotateArray(arr,k);
        System.out.print("Rotated Array : ");
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        int start=0,end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]>target)
            {
                end=mid-1;
            } else if (arr[mid]<target) {
                start=mid+1;
            }
            else{
                return (mid+k)%arr.length;
            }
        }
        return -1;

    }

}
