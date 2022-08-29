//Both the solutions are basically the same
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

//Using hashmap
// class Solution {
//     public boolean isValid(String s) {
//         HashMap<Character,Character> map = new HashMap<>();
//         Stack<Character> stk = new Stack<>();
//         map.put(')','(');
//         map.put(']','[');
//         map.put('}','{');
        
//         for(char c: s.toCharArray())
//         {
//             if(map.containsKey(c))
//             {
//                 if(!stk.isEmpty() && map.get(c)==stk.peek())
//                     stk.pop();
//                 else
//                     return false;
//             }
//             else
//             {
//                 stk.push(c);
//             }
//         }
//         return stk.isEmpty();
//     }
// }

