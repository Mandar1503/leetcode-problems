//APPROACH 1: Done similar to Sum II solution using that solution, initially by sorting
//ALSO CHECK FOR OTHER SOLNS IN THE SOLUTIONS

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());                  //sort the vector

        vector<vector<int>> res;
    
        for(int i=0;i<nums.size() && nums[i]<=0;i++)    //iterate loop till end or till nums value is smaller than 0
        {
            if(i==0 || nums[i]!=nums[i-1])              //pass values to sum2 if i==0 for initial case and for further elements if nums[i]!=nums[i-1] to avoid duplicate entries
            {
                sum2(nums,i,res);
            }
        }
        return res;
    }
    
    void sum2(vector<int>& nums, int i,vector<vector<int>>& res)
    {
        int low = i+1, high = nums.size()-1;            //initialize
        
        while(low<high)                                 //condition     
        {
            int sum = nums[i]+nums[low]+nums[high];     //calculate sum
            
            if(sum>0)                                   //sum>0,it means we have to take smaller values thus high-- 
            {
                high--;
            }
            else if(sum<0)                              //sum<0,it means we have to take larger values thus low++
            {
                low++;
            }
            else                                        //if sum==0
            {
                res.push_back({nums[i],nums[low],nums[high]}); //push ans in to the result & low++ & high--
                low++;
                high--;
                while(low<high && nums[low]==nums[low-1])//check if the next low we are taking is same as prev to avoid duplicate entries
                {
                    low++;                              //if such is the case then incr low
                }
            }
        }
    }
};