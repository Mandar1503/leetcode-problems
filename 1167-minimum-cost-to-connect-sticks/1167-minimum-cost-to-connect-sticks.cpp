//My orignal solution Time= O(nlogn)
class Solution {
public:
    int connectSticks(vector<int>& sticks) {
        priority_queue<int,vector<int>,greater<int>> minheap;
        
        for(int i=0;i<sticks.size();i++)
        {
            minheap.push(sticks[i]);
        }
        
        if(minheap.size()==1)
            return 0;
        
        vector<int> costs;
        
        while(!minheap.empty())
        {
            int no1 = minheap.top();
            minheap.pop();
            
            int no2 = minheap.top();
            minheap.pop();
            
            int sum = no1 + no2;
            costs.push_back(sum);
            minheap.push(sum);
            
            if(minheap.size()==1)
                break;
        }
        int cost = 0;
        for(int i=0;i<costs.size();i++)
        {
            cost+=costs[i];
        }
        return cost;
    }
};

//my more optimized solution
// class Solution {
// public:
//     int connectSticks(vector<int>& sticks) {
//         priority_queue<int,vector<int>,greater<int>> minheap;
        
//         for(int i=0;i<sticks.size();i++)
//         {
//             minheap.push(sticks[i]);
//         }
//         int cost = 0;
//         while(minheap.size()>1)
//         {
//             int no1 = minheap.top();
//             minheap.pop();
            
//             int no2 = minheap.top();
//             minheap.pop();
            
//             cost+=(no1+no2);
            
//             minheap.push(no1+no2);
//         }
//         return cost;
//     }
// };