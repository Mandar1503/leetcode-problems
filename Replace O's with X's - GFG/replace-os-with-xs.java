//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static void dfs(int x, int y, int[][] vis, char[][] a, int[] delrow, int[] delcol)
    {
        // int[] delrow = {1, 0, -1, 0};
        // int[] delcol = {0, 1, 0, -1};
        
        vis[x][y] = 1;
        int r = a.length;
        int c = a[0].length;
        
        for(int i=0;i<4;i++)
        {
            int nrow = x + delrow[i];
            int ncol = y + delcol[i];
            
            if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && vis[nrow][ncol]==0 && a[nrow][ncol]=='O')
            {
                dfs(nrow, ncol, vis, a, delrow, delcol);
            }
        }
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int[] delrow = {1, 0, -1, 0};
        int[] delcol = {0, 1, 0, -1};
        int[][] vis = new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            if(a[i][0] == 'O' && vis[i][0]==0)
            {
                dfs(i, 0, vis, a, delrow, delcol);
            }
            
            if(a[i][m-1] == 'O' && vis[i][m-1]==0)
            {
                dfs(i, m-1, vis, a, delrow, delcol);
            }
        }
        
        for(int j=0;j<m;j++)
        {
            if(a[0][j] == 'O' && vis[0][j]==0)
            {
                dfs(0, j, vis, a, delrow, delcol);
            }
            
            if(a[n-1][j] == 'O' && vis[n-1][j]==0)
            {
                dfs(n-1, j, vis, a, delrow, delcol);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && a[i][j]=='O')
                {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
}