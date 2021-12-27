class Solution {
public:
    string addBinary(string a, string b) {
        
        if(a.size()<b.size())
            addBinary(b,a);
        
        reverse(a.begin(),a.end());
        reverse(b.begin(),b.end());
        
        int carry = 0;
        vector<char> answer;
        for(int i=0;i<a.size() || i<b.size();i++)
        {
            int no1 = (i>a.size()-1)?0:a[i]-'0';
            int no2 = (i>b.size()-1)?0:b[i]-'0';
            
            int sum = no1 + no2 + carry;
            carry = sum/2;
            sum = sum%2;
            answer.push_back(sum+'0');
        }
        if(carry==1)
            answer.push_back(1+'0');
        string ans;
        for(int i=0;i<answer.size();i++)
        {
            ans=ans+(answer[i]);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};


//NOT WORKING HAVE TO LOOK INTO THE SOLUTION
// class Solution {
// public:
//     string addBinary(string a, string b) {
//         unsigned long int no1=0;
//         unsigned long int no2=0;
//         for(int i=0;i<a.size();i++)
//         {
//             no1=no1*10 + (a[i]-'0');
//         }
//         for(int i=0;i<b.size();i++)
//         {
//             no2=no2*10 + (b[i]-'0');
//         }
//         unsigned long int answer;
//         unsigned long int carry;
//         while(no2!=0)
//         {
//             answer = no1^no2;
//             carry = (no1&no2)<<1;
//         }
//         string ans;
//         stringstream ss;
//         ss<<answer;
//         ss>>ans;
        
//         return ans;
//     }
// };