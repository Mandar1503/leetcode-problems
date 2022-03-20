// class Solution {
// public:
//     string longestCommonPrefix(vector<string>& strs) {
        
//         if(strs.size() == 0)    //check if strs is empty
//             return "";
        
//         string prefix = strs[0];//take the 1st word in prefix
        
//         for(int i=1;i<strs.size();i++)  //loop through the strs from 2nd word
//         {
//             while(strs[i].find(prefix)!=0)  //
//                 prefix = prefix.substr(0,prefix.length()-1);
            
//             if(prefix.empty())  //if prefix is empty the return ""
//                 return "";
//         }
//         return prefix;
//     }
// };

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        if(strs.empty() || strs.size() == 0)    //check if the strs is empty
            return "";
        
        for(int i=0 ;i<strs[0].size();i++)      //iterate to the size of the 1st string
        {
            char c = strs[0][i];            //take a character of strs[0] in c
            for(int j=1;j<strs.size();j++)  //loop for all strings
            {
                if(i==strs[j].size()||strs[j][i]!=c)//check if any string's size is i and also if the c!= the character at ith pos
                    return strs[0].substr(0,i); //then return the string from 0 to i-1
            }
        }
        return strs[0];
    }
};