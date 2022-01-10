
//MY Method Time=O(N), Space = O(N)(recursion stack)
class Solution {
public:
    void reverseString(vector<char>& s) {
       if(s.empty())
           return;
        char ele = s.back();
        s.pop_back();
        reverseString(s);
        s.insert(s.begin(),ele);
    }
};

//Using two pointer => Time= O(N)(total N/2 swaps), Space = O(N)(recursion stack)
// class Solution {
// public:
//     void reverseString(vector<char>& s) {
//        helper(s,0,s.size()-1);
//     }
//     void helper(vector<char>& s,int left,int right)
//     {
//         if(left>=right)
//             return;
//         char temp = s[left];
//         s[left++] = s[right];
//         s[right--] = temp;
//         helper(s,left,right);
//     }
// };

//BEST APPROACH
//Using Two Pointers but not Recursion => Time = O(N), Space = O(1)(since no extra space used done inplace)
// class Solution {
// public:
//     void reverseString(vector<char>& s) {
//         int left = 0;
//         int right = s.size()-1;
//         while(left<right)
//         {
//             char temp = s[left];
//             s[left++] = s[right];
//             s[right--] = temp;
//         }
//     }
// };

