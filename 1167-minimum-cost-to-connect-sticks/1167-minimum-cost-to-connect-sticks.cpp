//my more optimized solution
class Solution {
public:
    int connectSticks(vector<int>& sticks) {
        priority_queue<int,vector<int>,greater<int>> minheap;
        
        for(int i=0;i<sticks.size();i++)
        {
            minheap.push(sticks[i]);
        }
        int cost = 0;
        while(minheap.size()>1)
        {
            int no1 = minheap.top();
            minheap.pop();
            
            int no2 = minheap.top();
            minheap.pop();
            
            cost+=(no1+no2);
            
            minheap.push(no1+no2);
        }
        return cost;
    }
};