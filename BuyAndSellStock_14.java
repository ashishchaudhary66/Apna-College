public class BuyAndSellStock_14 {
    public static void main(String[] args){
        int prices[]={7, 6, 4, 3, 1};
        System.out.println("Maximum Profit is : "+maxProfit(prices));
    }
    public static int maxProfit(int arr[]){
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            int buyStock=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>buyStock)
                {
                    int profit=arr[j]-buyStock;
                    if(profit>max)
                    {
                        max=profit;
                    }
                }
                else{
                    buyStock=arr[j];
                }
            }

        }
        return max;
    }
}
