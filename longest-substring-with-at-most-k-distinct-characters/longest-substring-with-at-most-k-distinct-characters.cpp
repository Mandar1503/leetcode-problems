class Solution {
    
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        if(s.size()==0 || k==0)
            return 0;
        
        map<char,int> ll;
        int l = 0;
        int r = 0;
        int maxl = 1;
        
        if(r==0)
        {
            ll.insert({s[0],0});
            r++;
        }
        while(r<s.size())
        {
            int lindex = INT_MAX;
            
            if(ll.find(s[r])==ll.end())
            {
                    ll.insert({s[r],r});
                    
            }
            else
            {
                ll.erase(s[r]);
                ll.insert({s[r],r});
                
            }
            if(ll.size()>k)
            {
                for(pair<char,int> ele:ll)
                    lindex = min(lindex,ele.second);
                l = lindex+1;
                ll.erase(s[lindex]);
            }
            if((r-l)+1>maxl)
                maxl=(r-l)+1;
            r++;
        }
         return maxl;
    }
};