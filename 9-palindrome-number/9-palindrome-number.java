class Solution {
    public boolean isPalindrome(int x) {
        
        String xno = String.valueOf(x);
        char[] arr = xno.toCharArray();
        String rev="";
        for(int i=arr.length-1;i>=0;i--)
        {
            //rev.concat(String.valueOf(arr[i]));
            rev=rev+arr[i];
        }
        System.out.println(xno);
        System.out.println(rev);
        if(rev.equals(xno))
            return true;
        else
            return false;
    }
}