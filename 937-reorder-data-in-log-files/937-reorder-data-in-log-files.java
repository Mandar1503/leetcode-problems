//Using Comparator
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<>(){
            @Override
            public int compare(String log1,String log2)
            {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2)
                {
                    int c = split1[1].compareTo(split2[1]);
                    if(c!=0)
                        return c;
                        
                    return split1[0].compareTo(split2[0]);                            
                }
                if(!isDigit1 && isDigit2)
                            return -1;
                else if(isDigit1 && !isDigit2)
                            return 1;
                else 
                    return 0;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}