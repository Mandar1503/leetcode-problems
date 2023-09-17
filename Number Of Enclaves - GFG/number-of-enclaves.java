//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int r = grid.length;
        int c = grid[0].length;
        int[][] vis = new int[r][c];
        
        
        for(int i=0;i<r;i++)
        {
            if(vis[i][0]!=1 && grid[i][0]==1)
            {
                vis[i][0] = 1;
                dfs(i,0,r,c,vis,grid);
            }
            
            if(vis[i][c-1]!=1 && grid[i][c-1]==1)
            {
                vis[i][c-1] = 1;
                dfs(i,c-1,r,c,vis,grid);
            }
        }
        
        for(int j=0;j<c;j++)
        {
            if(vis[0][j]!=1 && grid[0][j]==1)
            {
                vis[0][j] = 1;
                dfs(0,j,r,c,vis,grid);
            }
            
            if(vis[r-1][j]!=1 && grid[r-1][j]==1)
            {
                vis[r-1][j] = 1;
                dfs(r-1,j,r,c,vis,grid);
            }
        }
        
        int count = 0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1 && vis[i][j]!=1)
                {
                   count++; 
                }
            }
        }
        
        return count;
    }
    
    void dfs(int x, int y, int r, int c, int[][] vis, int[][] grid)
    {
        int[] delrow = {1, 0, -1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        for(int i=0;i<4;i++)
        {
            int nx = x + delrow[i];
            int ny = y + delcol[i];
            
            if(nx>=0 && nx<r && ny>=0 && ny<c && grid[nx][ny]==1 && vis[nx][ny]!=1)
            {
                vis[nx][ny]=1;
                dfs(nx,ny,r,c,vis,grid);
            }
        }
    }
    
}