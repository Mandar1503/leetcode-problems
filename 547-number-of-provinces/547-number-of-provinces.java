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
            set.add(find(i));                //important step in the code 
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


//THEIR SOLUTION USING UNION FIND
// class Solution {
//     // Union Find
//     public int findCircleNum(int[][] isConnected) {
//         if (isConnected == null || isConnected.length == 0) {
//             return 0;
//         }

//         int n = isConnected.length;
//         UnionFind uf = new UnionFind(n);
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (isConnected[i][j] == 1) {
//                     uf.union(i, j);
//                 }
//             }
//         }

//         return uf.getCount();
//     }

//     class UnionFind {
//         private int[] root;
//         private int[] rank;
//         private int count;

//         UnionFind(int size) {
//             root = new int[size];
//             rank = new int[size];
//             count = size;
//             for (int i = 0; i < size; i++) {
//                 root[i] = i;
//                 rank[i] = 1;
//             }
//         }

//         int find(int x) {
//             if (x == root[x]) {
//                 return x;
//             }
//             return root[x] = find(root[x]);
//         }

//         void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);
//             if (rootX != rootY) {
//                 if (rank[rootX] > rank[rootY]) {
//                     root[rootY] = rootX;
//                 } else if (rank[rootX] < rank[rootY]) {
//                     root[rootX] = rootY;
//                 } else {
//                     root[rootY] = rootX;
//                     rank[rootX] += 1;
//                 }
//                 count--;
//             }
//         }

//         int getCount() {
//             return count;
//         }
//     }
// }