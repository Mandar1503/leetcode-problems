class Solution{

	public List<List<Integer>> allPathsSourceTarget(int[][] graph)
	{
		List<List<Integer>> paths = new ArrayList<>();
		
		if(graph == null || graph.length == 0)
		{
			return paths;
		}		

		dfs(graph, 0, new ArrayList<>(),paths);
		return paths;
	}

	public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths)
	{
		path.add(node);
		if(node == graph.length - 1)
		{
			paths.add(new ArrayList<>(path));
			return;
		}
		
		for(int neighbour : graph[node])
		{
			dfs(graph, neighbour, path, paths);
			path.remove(path.size()-1);
		}
	}
}