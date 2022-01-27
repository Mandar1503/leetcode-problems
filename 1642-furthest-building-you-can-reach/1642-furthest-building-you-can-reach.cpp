//works only for one test case
// class Solution {
// public:
//     int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
//         priority_queue<int,vector<int>,greater<int>> lheap;
        
//         for(int i=0;i<heights.size()-2;i++)
//         {
//             int climb = heights[i+1] - heights[i];
            
//             if(climb<=0)
//                 continue;
            
//             if(lheap.size()<ladders)
//             {
//                 lheap.push(climb);
//             }
//             else
//             {
//                 int sm_ladder_aloc =  lheap.top();
//                 if(sm_ladder_aloc==NULL || climb < sm_ladder_aloc)
//                 {
//                         bricks-=climb;
//                 }
//                 else
//                 {
//                     lheap.pop();
//                     lheap.push(climb);
//                     bricks-=sm_ladder_aloc;
//                 }
//                 if(bricks<0)
//                 {
//                     return i;
//                 }
//             }
//         }
//         return heights.size()-1;
            
//     }
// };

//APPROACH 1 = MIN HEAP
// class Solution {
// public:
//     int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        
//         priority_queue<int,vector<int>,greater<int>> lheap; //heap for keeping track of the ladders
        
//         for(int i=0;i<heights.size()-1;i++)                 //loop though the buildings              
//         {
//             int climb = heights[i+1]-heights[i];            //find the difference
            
//             if(climb<=0)                                    //check if climb is smaller than zero
//                 continue;
            
//             lheap.push(climb);                              //assign the ladder to every climb
            
//             if(lheap.size()<=ladders)               //after pushing check if the no of ladder is exceeded
//             {
//                 continue;                           //continue if ladders are not exceeded
//             }
            
//             int sm_ladder = lheap.top();            //if exceeded then take the smallest ladder required
//             lheap.pop();                            //pop it 
//             bricks-=sm_ladder;                      //subtract that amount of bricks
//             if(bricks<0)                            //after this bricks go -ve the jump not possible
//             {
//                 return i;                           //thus return   
//             }
//         }
//         return heights.size()-1;                    //if loop complete the all the jumps done
//     }
// };

//APPROACH 2 pseudo code representation
// class Solution {
// public:
//     int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
//         priority_queue<int> bheap;           //max heap
        
//         for(int i=0;i<heights.size()-1;i++)      
//         {
//             int climb = heights[i+1]-heights[i];
            
//             if(climb<=0)             //check if climb is <=0 if so then continue
//                 continue;
            
//             bheap.push(climb);       //push the climb into the max heap
//             bricks-=climb;           //and decrement the bricks by the climb
            
//             if(bricks>0)             //if bricks are not -ve then continue the loop
//                 continue;    
//             if(ladders==0)           //if bricks are -ve and ladders are also 0 then 
//                 return i;            //return the current building
            
//             int lg_brick = bheap.top();  //if bricks are -ve and ladders are not zero then get the largest climb previously made and assign it a ladder and again add back all bricks assign to it
//             bricks+=lg_brick;
//             ladders-=1;
//         }
//         return heights.size()-1;
//     }
// };

//APPROACH 2 SOLUTION
class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        priority_queue<int> bheap;
        
        for(int i=0;i<heights.size()-1;i++)
        {
            int climb = heights[i+1]-heights[i];
            
            if(climb<=0)        //check if climb is <=0 if so then continue
                continue;
            
            bheap.push(climb);  //push climb and decrement the no bricks used for the climb
            bricks-=climb;
            
            if(bricks<0 && ladders==0)  //if the bricks are -ve and the ladders are zero then return i
                return i;
            
            if(bricks<0)    //if the ladders are !=0 but bricks are -ve then just pop the largest previous climb and assign it a ladder instead of bricks and again add back the bricks used for that large climb.
            {
                bricks+=bheap.top();
                bheap.pop();
                ladders-=1;
            }
        }
        return heights.size()-1;
    }
};