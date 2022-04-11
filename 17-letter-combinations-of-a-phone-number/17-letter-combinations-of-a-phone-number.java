
//SOLUTION FROM A YOUTUBE VIDEO BY Kevin Naughton Jr.
class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        String[] mapping = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        if(digits==null || digits.length()==0)
            return result;
        
        letterCombinationsRecursive(result,digits,"",0,mapping);
        return result;
    }
    
    void letterCombinationsRecursive(ArrayList<String> result,String digits,String current,int index, String[] mapping)
    {
        if(index==digits.length())
        {
            result.add(current);
            return;
        }
        
        String letters = mapping[digits.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++)
        {
            letterCombinationsRecursive(result,digits,current+letters.charAt(i),index+1,mapping);
        }
    }
}