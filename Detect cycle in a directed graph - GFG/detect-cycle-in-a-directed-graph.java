//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/


//****DONE USING DFS CYCLE CHECK****

// class Solution {
    
//     private boolean dfsCheck(int start, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj)
// 	{
// 		vis[start] = 1;
// 		pathVis[start] = 1;
		
// 		for(int it:adj.get(start)){
// 			if(vis[it]!=1){
// 				if(dfsCheck(it,vis,pathVis,adj)==true){
// 					return true;
// 				}
// 			}
// 			else if(pathVis[it]==1){
// 				return true;
// 			}
// 		}
// 		pathVis[start] = 0;
// 		return false;	
// 	}
	
//     // Function to detect cycle in a directed graph.
//     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//         // code here
//         int[] vis = new int[V];
// 		int[] pathVis = new int[V];
		
// 		for(int i=0;i<V;i++)
// 		{
// 			if(vis[i]!=1){
// 				if(dfsCheck(i,vis,pathVis,adj)==true){
// 					return true;
// 				}
// 			}
// 		}
// 		return false;
//     }
// }


//***** DONE USING KAHN'S ALGO I.E. BFS(using indegree)*****

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        
        for(int i=0;i<V;i++)
            for(int it:adj.get(i)) 
                indegree[it]++;
                
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            if(indegree[i]==0)
                q.add(i);
                
        int count=0;
        while(!q.isEmpty()){
            int temp = q.peek();
            q.remove();
            count++;
            
            for(int it:adj.get(temp)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        
        if(count==V)
            return false;
        else
            return true;
    }
}