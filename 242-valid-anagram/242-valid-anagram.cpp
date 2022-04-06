class Solution {
public:
    bool isAnagram(string s, string t) {
        map<char,int> characters;
        if(s.size()!=t.size())
            return false;
        for(char ch : s)
        {
            if(characters.find(ch)!=characters.end())
            {
                characters[ch]++;
            }
            else
            {
                characters.insert(pair<char,int>(ch,1));
            }
        }
        for(char ch : t)
        {
            if(characters.find(ch)!=characters.end() && characters[ch]!=0)
            {
                characters[ch]--;        
            }
            else
                return false;
                  
        }
        return true;
    }
};