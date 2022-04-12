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

//RECURSIVE SOLUTION 
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//            if(head==null || head.next==null)  //BASE CASE WHEN HEAD IS NULL
//                return head;
        
//             ListNode node1 = head;          //ASSIGN NODES        
//             ListNode node2 = head.next;
        
//             node1.next = swapPairs(head.next.next); //SWAP
//             node2.next = node1;
//             return node2;                           //NEW HEAD SHOULD BE THE HEAD OF THIS SUBLIST
            
//     }
// }


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prevNode = dummy;
        
        while(head!=null && head.next!=null)
        {
            ListNode N1 = head;
            ListNode N2 = head.next;
            
            N1.next = N2.next;
            N2.next = N1;
            prevNode.next = N2;
            
            prevNode = N1;
            head = N1.next;
        }
        return dummy.next;
    }
}