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

//My Approach works pretty good
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* temp =head;
        
        while(head!=NULL && head->val==val)
        {
            head = head->next; 
            temp = head;
        }
        if(head==NULL)
            return head;
        while(temp->next!=NULL)
        {
            if(temp->next->val==val)
            {
                temp->next = temp->next->next;
            }
            else
                temp=temp->next;
        }
        return head;
    }
};

//Sentinel Approach from solution
// class Solution {
// public:
//     ListNode* removeElements(ListNode* head, int val) {
//         ListNode* sentinel = new ListNode(0);
//         sentinel->next = head;
        
//         ListNode* prev = sentinel;
//         ListNode* curr = head;
//         ListNode* toDelete = NULL;
        
//         while(curr!=NULL)
//         {
//             if(curr->val==val)
//             {
//                 prev->next=curr->next;
//                 toDelete = curr;
//             }
//             else
//             {
//                 prev = curr;
//             }
//             curr=curr->next;
            
//             if(toDelete!=NULL)
//             {
//                 delete toDelete;
//                 toDelete = NULL;
//             }
//         }
        
//         ListNode* ans = sentinel->next;
//         delete sentinel;
//         return ans;
//     }
// };

