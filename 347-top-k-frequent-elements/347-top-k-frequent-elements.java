class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue<Pair<Integer,Integer>> minheap = new PriorityQueue<>((n1,n2)->n1.getValue()-n2.getValue());
        
        
        for(Map.Entry<Integer,Integer> mp:freq.entrySet())
        {
            Pair<Integer,Integer> p = new Pair(mp.getKey(),mp.getValue());
            minheap.add(p);
            if(minheap.size()>k)
                minheap.poll();
        }
        
        
        int result[] = new int[k];
        int i=0;
        
        for(Pair<Integer,Integer> e:minheap)
        {
            result[i] = e.getKey();
            i++;
        }
        //Also can use this loop instead
        // while(minheap.size()>0)
        // {
        //     result[i] = minheap.poll().getKey();
        //     i++;
        // }
        return result;
    }
}