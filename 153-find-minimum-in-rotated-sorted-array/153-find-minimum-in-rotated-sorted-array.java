class Solution {
    public int findMin(int[] nums) {
        
        //if length if the nums is 1 then return the 1st element 
        if(nums.length == 1)
            return nums[0];
        
        //set left and right index to the 1st and the last element index
        int left = 0;
        int right = nums.length -1;
        
        //if 1st index element is smaller than the last element then the array is sorted and return 1st element  
        if(nums[0]<nums[right])
            return nums[0];
        
        //while left <= right
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            
            //if mid is > than mid + 1, then mid + 1 is the smallest element, since it is the point of inflection
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            else if(nums[mid-1] > nums[mid]) //here mid is the point of inflection
                return nums[mid];
            
            if(nums[0] < nums[mid]) //if num at 0 is smaller than num at mid then search for the inflection point on the right hand side
            {
                left = mid + 1;
            }
            else //else search at the left hand side 
            {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;   //else return the max value of the Integer
    }
}