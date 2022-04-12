/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//MY SOLUTION  TWO POINTER AND IMPO TRICK(SET NODE TO HEAD WHEN LLENGTH=N) FOR ONE MORE IMPO POINT LOOK THE COMMENT IN CODE
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode = head;
        ListNode endNode = null;
        int listlength = 0;
        
        
        while(tempNode.next!=null)
        {
            listlength++;
            if(endNode!=null)
                endNode=endNode.next;
            
            if(listlength==n)       
                endNode = head;
            
            tempNode=tempNode.next;
        }
        
        if(endNode==null)   //VERY VERY IMPO STEP => IF N == TOTALLENGTH OF LIST, THEN HEAD IS TO BE REMOVERED SINCE HEAD IS THE NTH NODE FROM THE END
            return head.next;
        
        ListNode node = endNode.next;
        endNode.next = node.next;
        
        return head;
    }
}