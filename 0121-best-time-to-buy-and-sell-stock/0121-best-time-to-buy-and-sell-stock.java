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

//My Solution
// class Solution{
// 	public int maxProfit(int[] prices) 
// 	{
// 		int min = Integer.MAX_VALUE;
// 		int max = 0;
//         int diff = 0;
		
// 		for(int i=0;i<prices.length;i++)
// 		{
// 			if(prices[i]<min)
// 			{
// 				min = prices[i];
// 				max = prices[i];
// 			}
// 			else if(prices[i] > min  && prices[i] > max && diff < prices[i] - min )
// 			{
// 				max = prices[i];
//                 diff = prices[i] - min;
// 			}
// 		}
// 		return diff;
// 	}
// }

// MORE EFFICIENT SOLUTION (not take the max variable)
class Solution {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int mprofit = 0;
        
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i] < low)
                low = prices[i];
            else if(prices[i] - low > mprofit)  //else{mprofit = Math.max(mprofit, prices[i] - low);}
            {
                mprofit = prices[i] - low;
            }
        }
        return mprofit;
    }
}

