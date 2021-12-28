class Solution {
public:
    bool isPalindrome(string s) {
        vector<char> str;
        for(int i=0;i<s.size();i++)
        {
            if((s[i]>='a' && s[i]<='z')||(s[i]>='0' && s[i]<='9'))
            {
                str.push_back(s[i]);
            }
            else if(s[i]>='A' && s[i]<='Z')
            {
                str.push_back(s[i]+32);
            }
        }
        // reverse(str.begin(),str.end());
        for(int i=0;i<str.size();i++)
        {
            if(str[i]!=str[((str.size()-1)-i)])
                return false;
        }
        return true;
    }
};