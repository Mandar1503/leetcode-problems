//Using Two pointer method
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
       
        if(nums.size()==0)              //if the nums is 0 return 0
           return 0;
        
        int i=1;                        //index to keep track of the curr unique element
        for(int j=1;j<nums.size();j++)  //start j from 1 
        {
            if(nums[j]!=nums[j-1])      //compare the current j and prev j pos element
            {
                nums[i]=nums[j];        // if they are not same ie they are unique then place it at pos i and i++
                i++;
            }
        }
        return i;                       //basically after j iterates all elements the position of i will be one place ahead of the last unique element, but since we are iterating from 0 we return the current i value
    }
};