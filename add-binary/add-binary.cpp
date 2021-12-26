class Solution {
public:
    string addBinary(string a, string b) {
        
        if(a.size()<b.size())
            addBinary(b,a);
        
        reverse(a.begin(),a.end());
        reverse(b.begin(),b.end());
        
        int carry = 0;
        vector<char> answer;
        for(int i=0;i<a.size() || i<b.size();i++)
        {
            int no1 = (i>a.size()-1)?0:a[i]-'0';
            int no2 = (i>b.size()-1)?0:b[i]-'0';
            
            int sum = no1 + no2 + carry;
            carry = sum/2;
            sum = sum%2;
            answer.push_back(sum+'0');
        }
        if(carry==1)
            answer.push_back(1+'0');
        string ans;
        for(int i=0;i<answer.size();i++)
        {
            ans=ans+(answer[i]);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};