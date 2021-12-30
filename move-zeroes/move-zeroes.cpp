class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int l=0;
        int r=1;
        
        while(r<nums.size() && l<r)
        {
            if(nums[l]==0 && nums[r]!=0)
            {
                swap(nums,l,r);
                l++;
                r++;
            }
            else if(nums[l]!=0 && nums[r]==0)
            {
                l++;
                r++;
            }
            else if(nums[l]==0 && nums[r]==0)
            {
                r++;
            }
            else if(nums[l]!=0 && nums[r]!=0)
            {
                if(l+1==r)
                {
                    l++;
                    r++;
                }
                else
                    l++;
            }
        }
    }
    
public:
    void swap(vector<int>& nums,int l,int r)
    {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
};