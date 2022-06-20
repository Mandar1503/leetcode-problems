// class UnionFind
// {
//     int[] root;
//     int[] rank;
    
//     public UnionFind(int n)
//     {
//         root = new int[n];
//         rank = new int[n];
        
//         for(int i=0;i<n;i++)
//         {
//             rank[i] = 1;
//             root[i] = i;
//         }
//     }
    
//     public int find(int x)
//     {
//         if(x == root[x])
//             return x;
        
//         return root[x] = find(root[x]);
//     }
    
//     public boolean union(int x, int y)
//     {
//         int rootX = find(x);
//         int rootY = find(y);
        
//         if(rootX==rootY)
//             return false;
        
//         if(rootX!=rootY)
//         {
//             if(rank[rootX] > rank[rootY])
//                 root[rootY] = rootX;
//             else if(rank[rootX] < rank[rootY])
//                 root[rootX] = rootY;
//             else
//             {
//                 root[rootY] = rootX;
//                 rank[rootX] += 1;
//             }
//         }
//         return true;
//     }
// }

// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         UnionFind uf = new UnionFind(n);
//         int count = n;
//         boolean flag;
//         for(int i=0;i<edges.length;i++)
//         {
//             flag = uf.union(edges[i][0],edges[i][1]);
//             if(flag)
//                 count--;
//         }
//         return count;
//     }
// }

public class Solution {

    private int find(int[] representative, int vertex) {
        if (vertex == representative[vertex]) {
            return vertex;
        }
        
        return representative[vertex] = find(representative, representative[vertex]);
    }
    
    private int combine(int[] representative, int[] size, int vertex1, int vertex2) {
        vertex1 = find(representative, vertex1);
        vertex2 = find(representative, vertex2);
        
        if (vertex1 == vertex2) {
            return 0;
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                representative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                representative[vertex1] = vertex2;
            }
            return 1;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int[] representative = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }
        
        int components = n;
        for (int i = 0; i < edges.length; i++) { 
            components -= combine(representative, size, edges[i][0], edges[i][1]);
        }

        return components;
    }
}