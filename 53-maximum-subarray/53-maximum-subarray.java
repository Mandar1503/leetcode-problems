// class Solution {
//     public int maxSubArray(int[] nums) {
//         // Initialize our variables using the first element.
//         int currentSubarray = nums[0];
//         int maxSubarray = nums[0];
        
//         // Start with the 2nd element since we already used the first one.
//         for (int i = 1; i < nums.length; i++) {
//             int num = nums[i];
//             // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
//             currentSubarray = Math.max(num, currentSubarray + num);
//             maxSubarray = Math.max(maxSubarray, currentSubarray);
//         }
        
//         return maxSubarray;
//     }
// }

//Divide and conquer
class Solution {
    
    int[] numsArray;
    
    public int maxSubArray(int[] nums) {
        numsArray = nums;
        return findBestSubarray(0,nums.length-1);
    }
    
    public int findBestSubarray(int l, int r)
    {
        if(l>r)
            return Integer.MIN_VALUE;
        
        double div = (l+r)/2;
        int mid = (l+r)/2;
        int curr = 0;
        int bRSum = 0;
        int bLSum = 0;
        
        for(int i=mid-1;i>=l;i--)
        {
            curr+=numsArray[i];
            bLSum = Math.max(bLSum,curr);
        }
        
        curr=0;
        for(int i=mid+1;i<=r;i++)
        {
            curr+=numsArray[i];
            bRSum = Math.max(bRSum,curr);
        }
        
        int bCSum = numsArray[mid] + bLSum + bRSum;
        
        int lHalf = findBestSubarray(l,mid-1);
        int rHalf = findBestSubarray(mid+1,r);
        
        return Math.max(bCSum,Math.max(lHalf,rHalf));
    }
}