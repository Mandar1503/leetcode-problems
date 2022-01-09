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

//IMPORTANT APPROACH 
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(head==NULL)
            return NULL;
        
        ListNode* odd=head;      //odd to index 1
        ListNode* even = head->next; //even index 2
        ListNode* evenhead = even; //evenhead to even ie. 2
            
        while(even!=NULL && even->next!=NULL) //untill even or even->next is NULL
        {
            odd->next = even->next;  //connect curr odd node to next odd node
            odd=odd->next;          //reposition odd to the next new pos ie. new odd element
            even->next=odd->next;   //do the same for the even nodes
            even=even->next;
        }                           //At the end of the loop to LL will be created one for odd and other for even
        odd->next=evenhead;         //just connect the last odd node to the evenhead thus connex=cting the both LL's
        return head;                //return the head of the whole list
    }
};