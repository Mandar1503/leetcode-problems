
//APPROACH 1 = Using two arrays for left part and right part
// class Solution {
// public:
//     vector<int> productExceptSelf(vector<int>& nums) {
//         vector<int> left;
//         vector<int> right;
//         vector<int> ans;
        
//         int prod=1;
//         left.push_back(1);
//         for(int i=1;i<nums.size();i++)
//         {
//             prod*=nums[i-1];
//             left.push_back(prod);
//         }
        
//         prod=1;
//         right.insert(right.begin(),1);
//         for(int i=nums.size()-2;i>=0;i--)
//         {
//             prod*=nums[i+1];
//             right.insert(right.begin(),prod);
//         }
        
//         for(int i=0;i<nums.size();i++)
//         {
//             ans.push_back(left[i]*right[i]);
//         }
//         return ans;
//     }
// };

//APPROACH 2: With O(1) Space complexity
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> ans;
        int n = nums.size();
        
        int prod = 1;
        ans.push_back(1);
        for(int i=1;i<n;i++)
        {
            prod*=nums[i-1];
            ans.push_back(prod);
        }
        
        prod = 1;
        ans[n-1]*=prod;
        for(int i=n-2;i>=0;i--)
        {
            prod*=nums[i+1];
            ans[i]*=prod;
        }
        return ans;
    }
};