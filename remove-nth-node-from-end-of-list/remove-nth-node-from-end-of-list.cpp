/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */


//BRUTEFORCE Approach 1
// class Solution {
// public:
//     ListNode* removeNthFromEnd(ListNode* head, int n) {
//         ListNode* temp = head;
//         int size = 0;
//         while(temp!=NULL)
//         {
//             size++;
//             temp=temp->next;
//         }
//         temp=head;
//         for(int i=1;i<=(size-n-1);i++)
//         {
//             temp=temp->next;
//         }
//         temp->next=temp->next->next;
//         return head;
//     }
// };


//APPROACH 2 = only in one pass using 2 pointers = iterate two pointers such that one increments 1 at a time and other increments 2 at a time
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* p1 = head;
        ListNode* p2 = head;
        
        for(int i=0;i<n;i++) 
            p2 = p2->next;
        
        if(p2==NULL)
            return head->next;
        
        while(p2->next)
        {    
            p1=p1->next;
            p2=p2->next;
        }
        p1->next=p1->next->next;
        return head;
    }
};