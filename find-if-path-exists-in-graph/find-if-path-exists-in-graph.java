class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if(edges == null)
            return false;
        
        if(source == destination)
            return true;
        
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj_list = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj_list.add(new ArrayList<>());
        
        for(int[] i : edges)
        {
            adj_list.get(i[0]).add(i[1]);
            adj_list.get(i[1]).add(i[0]);
        }
        
        boolean seen[] = new boolean[n];
        Arrays.fill(seen,false);
        seen[source] = true;
        q.add(source);
        
        while(!q.isEmpty())
        {
            int ele = q.poll();
            if(ele==destination)
                return true;
            
            for(int neighbour : adj_list.get(ele))
            {
                if(seen[neighbour]==false)
                {
                    q.add(neighbour);
                    seen[neighbour] = true;   
                }
            }
        }
        return false;
    }
}



// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         List<List<Integer>> adjlist = new ArrayList<>();
        
//         for(int i=0;i<n;i++)
//         {
//             adjlist.add(new ArrayList<>());
//         }
        
//         for(int[] edge: edges)
//         {
//             adjlist.get(edge[0]).add(edge[1]);
//             adjlist.get(edge[1]).add(edge[0]);
//         }
        
//         Deque<Integer> stack = new ArrayDeque<>();
//         stack.push(source);
//         boolean seen[] = new boolean[n];
//         Arrays.fill(seen,false);
        
//         while(!stack.isEmpty())
//         {
//             int node = stack.pop();
            
//             if(node == destination)
//                 return true;
            
//             if(seen[node])
//                 continue;
            
//             seen[node] = true;
        
//             for(int neighbor : adjlist.get(node))
//             {
//                 stack.push(neighbor);
//             }
//         }
        
//         return false;
//     }
// }
