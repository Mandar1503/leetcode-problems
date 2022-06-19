class UnionFind{
    int[] root;
    int[] rank;
    
    public UnionFind(int length)
    {
        root = new int[length];
        rank = new int[length];
        
        for(int i=0;i<length;i++)
        {
            rank[i] = 1;
            root[i] = i;
        }
    }
    
    public int find(int x)
    {
        if(root[x]==x)
            return x;
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX!=rootY)
        {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else
            {
                root[rootY] = rootX;
                rootX+=1;
            }
        }
    }
    
    public int count()
    {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<root.length;i++)
        {
            set.add(find(i));
        }
        return set.size();
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }
}