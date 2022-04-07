class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> ele = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int no = target - nums[i];
            if(ele.containsKey(no))
                return new int[] {ele.get(no), i};
            else
                ele.put(nums[i],i);
        }
        return null;
    }
}