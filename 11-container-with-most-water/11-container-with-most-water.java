class Solution {
    public int maxArea(int[] height) {
        
        int low = 0;
        int high = height.length-1;
        
        int maxArea = Math.min(height[low],height[high])*Math.abs(low-high);
        
        while(low < high)
        {
            if(height[low]<height[high])
            {
                low++;
                int area = Math.min(height[low],height[high])*Math.abs(low-high);
                maxArea = Math.max(area,maxArea);
            }
            else
            {
                high--;
                int area = Math.min(height[low],height[high])*Math.abs(low-high);
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }
}