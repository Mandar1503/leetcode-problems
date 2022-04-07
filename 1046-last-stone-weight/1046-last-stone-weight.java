class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<stones.length;i++)
        {
            pq.add(stones[i]);
        }
        
        while(pq.size()>1)
        {
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            if(s1!=s2)
            {
                pq.add(s1-s2);
            }
        }
        if(pq.isEmpty())
            return 0;
        else
            return pq.poll();
    }
}