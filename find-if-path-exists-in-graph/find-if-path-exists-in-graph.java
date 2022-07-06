//BFS SOLUTION
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //edge cases 
        if(edges == null)
            return false;
        
        if(source == destination)
            return true;
        
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj_list = new ArrayList<>();
        //create a adjacency list of all the elements and their neighbours
        for(int i=0;i<n;i++)
            adj_list.add(new ArrayList<>());
        //build the adjacency list 
        for(int[] i : edges)
        {
            adj_list.get(i[0]).add(i[1]);
            adj_list.get(i[1]).add(i[0]);
        }
        //an array of boolean values to check visited nodes
        boolean seen[] = new boolean[n];
        Arrays.fill(seen,false);
        
        //add source
        seen[source] = true;
        q.add(source);
       
        //iterate the queue until empty
        while(!q.isEmpty())
        {
            //poll and check if it is destination
            int ele = q.poll();
            if(ele==destination)
                return true;
            
            //otherwise iterate all the other corresponding neighbours of that element
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


//DFS SOLUTION
// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         List<List<Integer>> adjlist = new ArrayList<>();
//         //create an adjacency list
//         for(int i=0;i<n;i++)
//         {
//             adjlist.add(new ArrayList<>());
//         }
//         //build an adjacency list
//         for(int[] edge: edges)
//         {
//             adjlist.get(edge[0]).add(edge[1]);
//             adjlist.get(edge[1]).add(edge[0]);
//         }
        
//         //use a stack
//         Deque<Integer> stack = new ArrayDeque<>();
        
//         //push the source
//         stack.push(source);
        
//         //create a visited array
//         boolean seen[] = new boolean[n];
//         Arrays.fill(seen,false);
        
//         //iterate until stack is empty
//         while(!stack.isEmpty())
//         {
//             //pop from stack
//             int node = stack.pop();
//             //check if it is destination
//             if(node == destination)
//                 return true;
            
//             //O/w if seen continue
//             if(seen[node])
//                 continue;
//             //o/w make it true
//             seen[node] = true;
        
//             //push the neighbours in the stack
//             for(int neighbor : adjlist.get(node))
//             {
//                 stack.push(neighbor);
//             }
//         }
        
//         return false;
//     }
// }
