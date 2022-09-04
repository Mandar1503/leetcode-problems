class Solution
{
	public String longestPalindrome(String s)
	{
		int reslen = 0;
		StringBuilder res = new StringBuilder();
		
		for(int i=0;i<s.length();i++)
		{
			int l = i;
			int r = i;
			
            // helperfunction(l,r,reslen,res,s);
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
			{
				if(r-l+1 > reslen)
				{
					res.delete(0,reslen);
					res.append(s.substring(l,r+1));
					reslen = r-l+1;
				}	
				l--;
				r++;
			}
			
			l = i;
			r = i+1;

            // helperfunction(l,r,reslen,res,s);
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
			{
				if(r-l+1 > reslen)
				{
					res.delete(0,reslen);
					res.append(s.substring(l,r+1));
					reslen = r-l+1;
				}	
				l--;
				r++;
			}
		}
		return res.toString();
	}
}