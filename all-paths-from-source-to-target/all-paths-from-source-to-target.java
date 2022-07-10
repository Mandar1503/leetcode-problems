class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> solution = new ArrayList<>();
        Queue<List<Integer>> q  = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); 
        q.add(path);
        
        while(!q.isEmpty())
        {
            List<Integer> p = q.poll();
            int node = p.get(p.size()-1);
            
            for(int neighbour:graph[node])
            {
                List<Integer> Temp = new ArrayList<>(p);
                Temp.add(neighbour);
                if(neighbour == graph.length-1)
                    solution.add(Temp);
                else
                    q.add(Temp);
            }
        }
        return solution;
    }
}

//BACKTRACKING SOLUTION(RECURSION, DFS)

// class Solution{

// 	public List<List<Integer>> allPathsSourceTarget(int[][] graph)
// 	{
        
// 		List<List<Integer>> paths = new ArrayList<>();
		
//         //edge cases
// 		if(graph == null || graph.length == 0)
// 		{
// 			return paths;
// 		}		
        
//         //1st recursive call
// 		dfs(graph, 0, new ArrayList<>(),paths);
//         //return all paths
// 		return paths;
// 	}

//     //recursive function
// 	public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths)
// 	{
        
// 		path.add(node);         //add the node to the path first
// 		if(node == graph.length - 1)    //if the added node is the target the we got a path
// 		{
// 			paths.add(new ArrayList<>(path));   //add the path to the soln
// 			return;                             //go back to previous call 
// 		}
		    
// 		for(int neighbour : graph[node])        //if node target then iterate through its neighbours
// 		{
// 			dfs(graph, neighbour, path, paths); //recursive call for the neighbouring node to go into depth
// 			path.remove(path.size()-1);         //once we come back to backtrack we should delete the last element from 'path' so that we can continue finding other paths with the previous node.
// 		}
// 	}
// }