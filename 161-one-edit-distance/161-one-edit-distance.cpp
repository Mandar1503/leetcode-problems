class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        int ns = s.size();
        int nt = t.size();
        
        if(ns>nt)      //check if s is always the smaller string
            return isOneEditDistance(t,s);
        
        for(int i=0;i<ns;i++) //iterate using smaller string
        {
            if(s[i]!=t[i])  //check if elements at a specific position are equal or not
            {
                if(ns==nt)  //if elements above are not equal just check if strings are of same length
                    return s.substr(i+1)==t.substr(i+1); //in this case check if the remaining elements in the string are equal or not if yes return true otherwise false
                else
                    return s.substr(i)==t.substr(i+1); //if strings are not equal then then check for the substring starting from the next element of the bigger string with the smaller string if equal then true other wise false
            }
        }
        return ns+1==nt;  //for edge case like if all the elements are equal in order but only last element of the bigger string is not equal like 'abc' & 'ab'
    }
};


//BRUTE FORCE - MY SOLUTION - I guess this is wrong solution
// class Solution {
// public:
//     bool isOneEditDistance(string s, string t) {
        
//         if(s.size()>t.size())   //check that s is always smaller string
//             return isOneEditDistance(t,s);
        
//         if(s.size()==t.size()) //if equal
//         {
//             int i=0,j=0;
//             int count=0;
//             while(i<s.size())
//             {
//                 if(s[i]==t[j])
//                 {
//                     count++; //get the count of equal elements
//                 }
//                 i++;
//                 j++;
//             }
//             if(count!=s.size()-1) //if count of equal elements is 1 less then any string's of the total size then return true else false
//                 return false;
//             else
//                 return true;
//         }
//         else if(t.size()-s.size()==1) //if 1 length small
//         {
//             int count=0;
//             int k=0;
//             for(int i=0;i<s.size();i++) //start with smaller string
//             {
//                 for(int j=k;j<t.size();j++) //
//                 {
//                     if(s[i]==t[j]) 
//                     {
//                         count++;
//                         k=j+1;
//                         break;
//                     }
//                 }
//             }
//             if(count==s.size())
//                 return true;
//             else 
//                 return false;
//         }
//         else 
//             return false;
//     }
// };