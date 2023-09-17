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
class Pair{
    int xcord;
    int ycord;
    
    public Pair(int xcord, int ycord)
    {
        this.xcord = xcord;
        this.ycord = ycord;
    }
}


//DFS SOLUTION
class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        Queue<Pair> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int[][] vis = new int[r][c];
        
        
        for(int i=0;i<r;i++)
        {
            if(vis[i][0]!=1 && grid[i][0]==1)
            {
                vis[i][0] = 1;
                // bfs(i,0,r,c,vis,grid,q);
                q.add(new Pair(i,0));
            }
            
            if(vis[i][c-1]!=1 && grid[i][c-1]==1)
            {
                vis[i][c-1] = 1;
                // bfs(i,c-1,r,c,vis,grid,q);
                q.add(new Pair(i,c-1));
            }
        }
        
        for(int j=0;j<c;j++)
        {
            if(vis[0][j]!=1 && grid[0][j]==1)
            {
                vis[0][j] = 1;
                // bfs(0,j,r,c,vis,grid,q);
                q.add(new Pair(0,j));
            }
            
            if(vis[r-1][j]!=1 && grid[r-1][j]==1)
            {
                vis[r-1][j] = 1;
                // bfs(r-1,j,r,c,vis,grid,q);
                q.add(new Pair(r-1,j));
            }
        }
        
        
        while(!q.isEmpty())
        {
            int xcrd = q.peek().xcord;
            int ycrd = q.peek().ycord;
            q.remove();
            
            int[] delrow = {1, 0, -1, 0};
            int[] delcol = {0, 1, 0, -1};
            
            for(int i=0;i<4;i++)
            {
                int nx = xcrd + delrow[i];
                int ny = ycrd + delcol[i];
                
                if(nx>=0 && nx<r && ny>=0 && ny<c && grid[nx][ny]==1 && vis[nx][ny]!=1)
                {
                    vis[nx][ny] = 1;
                    q.add(new Pair(nx,ny));
                }
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
    
}