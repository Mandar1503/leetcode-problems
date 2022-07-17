//Prims Algorithm
class Solution {
    
    class Edge{
        int point1;
        int point2;
        int cost;
        
        public Edge(int point1, int point2, int cost)
        {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        
        // List<Edge> allEdges = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        //make the 1st point to be visited
        visited[0] = true;
        //add all the edges from the 1st point into the queue and the alledges list
        for(int i=1;i<n;i++)
        {
            int dist = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]);
            // allEdges.add(new Edge(0,i,dist));
            pq.add(new Edge(0,i,dist));
        }
        
        int totalCost = 0;
        //check for other edges from other points
        int count = n-1;//have a count n-1 since 1st element is already considered
        while(!pq.isEmpty() && count > 0)
        {
            Edge curEdge = pq.poll();
            int point1 = curEdge.point1;
            int point2 = curEdge.point2;
            int cost = curEdge.cost;
            
            if(!visited[point2])    //see if 2nd point is not visited then only go inside
            {
                visited[point2] = true;
                totalCost += cost;
                count--;
                
                for(int i=0;i<n;i++)        //iterate for all its other connecting non visited neighbours
                {
                    if(!visited[i])
                    {
                        int dist = Math.abs(points[point2][0] - points[i][0]) + Math.abs(points[point2][1] - points[i][1]);
                        // allEdges.add(new Edge(point2,i,dist));
                        pq.add(new Edge(point2,i,dist));
                    }
                }
            }
        }
        return totalCost;
    } 
}

//THIS CODE DOESN'T WORK SINCE IT USES MAPS TO STORE THE DIST AND THE POINTS, IF THERE ARE MULTIPLE SAME DISTANCE THEN A MAP DOESN'T WORK IN THIS CASE(KRUSKALS ALGO)
// class UnionFind
// {
//     int[] root;
//     int[] rank;
    
//     public UnionFind(int length)
//     {
//         root = new int[length];
//         rank = new int[length];
        
//         for(int i=0;i<length;i++)
//         {
//             root[i] = i;
//             rank[i] = 1;
//         }
//     }
    
//     public int find(int x)
//     {
//         if(root[x] == x)
//             return x;
        
//         return root[x] = find(root[x]);
//     }
    
//     public void union(int x, int y)
//     {
//         int rootX = find(x);
//         int rootY = find(y);
        
//         if(rootX == rootY)
//             return;
//         else
//         {
//             if(rank[rootX] > rank[rootY])
//                 root[rootY] = rootX;
//             else if(rank[rootX] < rank[rootY])
//                 root[rootX] = rootY;
//             else if(rank[rootX] == rank[rootY])
//             {
//                 root[rootY] = rootX;
//                 rank[rootX]+=1;
//             }
//         }
//     }
    
//     public boolean connected(int x, int y)
//     {
//         return find(x)==find(y);
//     }
// }


// class Solution {
    
//     public int manhattanDist(int x1, int y1, int x2, int y2)
//     {
//         return Math.abs(x2-x1)+Math.abs(y2-y1);
//     }
    
//     public static TreeMap<Integer,ArrayList<Integer>> sortByKey(Map<Integer,ArrayList<Integer>> map1)
//     {
//         TreeMap<Integer,ArrayList<Integer>> sorted = new TreeMap<>(map1);
        
//         for(Map.Entry<Integer,ArrayList<Integer>> entry : sorted.entrySet())
//         {
//             System.out.println("Key ="+ entry.getKey()+" , points = "+ entry.getValue().get(0) +" , "+ entry.getValue().get(1));
//         }
//         return sorted;
//     }
    
//     public int minCostConnectPoints(int[][] points) {
        
//         int n = points.length;
//         UnionFind uf = new UnionFind(n);
//         Map<Integer,ArrayList<Integer>> distbwpoints = new HashMap<>();
        
//         for(int i=0;i<n;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {
//                 int dist = manhattanDist(points[i][0],points[i][1],points[j][0],points[j][1]);
//                 distbwpoints.put(dist,new ArrayList<Integer>(Arrays.asList(i,j)));
//             }
//         }
//         Map<Integer,ArrayList<Integer>> pointsSorted = sortByKey(distbwpoints);
        
//         int mstCost = 0;
//         int edgesUsed = 0;
        
//         for(Map.Entry<Integer,ArrayList<Integer>> entry: pointsSorted.entrySet())
//         {
//             if(!uf.connected(entry.getValue().get(0),entry.getValue().get(1)))
//             {
//                 uf.union(entry.getValue().get(0),entry.getValue().get(1));
//                 mstCost += entry.getKey();
//                 edgesUsed += 1;
//             } 
//         }
//         return mstCost;
//     }
// }


//THIS IS CORRECT SOLUTION USING KRUSKALS ALGORITHM 
// class UnionFind
// {
//     int[] root;
//     int[] rank;
    
//     public UnionFind(int length)
//     {
//         root = new int[length];
//         rank = new int[length];
        
//         for(int i=0;i<length;i++)
//         {
//             root[i] = i;
//             rank[i] = 1;
//         }
//     }
    
//     int find(int node)
//     {
//         if(root[node] == node)
//             return node;
        
//         return root[node] = find(root[node]);
//     }
    
//     void union(int x, int y)
//     {
//         int rootX = find(x);
//         int rootY = find(y);
            
//         if(rootX == rootY)
//             return;
//         else
//         {
//             if(rank[rootX] > rank[rootY])
//                 root[rootY] = rootX;
//             else if(rank[rootX] < rank[rootY])
//                 root[rootX] = rootY;   
//             else if(rank[rootX] == rank[rootY])
//             {
//                 root[rootY] = rootX;
//                 rank[rootX]+=1;
//             }
//         }
//     }
    
//     boolean connected(int x, int y)
//     {
//         return find(x) == find(y);
//     }
// }

// class Solution {
    
//     public int minCostConnectPoints(int[][] points) { 
        
//         int n = points.length;
//         UnionFind uf = new UnionFind(n);
//         ArrayList<int[]> allEdges = new ArrayList<>();
        
//         for(int i=0;i<n;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {
//                 int dist = manhattanDist(points[i][0],points[i][1],points[j][0],points[j][1]);
//                 int[] currEdge = {dist,i,j};
//                 allEdges.add(currEdge);
//             }
//         }
        
//         Collections.sort(allEdges, (a,b)->Integer.compare(a[0],b[0]));
        
//         // for(int i = 0; i < allEdges.size(); i++)
//         // {
//         //     System.out.println("Dist = "+allEdges.get(i)[0]+", points = "+allEdges.get(i)[1]+" , "+allEdges.get(i)[2]);
//         // }
        
//         int mstCost = 0;
//         int edgesUsed = 0;
        
//         for(int i = 0; i < allEdges.size() && edgesUsed < n-1; i++)
//         {
//             int node1 = allEdges.get(i)[1];
//             int node2 = allEdges.get(i)[2];
            
//             if(!uf.connected(node1,node2))
//             {
//                 uf.union(node1,node2);
//                 mstCost+=allEdges.get(i)[0];
//                 edgesUsed+=1;
//             }
//         }
//         return mstCost;        
//     }
    
//     public int manhattanDist(int x1, int y1, int x2, int y2)
//     {
//         return Math.abs(x2-x1)+Math.abs(y2-y1);
//     }
// }

