class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        
        //if zero buildings
        if(n == 0)
            return output;
        
        //if only one building
        if(n == 1)
        {
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int y = buildings[0][2];
            
            output.add(new ArrayList<Integer>(){{add(xStart);add(y); }});
            output.add(new ArrayList<Integer>(){{add(xEnd);add(0); }});
            return output;
        }
        
        //if more buildings
        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n/2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n/2, n));
        
        return mergeSkylines(leftSkyline,rightSkyline);
    }
    
    
    public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right)
    {
        int nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        
        //while we are in the region where both the skylines are present
        while((pL < nL) && (pR < nR))
        {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            
            //check the x values of both the points
            if(pointL.get(0) < pointR.get(0))
            {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            }
            else
            {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            
            //update the max height b/w both skylines
            maxY = Math.max(leftY, rightY);
            
            //update the o/p if there is a skyline change
            if(currY != maxY)
            {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }
            
        //there is only left skyline
        appendSkyline(output, left, pL, nL, currY);
            
        //there is only right skyline
        appendSkyline(output, right, pR, nR, currY);
            
        return output;
    }
    
    //update the final output with new element
    public void updateOutput(List<List<Integer>> output, int x, int y)
    {
        //if the change in the skyline is not vertical - then add the new point
        if(output.isEmpty() || output.get(output.size()-1).get(0)!=x)
        {
            output.add(new ArrayList<Integer>() {{add(x); add(y); }});   
        }
        else//if the change in the skyline is vertical - update the last point
        {
            output.get(output.size()-1).set(1,y);   
        }
    }
    
    
    //append the rest of the skyline elements
    public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline, int p, int n, int currY)
    {
        while(p < n)
        {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;
            
            //update the o/p if there is a skyline change
            if(currY!=y)
            {
                updateOutput(output, x, y);
                currY = y;   
            }
        }
    }
}