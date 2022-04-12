//RECURSIVE SOLUTION TO REVERSE LIST USING TWO POINTERS AND SWAPPING THEM RECURSIVELY
class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
    private void reverse(char[] s,int left, int right)
    {
        if(left>=right)
            return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s,++left,--right);        
    }
}

//BUT HERE NORMAL SWAPPING USING TWO POINTERS WITHOUT USING RECURSION IS BETTER SOLUTION SINCE RECURSION USES STACK