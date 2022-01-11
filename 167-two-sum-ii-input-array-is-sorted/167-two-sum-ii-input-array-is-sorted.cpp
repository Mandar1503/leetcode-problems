//TWO POINTERS APPROACH
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        
        // vector<int> result;
        int low = 0;                    //set low 
        int high = numbers.size()-1;    //set high
        
        while(low<high)                 //Until low passes high loop
        {       
            int sum = numbers[low]+numbers[high];//get the sum of the elements at low and high
            
            if(sum>target)              //if sum>target we need smaller elements thus high--
                high--;
            else if(sum<target)         //if sum<target we need larger elements thus low++
                low++;
            else
            {
                // result.push_back(low+1);
                // result.push_back(high+1);
                // return result;
                return {low+1,high+1};  //if the sum==target return the positions plus 1 in a form of vector
            }
        }
        return{-1,-1};                  //if no element found then return -1,-1
    }
};