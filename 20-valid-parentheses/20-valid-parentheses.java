class Solution {
    public boolean isValid(String s) {
        Stack<Character> br = new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(c=='{' || c=='(' || c=='[')
                br.push(c);
            else
            {
                if(br.isEmpty() || (c!='}' && br.peek()=='{') || (c!=')' && br.peek()=='(') ||(c!=']' && br.peek()=='['))
                    return false;
                br.pop();
            }
        }
        return br.isEmpty();
    }
}