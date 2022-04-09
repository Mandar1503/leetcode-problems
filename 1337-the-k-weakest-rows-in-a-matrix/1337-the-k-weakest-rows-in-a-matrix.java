class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>(); 
        
        for(int i=0;i<mat.length;i++)
        {
            int count = 0;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                    count++;
            }
            map.put(i,count);
        }
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>((n1,n2)->((map.get(n1)==map.get(n2))?n1-n2:map.get(n1)-map.get(n2)));
        
        for(int i=0;i<mat.length;i++)
        {
            minheap.add(i);
        }
        
        int[] result = new int[k];
        for(int i=0;i<k;i++)
        {
            result[i] = minheap.poll(); 
        }
        return result;
    }
}