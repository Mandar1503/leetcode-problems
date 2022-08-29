// //MY SOLUTION USING TWO POINTER
// class Solution {
//     public boolean isPalindrome(String s) {
//         s = s.toUpperCase();
//         int i =0;
        
//         ArrayList<Character> sarr = new ArrayList<>();
//         for(char c : s.toCharArray())
//         {
//             if(Character.isLetterOrDigit(c))
//                 sarr.add(c);
//         }
//         int l=0;
//         int r=sarr.size()-1;
        
//         while(l <= r)
//         {
//             if(sarr.get(l) == sarr.get(r))
//             {
//                 l++;
//                 r--;
//             }
//             else
//                 return false;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            {
                sb.append(Character.toLowerCase(c)); 
            }
        }
        
        String filteredString = sb.toString();
        String reversedString = sb.reverse().toString();
        
        return filteredString.equals(reversedString);
            
    }
}