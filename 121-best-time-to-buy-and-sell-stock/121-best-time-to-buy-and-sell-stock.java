//Brute force doesn't run O(n^2)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxprofit = 0;
//         for(int i=0;i<prices.length;i++)
//         {
//             for(int j=i+1;j<prices.length;j++)
//             {
//                 int profit = prices[j] - prices[i];
//                 if(profit > maxprofit)
//                     maxprofit=profit;
//             }
//         }
//         return maxprofit;
//     }
// }


class Solution {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int mprofit = 0;
        
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i] < low)
                low = prices[i];
            else if(prices[i] - low > mprofit)
            {
                mprofit = prices[i] - low;
            }
        }
        return mprofit;
    }
}