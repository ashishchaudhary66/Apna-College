public class TrapingWater_14 {
    public static void main(String[] args)
    {
        int height[]={4,2,0,3,2,5};
        System.out.print("Height : ");
        for(int i=0;i<height.length;i++){
            System.out.print(height[i]+" ");
        }
        System.out.println("\nWater Traped : "+trap(height));
    }
    public static int trap(int height[]){
        int len=height.length;
        int leftMax[]=new int[len];
        int rightMax[]=new int[len];

    //maximum value of ith element from the left side
        leftMax[0]=height[0];
        for(int i=1;i<len;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }

    //maximum value of ith element from the left side
        rightMax[len-1]=height[len-1];
        for(int i=len-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        System.out.print("\nleft max : ");
        for(int i=0;i<len;i++){
            System.out.print(leftMax[i]+" ");
        }

        System.out.print("\nright max : ");
        for(int i=0;i<len;i++){
            System.out.print(rightMax[i]+" ");
        }


    // traped water(ith element) = (Minimum of the leftMax and rightMax of ith element)-ith element
        int totalTrapedWater=0;
        System.out.print("\nTraped Water : ");
        for(int i=0;i<len;i++){
            int waterLevel=Math.min(leftMax[i],rightMax[i]);
            int trapedWater=waterLevel-height[i];
            System.out.print(trapedWater+" ");
            totalTrapedWater+=trapedWater;
        }
        return totalTrapedWater;

    }

}
