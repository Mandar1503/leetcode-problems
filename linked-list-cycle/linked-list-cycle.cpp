/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
//O(n) = BRUTE FORCE = Approach 1
// class Solution {
// public:
//     bool hasCycle(ListNode *head) {
        
//         ListNode* curr = head;
//         vector<int> nos;
//         nos.push_back(curr->val);
//         while(curr->next!=NULL)
//         {
//             if(curr==NULL)
//                 return false;
                
//             curr=curr->next;
//             if(find(nos.begin(),nos.end(),curr->val)!=nos.end())
//                 nos.push_back(curr->val);
//             else
//                 return true;
//         }
//         return false;
//     }
// };

//APPROACH 2 = FLOYD'S HARE AND TORTOISE ALGO/ FLOYD'S CYCLE FINDING ALGO
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast!=NULL && fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
            if(slow==fast)
                return true;
        }
        return false;
    }
};