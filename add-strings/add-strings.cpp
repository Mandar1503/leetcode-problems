class Solution {
public:
    string addStrings(string num1, string num2) {
     
        int carry = 0;
        int n1 = num1.size()-1;
        int n2 = num2.size()-1;
       
        string ans;
        
        while(n1>=0 || n2>=0 || carry>0)
        {
            int no1 = (n1>=0)?num1[n1--]-'0':0;
            int no2 = (n2>=0)?num2[n2--]-'0':0;
            
            int sum = no1 + no2 + carry;
            carry=sum/10;
            sum = sum%10;
            // ans.insert(ans.begin(), sum +'0'); //this works
            ans = to_string(sum) + ans;
        }
        // if(carry>0) //instead of this add 'carry>0' this condition above in while loop
        // {
        //     // ans.insert(ans.begin(), carry +'0'); //this works
        //     ans = to_string(carry) + ans;
        // }
        return ans;
    }
};