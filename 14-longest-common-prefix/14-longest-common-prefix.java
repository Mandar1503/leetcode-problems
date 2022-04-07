//LOOK FOR THE DIVIDE AND CONQUER AND BINARY SEARCH

//horizontal scanning
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
        
//         if(strs.length == 0) 
//             return "";
        
//         String p = strs[0];     //take one string
        
//         for(int i=1;i<strs.length;i++) //iterate through next string
//         {
//             while(strs[i].indexOf(p)!=0) //if it is not a substring then 
//             {
//                 p = p.substring(0,p.length()-1);//reduce length of the substring
                
//                 if(p.isEmpty()) //if the string becomes empty then return ""
//                     return "";
//             }
//         }
//         return p;
//     }
// }

//vertical approach
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs==null || strs.length==0)
            return "";
        
        for(int i=0;i<strs[0].length();i++)
        {
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(i==strs[j].length() || strs[j].charAt(i)!=c)
                    return strs[0].substring(0,i);
            }
        }
        
        return strs[0];
    }
}