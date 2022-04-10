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

//MY SOLUTION = 100% FASTER BUT DONE CREATING A NEW LINKEDLIST
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode p1 = list1;
//         ListNode p2 = list2;
//         ListNode head = null;
//         ListNode p=null;
//         while(p1!=null || p2!=null)
//         {
//             int v1 = (p1==null)?Integer.MAX_VALUE:p1.val;
//             int v2 = (p2==null)?Integer.MAX_VALUE:p2.val;
            
//             if(head!=null)
//             {
//                 if(v1<=v2)
//                 {
//                     ListNode temp = new ListNode(v1);
//                     p.next=temp;
//                     p=temp;
//                     p1 = (p1==null)?null:p1.next;
//                 }
//                 else
//                 {
//                     ListNode temp = new ListNode(v2);
//                     p.next=temp;
//                     p=temp;
//                     p2 = (p2==null)?null:p2.next;
//                 }
//             }
//             else
//             {
//                 if(v1<=v2)
//                 {
//                     ListNode temp = new ListNode(v1);
//                     head = temp;
//                     p = temp;
//                     p1 = (p1==null)?null:p1.next;
//                 }
//                 else
//                 {
//                     ListNode temp = new ListNode(v2);
//                     head = temp;
//                     p = temp;
//                     p2 = (p2==null)?null:p2.next;
//                 }
//             }
//         }
//         return head;
//     }
// }



//RECURSIVE APPROACH
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
//         if(list1==null)
//             return list2;
//         if(list2==null)
//             return list1;
        
//         ListNode head;
//         if(list1.val < list2.val)
//         {
//             head = list1;
//             list1=list1.next;
//         }
//         else
//         {
//             head = list2;
//             list2=list2.next;
//         }
//         head.next = mergeTwoLists(list1,list2);
//         return head;
//     }
// }

//ITERATIVE SOLUTION BUT WITHOUT USING A NEW LINKEDLIST
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = new ListNode();
        ListNode l = head;
        
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                l.next = list1;
                list1=list1.next;
            }
            else
            {
                l.next = list2;
                list2=list2.next;
            }
            l=l.next;
        }
        
        if(list1==null)
            l.next = list2;
        else
            l.next = list1;
        
        return head.next;
    }
}