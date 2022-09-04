//RECURSIVE SOLUTION = BUT THIS WILL GIVE US SO TRY MEMOIZATION TO AVOID THIS
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i=0;i<nums.length;i++)
//         {
//             sum+=nums[i];
//         }
        
//         if(sum%2==0)
//         {
//             return helper(nums,sum/2,nums.length);
//         }
//         else
//         {
//             return false;
//         }
//     }
    
//     public boolean helper(int[] nums, int sum, int n)
//     {
//         if(n<=0)
//             return false;
        
//         if(sum==0)
//             return true;
        
//         if(sum >= nums[n-1])
//             return (helper(nums,sum-nums[n-1],n-1) || helper(nums,sum,n-1));
//         else
//             return helper(nums,sum,n-1);
//     }
// }

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        Boolean[][] arr = new Boolean[nums.length+1][sum+1];
        
        if(sum%2==0)
        {
            if(helper(nums,sum/2,nums.length,arr))
                return true;
            else
                return false;
        }
        else
        {
            return false;
        }
    }
    
    public boolean helper(int[] nums, int sum, int n, Boolean[][] arr)
    {
        if(sum==0)
            return true;
        
        if(n<=0)
            return false;
        
        if(arr[n][sum]!=null)
            return arr[n][sum];
        
        if(sum >= nums[n-1])
        {
            return arr[n][sum] = (helper(nums,sum-nums[n-1],n-1,arr) || helper(nums,sum,n-1,arr));
        }
        else
            return arr[n][sum] = helper(nums,sum,n-1,arr);
    }
}