class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int carry = 0;
        int incr = 1;
        vector<int> answer;
        for(int i=digits.size()-1;i>=0;i--)
        {
            int d = digits[i]+incr+carry;
            incr=0;
            int ans = d%10;
            answer.push_back(ans);
            carry = d/10;
        }
        if(carry==1)
            answer.push_back(carry);
        reverse(answer.begin(),answer.end());
        return answer;
    }
};