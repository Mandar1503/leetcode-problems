//Another solution(GOOD)
class Solution {
public:
    bool isAnagram(string s, string t) {
        
        if(s.size()!=t.size())
            return false;
        
        int counter[26] = {0};
        
        for(int i=0;i<s.size();i++)
        {
            counter[s[i]-'a']++;
            counter[t[i]-'a']--;
        }
        
        for(int i=0;i<26;i++)
        {
            if(counter[i]!=0)
                return false;
        }
       return true;
    }
};

//Brute force (BETTER SOLUTION)
// class Solution {
// public:
//     bool isAnagram(string s, string t) {
//         map<char,int> characters;
        
//         if(s.size()!=t.size())
//             return false;
        
//         for(char ch : s)
//         {
//             if(characters.find(ch)!=characters.end())
//                 characters[ch]++;
//             else
//                 characters.insert(pair<char,int>(ch,1));
//         }
        
//         for(char ch : t)
//         {
//             if(characters.find(ch)!=characters.end() && characters[ch]!=0)
//                 characters[ch]--;        
//             else
//                 return false;
//         }
//         return true;
//     }
// };
