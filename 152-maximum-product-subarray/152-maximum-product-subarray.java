class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        if(n==0)
            return 0;
        
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i=1;i<n;i++)
        {
            int curr = nums[i];
            int temp_max =  Math.max(curr,Math.max(curr*max, curr*min));
            min = Math.min(curr,Math.min(curr*max, curr*min));
            
            max = temp_max;
            
            result = Math.max(result,max);
        }
        return result;
    }
}

//BRUTE FORCE = TIME LIMIT EXCEEDED
// class Solution {
//     public int maxProduct(int[] nums) {
//         int n =  nums.length;
//         int result = nums[0];
//         for(int i=0;i<n;i++)
//         {
//             int acc = 1;
//             for(int j=i;j<n;j++)
//             {
//                 acc*=nums[j];
//                 result = Math.max(result,acc);
//             }
//         }
//         return result;
//     }
// }

// class Solution {
//     public int maxProduct(int[] nums) {
        
//         int n = nums.length;
//         int currProd = nums[0];
//         int currProd2 = nums[0];
//         int maxProd = nums[0];
        
//         for(int i=1;i<n;i++)
//         {
//             currProd2 *= nums[i];
//             currProd = Math.max(nums[i],Math.max(currProd2,currProd*nums[i]));
//             maxProd = Math.max(currProd,maxProd);
//         }
//         return maxProd;
//     }
// }

// class Solution {
//     int[] numsArray;
//     public int maxProduct(int[] nums) {
//         numsArray = nums;
//         return findBestProduct(0,nums.length-1); 
//     }
    
//     private int findBestProduct(int left, int right)
//     {
//         if(left>right)
//             return Integer.MIN_VALUE;
        
//         int mid = Math.floorDiv(left+right,2);
//         int bestLeftProd = 1;
//         int bestRightProd = 1;
        
//         int curr = 1;
//         for(int i=mid-1;i>=left;i--)
//         {
//             curr *= numsArray[i];
//             bestLeftProd = Math.max(bestLeftProd,curr);
//         }
        
//         for(int i=mid+1;i<=right;i++)
//         {
//             curr *= numsArray[i];
//             bestRightProd = Math.max(bestRightProd,curr);
//         }
        
//         int bestCombined = Math.max(mid*bestLeftProd*bestRightProd, Math.max(bestLeftProd,bestRightProd));
        
//         int bestLeftSide = findBestProduct(left,mid-1);
//         int bestRightSide = findBestProduct(mid+1,right);
        
//         return Math.max(bestCombined,Math.max(bestLeftProd,bestRightProd));
//     }
// }