//BRUTE FORCE
// class Solution {
// public:
//     vector<int> topKFrequent(vector<int>& nums, int k) {
//         map<int,int> cntr;
//         vector<int> ans;
//         for(int n:nums)
//         {
//             if(cntr.find(n)!=cntr.end())
//             {
//                 cntr[n]++;
//                 if(cntr[n]==k)
//                     ans.push_back(n);
//             }
//             else
//             {
//                 cntr.insert({n,1});
//                 if(k==1)
//                     ans.push_back(n);
//             }
//         }
//         return ans;
//     }
// };

//Solution using MIN HEAP 
class Solution {
    
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        priority_queue < pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>> > heap; //heap for min heap
        //similar to = priority_queue <int,int,greater<int>> min_heap;
        
        map <int,int> mp; //for initial storage of cntr
        
        vector<int> result;
        
        for(int n:nums) //store the elements and their counts
        {
            mp[n]++;
        }
        
        for(auto i=mp.begin();i!=mp.end();i++) //iterate the whole map
        {
            heap.push({i->second,i->first}); // push the pair such that the freq ie the second element is first as the heap will be ordered using the first element(key) of the map
            if(heap.size()>k)
                heap.pop();
        }
        
        while(heap.size()>0)  //then just empty the elements in to the result vector
        {
            result.push_back(heap.top().second);
            heap.pop();
        }
        return result;     
    }
};