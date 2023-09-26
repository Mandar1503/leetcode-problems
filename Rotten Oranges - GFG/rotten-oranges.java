//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int tm;
    public Pair(int row, int col, int tm)
    {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int cntrFresh = 0;
        int cntr = 0;
        int maxtm = 0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else
                {
                    vis[i][j] = 0;
                }
                
                if(grid[i][j]==1)
                    cntrFresh++;
            }
        }
        
        int[] delrow = {1,0,-1,0};
        int[] delcol = {0,1,0,-1};
        
        while(!q.isEmpty())
        {
            int x = q.peek().row;
            int y = q.peek().col;
            int ctm = q.peek().tm;
            q.remove();
            maxtm = Math.max(maxtm,ctm);
            
            for(int i=0;i<4;i++)
            {
                int nx = x + delrow[i];
                int ny = y + delcol[i];
            
                if(nx<n && nx>=0 && ny<m && ny>=0 && grid[nx][ny]==1 && vis[nx][ny]==0)
                {
                    vis[nx][ny] = 2;
                    q.add(new Pair(nx,ny,ctm+1));
                    cntr++;
                }
            }
        }
        
        return (cntrFresh-cntr)==0?maxtm:-1;
    }
}