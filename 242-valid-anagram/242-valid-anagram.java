class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sCharSet = new HashMap<>();
        HashMap<Character,Integer> tCharSet = new HashMap<>();
        
        if(s.length()!=t.length())
            return false;
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            sCharSet.put(ch, sCharSet.getOrDefault(ch,0)+1);
        }
        
        for(int i=0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            tCharSet.put(ch, tCharSet.getOrDefault(ch,0)+1);
        }
        
        for(Map.Entry<Character,Integer> mp : sCharSet.entrySet())
        {
            if(!tCharSet.containsKey(mp.getKey()) || tCharSet.get(mp.getKey()).intValue()!=mp.getValue().intValue())
            {
                return false;
            }
        }
        return true;
    } 
}