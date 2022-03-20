class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        if(strs.size() == 0)    //check if strs is empty
            return "";
        
        string prefix = strs[0];//take the 1st word in prefix
        
        for(int i=1;i<strs.size();i++)  //loop through the strs from 2nd word
        {
            while(strs[i].find(prefix)!=0)  //
                prefix = prefix.substr(0,prefix.length()-1);
            
            if(prefix.empty())  //if prefix is empty the return ""
                return "";
        }
        return prefix;
    }
};