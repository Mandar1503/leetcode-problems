//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

	private static void dfs(int x, ArrayList<ArrayList<Integer>> adjList, int[] vis, int V)
	{
		vis[x] = 1;
		for(Integer it:adjList.get(x))
		{
			if(vis[it]!=1)
			{
				dfs(it,adjList,vis,V);
			}	
		}
	}

	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        	// code here

		int[] vis = new int[V];
		int count = 0;
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
			
		for(int i=0;i<V;i++)
		{
			adjList.add(new ArrayList<Integer>());
		}	
		
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
			    if(adj.get(i).get(j)==1 && i!=j)
			    {
				    adjList.get(i).add(j);
				    adjList.get(j).add(i);
			    }
			}
		}
		
		for(int i=0;i<V;i++)
		{
			if(vis[i]!=1)
			{
				count++;
				dfs(i,adjList,vis,V);
			}
		}
		return count;
    	}
};