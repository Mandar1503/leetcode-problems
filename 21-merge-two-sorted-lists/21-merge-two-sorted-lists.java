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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = null;
        ListNode p=null;
        while(p1!=null || p2!=null)
        {
            int v1 = (p1==null)?Integer.MAX_VALUE:p1.val;
            int v2 = (p2==null)?Integer.MAX_VALUE:p2.val;
            
            if(head!=null)
            {
                if(v1<=v2)
                {
                    ListNode temp = new ListNode(v1);
                    p.next=temp;
                    p=temp;
                    p1 = (p1==null)?null:p1.next;
                }
                else
                {
                    ListNode temp = new ListNode(v2);
                    p.next=temp;
                    p=temp;
                    p2 = (p2==null)?null:p2.next;
                }
            }
            else
            {
                if(v1<=v2)
                {
                    ListNode temp = new ListNode(v1);
                    head = temp;
                    p = temp;
                    p1 = (p1==null)?null:p1.next;
                }
                else
                {
                    ListNode temp = new ListNode(v2);
                    head = temp;
                    p = temp;
                    p2 = (p2==null)?null:p2.next;
                }
            }
            
            
        }
        return head;
    }
}