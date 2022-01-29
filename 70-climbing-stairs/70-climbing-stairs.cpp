
//IMPO = we are considering each recursive approach for each of the step i.e check with 1 step and check with 2 step at each position. And after you reach a terminal condition you check whether the the steps taken are equal to the steps we want if yes return 1(since it is one way to reach the top) if no ie. we go beyond the top step then we return 0(since it is not a method to reach at the exact top).


//Time limit exceeded 
// class Solution {
// public:
//     int climbStairs(int n) {
//         return climb_stairs(0,n);
//     }
    
//     int climb_stairs(int i, int n)
//     {
//         if(i>n)
//             return 0;
        
//         if(i==n)
//             return 1;
        
//         return climb_stairs(i+1,n) + climb_stairs(i+2,n);
//     }
// };

//LOOK SOLN FOR MORE EFFICIENT CODES LIKE DP


//Soln using memoization
class Solution {
public:
    int climbStairs(int n) {
        int* memo = new int[n+1];
        return climb_stairs(0,n,memo);
    }
    
    int climb_stairs(int i, int n, int memo[])
    {
        if(i>n)
            return 0;
        
        if(i==n)
            return 1;
        
        if(memo[i]>0)
            return memo[i];
        
        memo[i] = climb_stairs(i+1,n,memo) + climb_stairs(i+2,n,memo);
        return memo[i];
    }
};
