//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair {
  int first, second;
  Pair(int _first, int _second) {
    this.first = _first;
    this.second = _second;
  }
}

class Solution {

	private void dfs(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
		vis[node] = 1;
		for(int i=0;i<adj.get(node).size();i++){
			int v = adj.get(node).get(i).first;
			if(vis[v]!=1){
				dfs(v,adj,vis,st);
			}
		}
		st.push(node);
	}

    //This is the function to implement Topological sort.
	private Stack<Integer> topoSort(int N, int M, ArrayList<ArrayList<Pair>> adj){
		
		int[] vis = new int[N];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<N;i++){
			if(vis[i]!=1){
				dfs(i,adj,vis,st);
			}
		}
		return st;
	}

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here

		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

		for(int i=0;i<N;i++){
			adj.add(new ArrayList<Pair>());
		}

        //We create a graph first in the form of an adjacency list.
		for(int i=0;i<M;i++){
			adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}

        //Now, we perform topo sort using DFS technique 
        //and store the result in the stack st.
		Stack<Integer> topoStack = topoSort(N,M,adj);
		
		
		//Further, we declare a vector ‘dist’ in which we update the value of the nodes’
       //distance from the source vertex after relaxation of a particular node.
		int[] dist = new int[N];
		Arrays.fill(dist,(int)(1e9));
		
		dist[0] = 0;
		while(!topoStack.isEmpty()){
			int temp = topoStack.peek();
			topoStack.pop();
	
			for(int i=0;i<adj.get(temp).size();i++){
				int v = adj.get(temp).get(i).first;
				int weig = adj.get(temp).get(i).second;
				if(dist[temp]+weig < dist[v]){
					dist[v] = dist[temp]+weig; 
				}
			}
		}

		for(int i=0;i<N;i++){
			if(dist[i]==1e9){
				dist[i] = -1;
			}
		}
		return dist;
	}
}


// class Solution {
// 	private void dfs(int node, ArrayList<ArrayList<Map.Entry<Integer,Integer>>> adj, int[] vis, Stack<Integer> st){
// 		vis[node] = 1;
// 		for(int i=0;i<adj.get(node).size();i++){
// 			int v = adj.get(node).get(i).getKey();
// 			if(vis[v]!=1){
// 				dfs(v,adj,vis,st);
// 			}
// 		}
// 		st.push(node);
// 	}

// 	private Stack<Integer> topoSort(int N, int M, ArrayList<ArrayList<Map.Entry<Integer,Integer>>> adj){
		
// 		int[] vis = new int[N];
// 		Stack<Integer> st = new Stack<>();
		
// 		for(int i=0;i<N;i++){
// 			if(vis[i]!=1){
// 				dfs(i,adj,vis,st);
// 			}
// 		}
// 		return st;
// 	}

// 	public int[] shortestPath(int N,int M, int[][] edges) {
// 		//Code here

// 		ArrayList<ArrayList<Map.Entry<Integer,Integer>>> adj = new ArrayList<>();

// 		for(int i=0;i<N;i++){
// 			adj.add(new ArrayList<Map.Entry<Integer,Integer>>());
// 		}

// 		for(int i=0;i<M;i++){
// 			adj.get(edges[i][0]).add(new AbstractMap.SimpleEntry<>(edges[i][1],edges[i][2]));
// 		}

// 		Stack<Integer> topoStack = topoSort(N,M,adj);
		
// 		int[] dist = new int[N];
// 		Arrays.fill(dist,(int)(1e9));
		
// 		dist[0] = 0;
// 		while(!topoStack.isEmpty()){
// 			int temp = topoStack.peek();
// 			topoStack.pop();
	
// 			for(int i=0;i<adj.get(temp).size();i++){
// 				int v = adj.get(temp).get(i).getKey();
// 				int weig = adj.get(temp).get(i).getValue();
// 				if(dist[temp]+weig < dist[v]){
// 					dist[v] = dist[temp]+weig; 
// 				}
// 			}
// 		}

// 		for(int i=0;i<N;i++){
// 			if(dist[i]==1e9){
// 				dist[i] = -1;
// 			}
// 		}
// 		return dist;
// 	}
// }

