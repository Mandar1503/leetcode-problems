class UnionFind
{
    int[] root;
    int[] rank;
    
    public UnionFind(int n)
    {
        root = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++)
        {
            rank[i] = 1;
            root[i] = i;
        }
    }
    
    public int find(int x)
    {
        if(x == root[x])
            return x;
        
        return root[x] = find(root[x]);
    }
    
    public boolean union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX==rootY)
            return false;
        
        if(rootX!=rootY)
        {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else
            {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
        return true;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = n;
        boolean flag;
        for(int i=0;i<edges.length;i++)
        {
            flag = uf.union(edges[i][0],edges[i][1]);
            if(flag)
                count--;
        }
        return count;
    }
}