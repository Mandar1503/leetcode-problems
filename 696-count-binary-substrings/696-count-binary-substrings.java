//GROUP BY CHARACTER
// class Solution {
//     public int countBinarySubstrings(String s) {
        
//         int group[] = new int[s.length()];
//         int t=0;
//         group[0]=1;
//         for(int i=1;i<s.length();i++)
//         {
//             if(s.charAt(i-1)!=s.charAt(i))
//             {
//                 t++;
//                 group[t] = 1;
//             }
//             else
//             {
//                 group[t]++;
//             }
//         }
        
//         int ans =0;
//         for(int i=1;i<=t;i++)
//         {
//             ans+=Math.min(group[i-1],group[i]);
//         }
//         return ans;
//     }
// }

//LINEAR SCAN
class Solution {
    public int countBinarySubstrings(String s) {
        int prev=0,curr=1,ans=0;
        
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                ans+=Math.min(prev,curr);
                prev = curr;
                curr =1;
            }
            else
            {
                curr++;
            }
        }
        
        return ans+Math.min(prev,curr);
    }
}