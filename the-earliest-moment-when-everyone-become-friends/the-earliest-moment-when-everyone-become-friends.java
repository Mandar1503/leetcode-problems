//CODE WRITTEN BY ME - WHICH IS SIMILAR TO THEIR SOLUTION
class UnionFind
{
    int[] root;
    int[] rank;
    
    public UnionFind(int n)
    {
        rank = new int[n];
        root = new int[n];
        for(int i=0;i<n;i++)
        {
            rank[i] = 1;
            root[i] = i;
        }
    }
    
    public int find(int x)
    {
        if(root[x] == x)
            return x;
        return root[x] = find(root[x]);
    }
    
    public boolean union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX==rootY)
            return false;
        else if(rootX!=rootY)
        {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else
            {
                root[rootX] = rootY;
                rank[rootY]+=1;
            }
        }
        return true;
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        
        int ans=-1;
        UnionFind uf = new UnionFind(n);
        
        Arrays.sort(logs, new Comparator<int[]>(){
            @Override
            public int compare(int entry1[], int entry2[])
            {
                return entry1[0] > entry2[0]?1:-1;
            }
        });
        
        
        int count = n;
        for(int i=0;i<logs.length;i++)
        {
            if(uf.union(logs[i][1],logs[i][2]))
            {
                count--;
                if(count==1)
                {
                    ans = logs[i][0];
                    System.out.print(logs[i][0]);
                    break;
                }    
            }        
        }
        return ans;
    }
}