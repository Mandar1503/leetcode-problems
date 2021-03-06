//MY SOLUTION
class KthLargest {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for(int num:nums)
        {
            // pq.add(num);
            // if(pq.size()>k)
            //     pq.poll();
            this.add(num);
        }
    }
    
    public int add(int val) {
        
        pq.add(val);
        if(pq.size()>k)
            pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */