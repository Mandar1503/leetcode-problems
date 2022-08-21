class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()==0 && t.length()==0)
            return "";

        
        Map<Character, Integer> charset = new HashMap<>();
        
        for(int i=0;i<t.length();i++)
        {
            int count = charset.getOrDefault(t.charAt(i),0);
            charset.put(t.charAt(i),count+1);
        }
        
        int required = charset.size(); 
        
        int l =0;
        int r = 0;
        
        int formed = 0;
        
        Map<Character, Integer> windowCharSet = new HashMap<>();
        
        int[] ans ={-1, 0, 0};
        
        while(r < s.length())
        {
            char charac = s.charAt(r);
            int c = windowCharSet.getOrDefault(charac,0);
            windowCharSet.put(charac,c+1);
            
            if(charset.containsKey(charac) && windowCharSet.get(charac).intValue()==charset.get(charac).intValue())
            {
                formed++;
            }
            
            while(l<=r && formed==required)
            {
                charac = s.charAt(l);
                if(ans[0]==-1 || r-l+1 < ans[0])
                {
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                int count1 = windowCharSet.get(charac);
                windowCharSet.put(charac, count1-1);
                
                if(charset.containsKey(charac) && charset.get(charac).intValue() > windowCharSet.get(charac).intValue())
                {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
    }
}