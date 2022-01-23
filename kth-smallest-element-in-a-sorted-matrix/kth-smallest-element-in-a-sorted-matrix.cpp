//MY SOLUTION BEST SOLUTION
//Also look at the solution for binary approach = GOOD BUT COMPLICATED
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
       
        int m = matrix.size();
        int n = matrix[0].size();
        
        priority_queue<int> heap; 
        
        int c = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                heap.push(matrix[i][j]);
                c=heap.size();
                if(c>k)
                {
                    heap.pop();
                    c=heap.size();
                }
            }
        }
        return heap.top();
    }
};