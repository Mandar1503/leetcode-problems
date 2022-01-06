//Using max heap
class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> maxheap; // make a maxheap  
        
        for(int n:stones)//push all elements into a heap
        {
            maxheap.push(n);
        }
        int k=maxheap.size();//get the size of heap
        
        while(k>1)//until k>1 iterate the loop to pop top 2 elements and enter their difference back again
        {
            int ele1=maxheap.top(); //remove first ele
            maxheap.pop();
            int ele2=maxheap.top();//remove second
            maxheap.pop();
            int newele = ele1 - ele2; 
            maxheap.push(newele);
            k = maxheap.size();     //update k
        }
        return maxheap.top();  
    }
};