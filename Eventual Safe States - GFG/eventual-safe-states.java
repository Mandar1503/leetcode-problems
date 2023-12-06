//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for    Java

// class Solution {

//     List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

//         // Your code here
//         int[] vis = new int[V];
//         int[] pathVis = new int[V];
//         int[] check = new int[V];
//         List<Integer> safeNodes = new ArrayList<>();
        
//         for(int i=0;i<V;i++){
//             if(vis[i]!=1)
//                 dfs(i,adj,vis,pathVis,check);
//         }
        
//         for(int i=0;i<V;i++){
//             if(check[i]==1)
//                 safeNodes.add(i);    
//         }
//         return safeNodes;
//     }
    
//     private boolean dfs(int start, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check)
//     {
//         vis[start] = 1;
//         pathVis[start] = 1;
//         check[start] = 0;
        
//         for(int it:adj.get(start))
//         {
//             if(vis[it]!=1){
//                 if(dfs(it,adj,vis,pathVis,check)==true){
//                     return true;
//                 }
//             }
//             else if(pathVis[it]==1){
//                 return true;
//             }
//         }
//         check[start] = 1;
//         pathVis[start] = 0;
//         return false;
//     }
// }




class Solution{
	List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj){
		
		List<List<Integer>> revAdj = new ArrayList<>();
		int[] indegree = new int[V];
		
		for(int i=0;i<V;i++)
		    indegree[i] = 0;
		
		for(int i=0;i<V;i++)
		    revAdj.add(new ArrayList<>());
		    
		for(int i=0;i<V;i++){
			for(int it:adj.get(i)){
				revAdj.get(it).add(i); 
				indegree[i]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<V;i++)
			if(indegree[i]==0)
				q.add(i);
		
		List<Integer> sorted = new ArrayList<>();
		while(!q.isEmpty()){
			int node = q.peek();
			q.remove();
			sorted.add(node);
			for(int it:revAdj.get(node)){
				indegree[it]--;
				if(indegree[it]==0){
			        q.add(it);	
			    }
			}
		}
		Collections.sort(sorted);
		return sorted;		
		
	}
}