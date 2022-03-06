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
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* p1 = l1;
        ListNode* p2 = l2;
        ListNode* ans =new ListNode();
        ListNode* a = ans;
        
        int carry = 0;
        int sum = 0;
        
        while(p1!=NULL || p2!=NULL)
        { 
            int p1value;
            int p2value;
            
            p1value = (p1==NULL) ? 0 : p1->val;
            p2value = (p2==NULL) ? 0 : p2->val;
                
            sum = p1value + p2value + carry;
            carry = sum/10;
            
            a->next = new ListNode(sum%10);
            a = a->next;
            
            if(p1!=NULL)
                p1=p1->next;
            if(p2!=NULL)
                p2=p2->next;
        }
        
        if(carry>0)
            a->next = new ListNode(carry);
        
        return ans->next;
    }
};