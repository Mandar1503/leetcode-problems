//Using usual heap and getting the kth element
// class Solution {
// public:
//     int findKthLargest(vector<int>& nums, int k) {
//         make_heap(nums.begin(),nums.end());
//         int max = 0;
//         for(int i=1;i<=k;i++)
//         {
//             max=nums.front();
//             pop_heap(nums.begin(),nums.end());
//             nums.pop_back();
//         }
//         if(max!=0)
//             return max;
//         else
//             return 0;
//     }
// };

//Using priority queue
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
           priority_queue<int> q;
            
            for(int n:nums)
            {
                q.push(n*(-1));
                if(q.size()>k)
                {
                    q.pop();
                }
            }
        return q.top()*(-1);
    }
};
