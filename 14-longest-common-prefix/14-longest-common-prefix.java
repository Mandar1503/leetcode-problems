//horizontal scanning
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) 
            return "";
        
        String p = strs[0];     //take one string
        
        for(int i=1;i<strs.length;i++) //iterate through next string
        {
            while(strs[i].indexOf(p)!=0) //if it is not a substring then 
            {
                p = p.substring(0,p.length()-1);//reduce length of the substring
                
                if(p.isEmpty()) //if the string becomes empty then return ""
                    return "";
            }
        }
        return p;
    }
}