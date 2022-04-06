class Solution {
public:
    bool canPermutePalindrome(string s) {
        int chr[26] = {0};
        
        for(char ch:s)
            chr[ch-'a']++;
        
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(chr[i]%2!=0)
                count++;
        }
        if(count<=1)
            return true;
        else
            return false;
    }
};