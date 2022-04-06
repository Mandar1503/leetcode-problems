class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> chr =  new HashMap<>();
        char[] str = s.toCharArray();
        for(char ch: str)
        {
            //chr.put(Character.valueOf(ch),chr.getOrDefault(Character.valueOf(ch),0)+1);
            chr.put(ch,chr.getOrDefault(ch,0)+1);
        }
        int count = 0;
        for(char key: chr.keySet())
        {
            count+=chr.get(key)%2;
        }
        return count<=1;
    }
}