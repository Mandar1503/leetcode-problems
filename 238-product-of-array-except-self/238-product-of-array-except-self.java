//MY SOLUTION = 100%
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] answer = new int[n];
//         int[] left = new int[n];
//         int[] right = new int[n];
        
//         int temp = 1;
//         left[0] = 1;
//         for(int i=1;i<n;i++)
//         {
//             temp = nums[i-1] * temp;
//             left[i] = temp;
//         }
        
//         int temp2 = 1;
//         right[n-1] = 1;
//         for(int i=n-2;i>=0;i--)
//         {
//             temp2 = nums[i+1] * temp2;
//             right[i] = temp2;
//         }
        
//         for(int i =0;i<n;i++)
//         {
//             answer[i] = left[i]*right[i];
//         }
//         return answer;
        
//     }
// }

//THEIR SOLUTION 
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] answer = new int[n];
//         int[] left = new int[n];
//         int[] right = new int[n];
        
//         left[0] = 1;
//         for(int i=1;i<n;i++)
//         {
//             left[i] = nums[i-1] * left[i-1];
//         }
        
//         right[n-1] = 1;
//         for(int i=n-2;i>=0;i--)
//         {
//             right[i] = nums[i+1] * right[i+1];
//         }
        
//         for(int i =0;i<n;i++)
//         {
//             answer[i] = left[i]*right[i];
//         }
//         return answer;
        
//     }
// }
 
//OPTIMIZED SOLUTION = IN O(1) SPACE COMPLEXITY
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        answer[0] = 1;
        for(int i=1;i<n;i++)
        {
            answer[i] = answer[i-1] * nums[i-1];
        }
        
        int temp = 1;
        for(int i = n-1 ; i>=0 ; i--)
        {
            answer[i] = answer[i] * temp;
            temp = temp * nums[i];
        }
        return answer;        
    }
}