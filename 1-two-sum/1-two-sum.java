class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> ele = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int no = target - nums[i];
            if(ele.containsKey(no))
            {
                ans[0] = ele.get(no);
                ans[1] = i;
                return ans;
            }
            else
            {
                ele.put(nums[i],i);
            }
        }
        return ans;
    }
}