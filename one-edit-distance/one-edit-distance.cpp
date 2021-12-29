class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        if(s.size()>t.size())
            return isOneEditDistance(t,s);
        
        if(s.size()==t.size())
        {
            int i=0,j=0;
            int count=0;
            while(i<s.size())
            {
                if(s[i]==t[j])
                {
                    count++;
                }
                i++;
                j++;
            }
            if(count!=s.size()-1)
                return false;
            else
                return true;
        }
        else if(t.size()-s.size()==1)
        {
            int count=0;
            int k=0;
            for(int i=0;i<s.size();i++)
            {
                for(int j=k;j<t.size();j++)
                {
                    if(s[i]==t[j])
                    {
                        count++;
                        k=j+1;
                        break;
                    }
                }
            }
            if(count==s.size())
                return true;
            else 
                return false;
        }
        else 
            return false;
    }
};