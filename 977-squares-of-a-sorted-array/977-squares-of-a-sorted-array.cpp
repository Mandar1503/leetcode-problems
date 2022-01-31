class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int left =0;
        int right = nums.size()-1;
        int n = nums.size();
        
        int no;
        vector<int> ans(n);
        for(int i=n-1;i>=0;i--)
        {
            if(abs(nums[left])>abs(nums[right]))
            {
                no = nums[left];
                left++;
            }
            else
            {
                no = nums[right];
                right--;
            }
            ans[i]=no*no;
        }
        return ans;
    }
};