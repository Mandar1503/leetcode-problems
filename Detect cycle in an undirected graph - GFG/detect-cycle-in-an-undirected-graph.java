//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

//USING BFS
// class Pair{
//     int node;
//     int parent;
//     public Pair(int node, int parent)
//     {
//         this.node=node;
//         this.parent = parent;
//     }
// }

// class Solution {
//     private boolean checkForCycle(int src, int[] vis, ArrayList<ArrayList<Integer>> adj, int V)
//     {
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(src,-1));
        
//         while(!q.isEmpty())
//         {
//             int node = q.peek().node;
//             int parent = q.peek().parent;
//             q.remove();
//             vis[node] = 1;
            
//             for(int it:adj.get(node))
//             {
//                 if(vis[it]!=1)
//                 {
//                     q.add(new Pair(it,node));
//                 }
//                 else if(it!=parent)
//                 {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
    
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         // Code here
//         int[] vis = new int[V];
//         for(int i=0;i<V;i++) vis[i] = 0;
//         for(int i=0;i<V;i++)
//         {
//             if(vis[i]==0)
//                 if(checkForCycle(i,vis,adj,V))
//                     return true;
//         }
//         return false;
//     }
// }

class Solution {
    
    private boolean dfs(int node, int parent,int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(int it:adj.get(node))
        {
            if(vis[it]!=1)
            {
                if(dfs(it,node,vis,adj))
                    return true;
            }
            else if(it!=parent)
            {
                return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]!=1)
            {
                if(dfs(i,-1,vis,adj))
                    return true;
            }
        }
        return false;
    }
}