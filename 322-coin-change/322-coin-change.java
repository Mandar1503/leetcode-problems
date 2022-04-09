// //DP SOLUTION
// class Solution {
//     public int coinChange(int[] coins, int amount) {
       
//         //declare a dp array and take the size of the array as amount+1 to be max
//         int[] dp = new int[amount+1];
//         Arrays.fill(dp,amount+1); //fill the array by amount+1 max size
        
//         dp[0]=0;            //for the base case
            
//         for(int i=1;i<=amount;i++)  //to iterate & compute for all the values from 0 to goal amount
//         {
//             for(int j=0;j<coins.length;j++) //to check for each of the coin
//             {
//                 if(coins[j]<=i)     //if coin is greater than the current amount i then do not consider it 
//                     dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);   //calculate the appropriate best/min number of coins that can be used to compute the amount using each of the coin
//             }
//         }
//         return dp[amount]>amount?-1:dp[amount];  //if the dp[amount] is still greater than amount then we know that there is no way to get the amount using those coins.
//     }
// }


//DP SOLUTION MORE OPTIMIZED (sort the array of coins and do not go ahead for the coins that are greater than the amount)

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int dp[] = new int[amount+1];
        
        Arrays.fill(dp,amount+1);
        
        dp[0] = 0;
        
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i)
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                else
                    break;
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}