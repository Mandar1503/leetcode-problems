//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis =  new int[n][m];
        int cntr = 0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]!=1)
                {
                    vis[i][j] = 1;
                    cntr++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return cntr;
    }
    
    private void dfs(int x, int y, int[][] vis, char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] delrow = {1,1,0,-1,-1,-1,0,1};
        int[] delcol = {0,1,1,1,0,-1,-1,-1};
        
        for(int i=0;i<8;i++)
        {
            int nx = x + delrow[i];
            int ny = y + delcol[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]=='1' && vis[nx][ny]!=1)
            {
                vis[nx][ny] = 1;
                dfs(nx,ny,vis,grid);
            }
        }
    }
}