class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       
        int pmap[] = new int[26];
        int smap[] = new int[26];
        List<Integer> ans = new ArrayList<>();
        
        for(char ch : p.toCharArray())
        {
            pmap[ch - 'a']++;
        }
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            smap[ch - 'a']++;
            
            if(i>=p.length())
            {
                char ele = s.charAt(i-p.length());
                if(smap[ele - 'a']!=0)
                    smap[ele - 'a']--;
                // else
                //     smap[ele - 'a']=0;
            }
            if(Arrays.equals(pmap,smap))
                ans.add(i-p.length()+1);
        }
        return ans;
    }
}

// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
        
//         //maps to store the values in from s and p
//         HashMap<Character, Integer> pmap = new HashMap<>();
//         HashMap<Character, Integer> smap = new HashMap<>();
        
//         //answer list
//         List<Integer> ans = new ArrayList<>();
        
//         //enter all the values from p string into the pmap
//         for(char ch : p.toCharArray())
//             pmap.put(ch,pmap.getOrDefault(ch,0)+1);    
        
//         //loop through the s string
//         for(int i=0;i<s.length();i++)
//         {
//             //put the element into the map
//             smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0)+1);
        
//             //if the i is after plength
//             if(i >= p.length())
//             {
//                 //get the 1st charater of th plength string
//                char ch = s.charAt(i - p.length());
                
//                 //check if it is 1, if yes then remove otherwise reduce count
//                 if(smap.get(ch)==1)
//                     smap.remove(ch);
//                 else
//                     smap.put(ch, smap.get(ch)-1);
//             }
            
//             //check if both the maps are same if yes then add the index of the string
//             if(pmap.equals(smap))
//                 ans.add(i-p.length()+1);
//         }
     
//         return ans;
//     }
// }