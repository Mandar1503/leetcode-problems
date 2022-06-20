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
                rootX+=1;
            }
        }
        return true;
    }
    
    public int count()
    {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<root.length;i++)
        {
            set.add(find(i));                //important step in the code 
        }
        return set.size();
    }
}


class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
       
        if(edges.length!=n-1)
            return false;
        
        for(int i=0;i<edges.length;i++)
        {
            if(!uf.union(edges[i][0],edges[i][1]))
                return false;
        }
        
        // boolean flag = true;
        // for(int i=0; i<uf.root.length-1; i++)
        // {
        //     if(uf.root[i]!=uf.root[i+1])
        //         flag = false;
        // }
        // if(count == n-1 && flag)
        //     return true;
        // else 
        //     return false;
        return true;
    }
}