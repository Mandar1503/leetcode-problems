//Binary search
class Solution {
public:
    int mySqrt(int x) {
        
        if(x<2)         //if anything below 2 then return itself(ie. 0 & 1)
            return x;
        
        int low = 2;    
        int high = x/2; 
        int mid;
        
        while(low<=high)
        {
            mid = low+(high-low)/2;  //use this instead of this (low+high)/2, to avoid overflow since low+high > high which can lead to overflow
            long no = (long) mid*mid; //since for some test case it overflows the signed integer
            
            if(no>x)
                high = mid-1;
            else if(no<x)
                low=mid+1;
            else if(no==x)
                return mid;
        }
        return high; //return high since we want to return lower b/w low & high and as after the loop the high<low thus return high
    }
};

//SEE OTHER SOLNS IN THE SOLUTIONS 
//  1. Formula for calc left (pocket calculator algo) = e^((1/2)*log(x))  //Best in terms of complexity
//  2. Formula for calc left (recursion + bit shifts) = mysqrt(x>>2)<<1 ie.( x>>y === x/(2^y) && x<<y === x*(2^y)  