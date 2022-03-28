class Solution {
public:
    bool isValid(string s) {
        
        stack<char> brkts;
        
        for(int i=0;i<s.size();i++)
        {
            if(brkts.empty() && (s[i] == ')' || s[i] == '}' || s[i] == ']'))
                return false;
            else if(s[i] == '(' || s[i] == '{' || s[i] == '[')
                brkts.push(s[i]);
            else if(((s[i] == '}' && brkts.top() == '{') || (s[i] == ')' && brkts.top() == '(') || (s[i] == ']' && brkts.top() == '[')) && !brkts.empty())
            {
                brkts.pop();   
            }
            else
                return false;
        }
        if(!brkts.empty())
            return false;
        else
            return true;        
    }
};