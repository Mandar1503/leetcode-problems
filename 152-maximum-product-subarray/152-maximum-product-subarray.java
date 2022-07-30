//DP
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