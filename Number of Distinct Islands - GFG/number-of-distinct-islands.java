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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    private void dfs(int x, int y, int[][] vis, int[][] grid, ArrayList<String> vec, int x0, int y0)
    {
        vis[x][y] = 1;
        vec.add(toString(x-x0,y-y0));
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[] delrow = {1 , 0, -1, 0};
        int[] delcol = {0 , 1, 0, -1};
        
        for(int i=0;i<4;i++)
        {
            int nx = x + delrow[i];
            int ny = y + delcol[i];
            
            if(nx<n && nx>=0 && ny<m && ny>=0 && vis[nx][ny]!=1 && grid[nx][ny]==1)
            {
                dfs(nx,ny,vis,grid,vec,x0,y0);
            }
        }
    }
    
    private String toString(int r, int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }


    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]!=1 && grid[i][j]==1)
                {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i,j,vis,grid,vec,i,j);
                    st.add(vec);
                }
            }
        }
        
        return st.size();
    }
}
