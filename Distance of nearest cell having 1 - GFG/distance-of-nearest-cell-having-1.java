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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

//{ Driver Code Starts
// import java.util.*;
// import java.lang.*;
// import java.io.*;
// class GFG
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine().trim());
//         while(T-->0)
//         {
//             String[] s = br.readLine().trim().split(" ");
//             int n = Integer.parseInt(s[0]);
//             int m = Integer.parseInt(s[1]);
//             int[][] grid = new int[n][m];
//             for(int i = 0; i < n; i++){
//                 String[] S = br.readLine().trim().split(" ");
//                 for(int j = 0; j < m; j++){
//                     grid[i][j] = Integer.parseInt(S[j]);
//                 }
//             }
//             Solution obj = new Solution();
//             int[][] ans = obj.nearest(grid);
//             for(int i = 0; i < ans.length; i++){
//                 for(int j = 0; j < ans[i].length; j++){
//                     System.out.print(ans[i][j] + " ");
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }
// // } Driver Code Ends

// class Node{
//     int x;
//     int y;
//     int lvl;
    
//     public Node(int x, int y, int lvl)
//     {
//         this.x= x;
//         this.y = y;
//         this.lvl = lvl;
//     }
// }

// class Solution
// {
//     //Function to find distance of nearest 1 in the grid for each cell.
//     public int[][] nearest(int[][] grid)
//     {
//         int r = grid.length;
//         int c = grid[0].length;
//         int[][] vis = new int[r][c];
//         int[][] dist = new int[r][c];
        
//         Queue<Node> q = new LinkedList<Node>();
        
//         for(int i=0;i<r;i++)
//         {
//             for(int j=0;j<c;j++)
//             {
//                 if(grid[i][j]==1)
//                 {
//                     q.add(new Node(i,j,0));
//                     vis[i][j] = 1;
//                     // dist[i][j] = 0;
//                 }
//                 else
//                 {
//                     vis[i][j] = 0;
//                     // dist[i][j] = Integer.MAX_VALUE;
//                 }
//             }
//         }
        
//         int[] nrow = {1, 0, -1, 0};
//         int[] ncol = {0, 1, 0, -1};
        
//         while(!q.isEmpty())
//         {
//             int nx = q.peek().x;
//             int ny = q.peek().y;
//             int nlvl = q.peek().lvl;
//             q.remove();
//             // vis[nx][ny] = 1;
//             dist[nx][ny] = nlvl;
            
//             for(int i=0;i<4;i++)
//             {
//                 int tx = nx+nrow[i];
//                 int ty = ny+ncol[i];
//                 if(tx<r && tx>=0 && ty<c && ty>=0 && vis[tx][ty]==0)
//                 {
//                     vis[tx][ty] = 1;
//                     dist[tx][ty] = nlvl+1;
//                     q.add(new Node(tx,ty,nlvl+1));
//                 }
//             }
//         }
        
//         return dist;
//     }
// }

class Pair{
    int x;
    int y;
    int cntr;
    public Pair(int x, int y, int cntr)
    {
        this.x = x;
        this.y = y;
        this.cntr = cntr;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m =grid[0].length;
        int[][] ans = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else
                {
                    vis[i][j] = 0;
                }
            }
        }
        
        int[] delrow = {1,0,-1,0};
        int[] delcol = {0,1,0,-1};
        
        while(!q.isEmpty())
        {
            int ni = q.peek().x;
            int nj = q.peek().y;
            int ncntr = q.peek().cntr;
            q.remove();
            ans[ni][nj] = ncntr;
            
            for(int i=0;i<4;i++)
            {
                int nx = ni + delrow[i];
                int ny = nj + delcol[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]!=1 && grid[nx][ny]==0)
                {
                    q.add(new Pair(nx,ny,ncntr+1));
                    vis[nx][ny] = 1;
                }
            }
            
        }
        
        return ans;
    }
}