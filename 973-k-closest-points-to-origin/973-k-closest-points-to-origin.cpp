//VERY IMPO PROBLEM = ASKED IN META
//SOLUTION BY SORTING WITH THE CUSTOM COMPARATOR
// class Solution {
// public:
//     vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
//         sort(points.begin(),points.end(),[&](vector<int> a,vector<int> b){
//             return squaredDist(a)<squaredDist(b);
//         });
        
//         return vector<vector<int>>(points.begin(),points.begin()+k);
//     }
    
// private:
//     int squaredDist(vector<int>& point)
//     {
//         return point[0]*point[0]+point[1]*point[1];
//     }
// };


//USING MAX HEAP IE PRIORITY QUEUE = MY Solution
// class Solution {
// public:
//     vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
//         priority_queue<pair<int,int>> maxheap;
        
//         for(int i=0;i<points.size();i++)
//         {
//             if(k<=maxheap.size())
//             {
//                 maxheap.pop();
//             }
//             maxheap.push({squaredDist(points[i]),i});
//         }
        
//         vector<vector<int>> ans;
//         while(!maxheap.empty())
//         {
//             ans.push_back(points[maxheap.top().second]);
//             maxheap.pop();
//         }
//         return ans;
//     }

// private:
//     int squaredDist(vector<int>& point)
//     {
//         return point[0]*point[0]+point[1]*point[1];
//     }
// };

//USING MAX HEAP IE PRIORITY QUEUE = Their solution
class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        priority_queue<pair<int,int>> maxheap;
        
        for(int i=0;i<points.size();i++)
        {
            pair<int,int> entry = {squaredDist(points[i]),i};
            
            if(k>maxheap.size())
            {
                maxheap.push(entry);
            }
            else if(entry.first<maxheap.top().first)
            {
                maxheap.pop();
                maxheap.push(entry);
            }
        }
        
        vector<vector<int>> ans;
        while(!maxheap.empty())
        {
            ans.push_back(points[maxheap.top().second]);
            maxheap.pop();
        }
        return ans;
    }

private:
    int squaredDist(vector<int>& point)
    {
        return point[0]*point[0]+point[1]*point[1];
    }
};