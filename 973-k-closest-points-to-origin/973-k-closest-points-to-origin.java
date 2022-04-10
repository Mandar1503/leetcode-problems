//MY SOLUTION
// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
        
//         PriorityQueue<Pair<Integer,Integer>> maxh =  new PriorityQueue<>((a,b)->b.getKey()-a.getKey());
        
//         for(int i=0;i<points.length;i++)
//         {
//             Pair<Integer,Integer> entry = new Pair<>(squaredDist(points[i]),i);
//             maxh.add(entry);
//             if(maxh.size()>k)
//                 maxh.poll();  
//         }
        
//         int result[][] = new int[k][2];
//         int i=0;
//         while(maxh.size()>0)
//         {
//             int l = maxh.poll().getValue();
//             result[i][0] = points[l][0];
//             result[i][1] = points[l][1];
//             i++;
//         }
//         return result;
//     }
    
//     private int squaredDist(int[] point)
//     {
//         return point[0]*point[0]+point[1]*point[1];
//     }
// }




//A BIT MORE OPTIMIZED SOLUTION (look at the if..else)
// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
        
//         PriorityQueue<Pair<Integer,Integer>> maxheap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        
//         for(int i=0;i<points.length;i++)
//         {
//             int dist = squaredDist(points[i]);
//             Pair<Integer,Integer> coord = new Pair<>(i,dist);
            
//             if(maxheap.size()<k)
//             {
//                 maxheap.add(coord);
//             }
//             else if(maxheap.peek().getValue()>dist)
//             {
//                 maxheap.poll();
//                 maxheap.add(coord);
//             }
//         }
        
//         int[][] result = new int[k][2];
//         int i = 0;
//         while(maxheap.size()>0)
//         {
//             int l = maxheap.poll().getKey();
//             result[i][0] = points[l][0];
//             result[i][1] = points[l][1];
//             i++;
//         }
        
//         return result;
//     }
    
//     private int squaredDist(int[] point)
//     {
//         return point[0]*point[0] + point[1]*point[1];
//     }
// }



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b)->squaredDist(a)-squaredDist(b));
        
        return Arrays.copyOf(points,k);
    }
    
    private int squaredDist(int[] point)
    {
        return point[0]*point[0]+point[1]*point[1];
    }
}