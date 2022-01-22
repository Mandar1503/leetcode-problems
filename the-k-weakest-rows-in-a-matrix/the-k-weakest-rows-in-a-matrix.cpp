class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        map<int,vector<int>> weight;
        
        int m = mat.size();
        int n = mat[0].size();
        
        for(int i=0;i<m;i++)
        {
            int count = 0;
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    break;
                count++;
            }
            if(weight.count(count)==1)
                weight[count].push_back(i);
            else
                weight.insert(pair<int,vector<int>>(count,{i}));
        }
        
        vector<int> ans;
        int l=0;
        for(int i=0;i<weight.size();i++)
        {
            for(int j=0;j<weight[i].size();j++)
            {
                if(l==k)
                    break;
                ans.push_back(weight[i][j]);
                l++;
            }
            if(l==k)
                break;
        }
        return ans;
    }
};