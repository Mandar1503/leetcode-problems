//SLIDING WINDOW PROBLEM = LOOK FOR 2ND MORE OPTIMIZED SOLUTION BY INCLUDING FILTERED CHARACTERS LIST OF PAIRS
class Solution {
	public String minWindow(String s, String t) 
	{
        
        if(s.length()==0 && t.length()==0)      //end case
            return "";
        
		Map<Character,Integer> tCharSet = new HashMap<>();  
		    
		for(int i=0;i<t.length();i++)           //loop through t string make a hashmap with resp counts
		{	
			int count = tCharSet.getOrDefault(t.charAt(i),0);
			tCharSet.put(t.charAt(i),count+1);
		}

		int required = tCharSet.size();     //characters in t string
		
		int l = 0;
		int r = 0;
		
		Map<Character,Integer> sCharSet = new HashMap<>();  
		int formed = 0;                     //to keep track of characters in s string 
		
        int[] ans = {-1,0,0};

		while(r<s.length())                 //std sliding window loop
		{
			char ch = s.charAt(r);          //get the r char and add it to the hashmap
			int cnt = sCharSet.getOrDefault(ch,0);
			sCharSet.put(ch,cnt+1);
			
			if(tCharSet.containsKey(ch) && sCharSet.get(ch).intValue()==tCharSet.get(ch).intValue())        //if the count of that character matches with the count in t's hashmap then we have a character count included in this window
				formed++;
			

			while(l<=r && required==formed)       //now if we have all the required characters in the window then we try to reduce the window by incr l
			{
				if(ans[0]==-1 || ans[0]>r-l+1)     //before that we update the smallest window
				{
					ans[0] = r-l+1;
					ans[1] = l;
					ans[2] = r;
				}

				char chr = s.charAt(l);             //remove the character at l from the hashmap in wrt count
				sCharSet.put(chr,sCharSet.get(chr)-1);

				if(tCharSet.containsKey(chr) && tCharSet.get(chr).intValue() > sCharSet.get(chr).intValue())            //if the formed characters < required characters then decr formed
					formed--;
				l++;    //finally l++
			}
			r++;    //new r++
		}
		return ans[0]==-1 ? "" : s.substring(ans[1],ans[2]+1);
	}
}


