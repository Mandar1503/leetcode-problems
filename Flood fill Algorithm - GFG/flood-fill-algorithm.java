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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//DFS Solution: WORKS! WRITTEN BY ME
class Solution
{
    private void dfs(int r, int c, int[][] vis, int[][] image, int oldColor, int newColor)
    {
        int n = image.length;
        int m = image[0].length;
        int[] delrow = {1,0,-1,0};
        int[] delcol = {0,1,0,-1};
        
        // 		vis[r][c] = 1;  
        // 		image[r][c] = newColor; // this also works instead of writing this 2 times: 1st in the
        //                              //flood fill function and 2nd inthe  if-cond under
        //                              // the for-loop in the dfs function
        
        for(int i=0;i<4;i++)
        {
            int nr = r + delrow[i];
            int nc = c + delcol[i];
                
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=1 && image[nr][nc]==oldColor)
            {
                image[nr][nc] = newColor;
                vis[nr][nc] = 1;
                dfs(nr,nc,vis,image,oldColor,newColor);
            }
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc,int newColor)
    {
        // Code here 
        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        vis[sr][sc] = 1;
        dfs(sr,sc,vis,image,oldColor,newColor);
        return image;
    }
}


//BFS CODE : ERROR - TIME LIMIT EXCEEDED
// class Pair{
//     int r;
//     int c;
//     public Pair(int r, int c)
//     {
//         this.r = r;
//         this.c = c;
//     }
// }

// class Solution
// {
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
//     {
//         // Code here 
//         int n = image.length;
//         int m = image[0].length;
//         Queue<Pair> q = new LinkedList<>();
//         int[][] vis = new int[n][m];
        
//         int oldColor = image[sr][sc];
//         if (oldColor == newColor) {   //VERY IMPORTANT VALIDATION - IF NOTE WRITTEN THEN IT LEADS TO "TIME LIMIT EXCEEDED"
//             return image; // No need to flood fill if new and old colors are the same.
//         }
        
//         q.add(new Pair(sr,sc));
//         image[sr][sc] = newColor;
        
//         while(!q.isEmpty())
//         {
//             int x = q.peek().r;
//             int y = q.peek().c;
//             q.remove();
            
//             int[] delrow = {1,0,-1,0};
//             int[] delcol = {0,1,0,-1};
            
//             for(int i=0;i<4;i++)
//             {
//                 int nx = x + delrow[i];
//                 int ny = y + delcol[i];
                
//                 if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]!=1 && image[nx][ny]==oldColor)
//                 {
//                     image[nx][ny] = newColor;
//                     q.add(new Pair(nx,ny));
//                 }
//             }
//         }
//         return image;
//     }
// }
