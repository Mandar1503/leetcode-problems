class Solution {
    public String longestPalindrome(String s) {
        int reslen = 0;
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            int l = i;
            int r = i;
            // helperfunction(l,r,reslen,res,s);
            while(l >=0 && r < s.length() && s.charAt(l)==s.charAt(r))
            {
                if((r-l+1) > reslen)
                {
                    res.delete(0,s.length());
                    res.append(s.substring(l,r+1));
                    reslen = r-l+1;   
                }
                l--;
                r++;
            }
            
            l = i;
            r = i+1;
            while(l >=0 && r < s.length() && s.charAt(l)==s.charAt(r))
            {
                if((r-l+1) > reslen)
                {
                    res.delete(0,s.length());
                    res.append(s.substring(l,r+1));
                    reslen = r-l+1;   
                }
                l--;
                r++;
            }
            
            // helperfunction(l,r,reslen,res,s);
        }
        return res.toString();
    }
    
    // public void helperfunction(int l,int r, int reslen, StringBuilder res, String s)
    // {
    //     while(l >=0 && r < s.length() && s.charAt(l)==s.charAt(r))
    //     {
    //         if((r-l+1) > reslen)
    //         {
    //             res.append(s.substring(l,r+1));
    //             reslen = res.length();   
    //         }
    //         l--;
    //         r++;
    //     }
    // }
}