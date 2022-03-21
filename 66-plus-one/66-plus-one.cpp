//MY SOLUTION 
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int carry = 0;
        int incr = 1;
        vector<int> answer;
        for(int i=digits.size()-1;i>=0;i--) //loop from end
        {
            int d = digits[i]+incr+carry;   //add carry and incr
            incr=0;                 //if successfully added then set incr=0 
            int ans = d%10;         //get the units place digit
            answer.push_back(ans);  //and add it to result
            carry = d/10;           //and get the carry out of sum
        }   
        if(carry==1)            //if carry is still 1 then add it to the end of the ans
            answer.push_back(carry);
        reverse(answer.begin(),answer.end());   //reverse the ans
        return answer;
    }
};

//THEIR SOLUTION (MORE EFFECTIVE) (INPLACE)
// class Solution {
// public:
//     vector<int> plusOne(vector<int>& digits) {
//         for(int i=digits.size()-1;i>=0;i--)  
//         {
//             if(digits[i]==9)     //if digit is 9 then that digit should become 0
//             {
//                 digits[i]=0;
//             }
//             else             //if any other digit then simply +1
//             {
//                 digits[i]++;
//                 return digits;       // add return coz we incremented it by 1
//             }
//         }
//         // digits.push_back(1);
//         digits.insert(digits.begin(),1); //we came here since there are all 9 in the vector
//         return digits;                   //then return 
//     }
// };