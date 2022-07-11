class UnionFind
{
    int[] root;
    int[] rank;
    
    public UnionFind(int length)
    {
        root = new int[length];
        rank = new int[length];
        
        for(int i=0;i<length;i++)
        {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    int find(int node)
    {
        if(root[node] == node)
            return node;
        
        return root[node] = find(root[node]);
    }
    
    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
            
        if(rootX == rootY)
            return;
        else
        {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;   
            else if(rank[rootX] == rank[rootY])
            {
                root[rootY] = rootX;
                rank[rootX]+=1;
            }
        }
    }
    
    boolean connected(int x, int y)
    {
        return find(x) == find(y);
    }
}

class Solution {
    
    //Map<Integer,ArrayList<Integer>> distbwpoints = new HashMap<>();
    
//     public static void sortByKey()
//     {
//         TreeMap<Integer,ArrayList<Integer>> sorted = new TreeMap<>(distbwpoints);
//         return sorted;
//     }
    
    public int minCostConnectPoints(int[][] points) { 
        
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        ArrayList<int[]> allEdges = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int dist = manhattanDist(points[i][0],points[i][1],points[j][0],points[j][1]);
                //distbwpoints.put(dist,new ArrayList<Integer>(Arrays.asList(i,j)));
                int[] currEdge = {dist,i,j};
                allEdges.add(currEdge);
            }
        }
        
        Collections.sort(allEdges, (a,b)->Integer.compare(a[0],b[0]));
        
        int mstCost = 0;
        int edgesUsed = 0;
        
        for(int i = 0; i < allEdges.size() && edgesUsed < n-1; i++)
        {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            
            if(!uf.connected(node1,node2))
            {
                uf.union(node1,node2);
                mstCost+=allEdges.get(i)[0];
                edgesUsed+=1;
            }
        }
        //Map<Integer,ArrayList<Integer>> sortedByDist = sortByKey();
        return mstCost;        
    }
    
    public int manhattanDist(int x1, int y1, int x2, int y2)
    {
        return Math.abs(x2-x1)+Math.abs(y2-y1);
    }
}