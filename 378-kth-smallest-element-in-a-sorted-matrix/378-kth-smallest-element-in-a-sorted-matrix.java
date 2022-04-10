// //MY SOLUTION
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int j=0;j<matrix[i].length;j++)
//             {
//                 maxheap.add(matrix[i][j]);
//                 if(maxheap.size()>k)
//                     maxheap.poll();
//             }
//         }
//         return maxheap.peek();
//     }
// }

class MyHeapNode{
    int row;
    int col;
    int val;
    
    public MyHeapNode(int val, int row, int col){
        this.val = val;
        this.col = col;
        this.row = row;
    }
    
    int getValue()
    {
        return this.val;
        
    }
    
    int getRow()
    {
        return this.row;
    }
    
    int getCol()
    {
        return this.col;
    }
}

class MyComparator implements Comparator<MyHeapNode>{
    public int compare(MyHeapNode x, MyHeapNode y)
    {
        return x.getValue()-y.getValue();
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int N = matrix.length;
        
        PriorityQueue<MyHeapNode> minheap = new PriorityQueue<MyHeapNode>(Math.min(N,k),new MyComparator());
        
        for(int i=0;i<Math.min(N,k);i++)  //works even if don't write min()
        {
            minheap.add(new MyHeapNode(matrix[i][0],i,0));
        }
        
        MyHeapNode ele = minheap.peek();
        
        while(k>0)
        {
            ele = minheap.poll();
            int r = ele.getRow();
            int c = ele.getCol();
            if(c < N-1)
            {
                minheap.add(new MyHeapNode(matrix[r][c+1],r,c+1));
            }
            k--;
        }
        
        return ele.getValue();
    }
}