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

//Brute force ie using a arraylist/vector
// class Solution {
// public:
//     bool isPalindrome(ListNode* head) {
//         vector<int> values;
        
//         //iterating into a array
//         ListNode* temp = head;
//         while(temp!=NULL)
//         {
//             values.push_back(temp->val);
//             temp=temp->next;
//         }
        
//         vector<int> revValues;
//         //reversing the array
//         for(int i=values.size()-1;i>=0;i--)
//         {
//             revValues.push_back(values[i]);
//         }
        
//         //checking if equal
//         for(int i=0;i<values.size();i++)
//         {
//             if(values[i]!=revValues[i])
//                 return false;
//         }
//         return true;
//     }
// };

//By Reversing the second half in place (IMPO APPROACH SINCE SOLVED IN O(N) SPACE COMPX)
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        //get the end if the first half and reverse the second part
        ListNode* firstHalfEnd = findEleSecondHalf(head);
        ListNode* eleToReverse = revSecondHalf(firstHalfEnd->next);
        
        //check if all the elements are same
        ListNode* p1 = head;
        ListNode* p2 = eleToReverse;
        
        bool result = true;
        while(result && p2!=NULL)
        {
            if(p1->val!=p2->val)
                result =false;
            p1 = p1->next;
            p2 = p2->next;
        }
        
        //again reverse second half to make it as earlier
        firstHalfEnd->next = revSecondHalf(eleToReverse);
        return result;
    }
    
    ListNode* findEleSecondHalf(ListNode* head)
    {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast->next!=NULL && fast->next->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    
    ListNode* revSecondHalf(ListNode* head)
    {
        ListNode* prev = NULL;
        ListNode* curr = head;
        
        while(curr!=NULL)
        {
            ListNode* nxt = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
};