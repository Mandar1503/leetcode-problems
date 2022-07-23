class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        int temp = 1;
        left[0] = 1;
        for(int i=1;i<n;i++)
        {
            temp = nums[i-1] * temp;
            left[i] = temp;
        }
        
        int temp2 = 1;
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--)
        {
            temp2 = nums[i+1] * temp2;
            right[i] = temp2;
        }
        
        for(int i =0;i<n;i++)
        {
            answer[i] = left[i]*right[i];
        }
        return answer;
        
    }
}