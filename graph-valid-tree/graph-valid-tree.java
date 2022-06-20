//MY SOLUTION(USING COUNT FUNCTION)
// class UnionFind{
//     int[] root;
//     int[] rank;
    
//     public UnionFind(int length)
//     {
//         root = new int[length];
//         rank = new int[length];
        
//         for(int i=0;i<length;i++)
//         {
//             rank[i] = 1;
//             root[i] = i;
//         }
//     }
    
//     public int find(int x)
//     {
//         if(root[x]==x)
//             return x;
//         return root[x] = find(root[x]);
//     }
    
//     public void union(int x, int y)
//     {
//         int rootX = find(x);
//         int rootY = find(y);
        
//         if(rootX!=rootY)
//         {
//             if(rank[rootX] > rank[rootY])
//                 root[rootY] = rootX;
//             else if(rank[rootX] < rank[rootY])
//                 root[rootX] = rootY;
//             else
//             {
//                 root[rootY] = rootX;
//                 rootX+=1;
//             }
//         }
//     }
    
//     public boolean count()
//     {
//         Set<Integer> set = new HashSet<>();
//         for(int i=0;i<root.length;i++)
//         {
//             set.add(find(i));                //important step in the code 
//         }
//         return set.size()==1?true:false;
//     }
// }


// class Solution {
//     public boolean validTree(int n, int[][] edges) {
//         UnionFind uf = new UnionFind(n);

//         int count = 0;
//         for(int i=0;i<edges.length;i++)
//         {
//             uf.union(edges[i][0],edges[i][1]);
//             count++;
//         }
       
//         if(count == n-1 && uf.count())
//             return true;
//         else 
//             return false;
//     }
// }


//THEIR SOLUTION(BY MODIFYING THE UNION FUNCTION)
class UnionFind{
    int[] root;
    int[] rank;
    
    //initialization
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
    
    //find function with path optimization
    public int find(int x)
    {
        if(root[x]==x)
            return x;
        return root[x] = find(root[x]);
    }
    
    //slightly changed union function return false if root is same before union otherwise true
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
        
        return true;
    }
}