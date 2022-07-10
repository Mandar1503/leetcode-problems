//BFS
class Solution{
	public List<List<Integer>> allPathsSourceTarget(int[][] graph)
	{
		List<List<Integer>> solution = new ArrayList<>(); //create a new array to store the solution
		Queue<List<Integer>> q = new LinkedList<>();	//create a queue to implement DFS
		List<Integer> path = new ArrayList<>();		//create a path to store path traversed until now 
		path.add(0);						//add the start node to the current path
		q.add(path);						//add that currpath to queue

		while(!q.isEmpty())					//loop
		{
			List<Integer> currentPath = q.poll();	//pop a path from the queue
			int currNode = currentPath.get(currentPath.size()-1);	//get the last element from the path
			
			for(int neighbour:graph[currNode])				//iterate neighbours
			{
                List<Integer> temp = new ArrayList<>(currentPath);	//make a temporary list to store the currpath
				temp.add(neighbour);					//add the new neighbour to the temp array(which is copy of currpath)
				if(neighbour==graph.length-1)				//if this neighbour is destination the we got a path so add it to the solutions list
					solution.add(temp);
				else
					q.add(temp);					//O/W add this temp path to the queue for later
			}	
		}

		return solution;							//return solution list
	}
}


// DFS RECURSIVE/ BACKTRACKING
// class Solution{
// 	public List<List<Integer>> allPathsSourceTarget(int[][] graph)		
// 	{
// 		List<List<Integer>> solution = new ArrayList<>();		//list to store solutions

// 		if(graph == null || graph.length == 0)
// 			return solution;

// 		dfs(graph,0,new ArrayList<Integer>(),solution);			//call the recursive/helper function dfs on the start node
// 		return solution;
// 	}

// 	public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths)
// 	{
// 		path.add(node);					//add the new neighbour/start node to the path
// 		if(node == graph.length-1)			//if the node is destination then add the path to the solutions/paths and return back
// 		{
// 			paths.add(new ArrayList<>(path));
// 			return;
// 		}
// 		for(int neighbour:graph[node])		//O/W iterate through the neighbours and call recursively dfs on them
// 		{
// 			dfs(graph,neighbour,path,paths);
// 			path.remove(path.size()-1);		//after iterating throughout a path to check other paths from previous node we have to remove the latest node
// 		}	
// 	}
// }