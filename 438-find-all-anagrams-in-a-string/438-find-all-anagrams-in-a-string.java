class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int l = 0;
        int h =l;
        
        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        
        List<Integer> ans = new ArrayList<>();
        
        for(char ch : p.toCharArray())
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);    
        
        for(int i=0;i<s.length();i++)
        {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0)+1);
        
            if(i >= p.length())
            {
               char ch = s.charAt(i - p.length());
                if(smap.get(ch)==1)
                    smap.remove(ch);
                else
                    smap.put(ch, smap.get(ch)-1);
            }
            if(pmap.equals(smap))
                ans.add(i-p.length()+1);
        }
     
        return ans;
    }
}