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

//TWO PASS SOLUTION
// class Solution {
//     public ListNode swapNodes(ListNode head, int k) {
        
//         int listlength = 1;
//         ListNode tempNode = head;
//         ListNode frontNode = null;
        
//         while(tempNode!=null)
//         {
//             if(listlength==k)
//                 frontNode = tempNode;
//             tempNode=tempNode.next;
//             listlength++;
//         }
        
//         ListNode lastNode=null;
//         tempNode=head;
//         int track =1;
//         while(tempNode!=null)
//         {
//             if(listlength-k==track)
//                 lastNode = tempNode;
//             tempNode=tempNode.next;
//             track++;
//         }
        
//         int temp = frontNode.val;
//         frontNode.val = lastNode.val;
//         lastNode.val = temp;
        
//         return head;
//     }
// }

//ONE PASS SOLUTION
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        int listlength = 0;
        ListNode tempNode = head;
        ListNode frontNode = null;
        ListNode lastNode = null;
        
        while(tempNode!=null)
        {
            listlength++;
           if(lastNode!=null)
               lastNode = lastNode.next;
            
            if(listlength==k)
            {
                frontNode = tempNode;
                lastNode = head;
            }
            tempNode=tempNode.next;
        }
        
        int temp = frontNode.val;
        frontNode.val = lastNode.val;
        lastNode.val = temp;
        
        return head;
    }
}
