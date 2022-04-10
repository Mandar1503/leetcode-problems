class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair<Integer,Integer>> maxh =  new PriorityQueue<>((a,b)->b.getKey()-a.getKey());
        
        for(int i=0;i<points.length;i++)
        {
            Pair<Integer,Integer> entry = new Pair<>(squaredDist(points[i]),i);
            maxh.add(entry);
            if(maxh.size()>k)
                maxh.poll();  
        }
        
        int result[][] = new int[k][2];
        int i=0;
        while(maxh.size()>0)
        {
            int l = maxh.poll().getValue();
            result[i][0] = points[l][0];
            result[i][1] = points[l][1];
            i++;
        }
        return result;
    }
    
    private int squaredDist(int[] point)
    {
        return point[0]*point[0]+point[1]*point[1];
    }
}