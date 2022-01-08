/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

//BRUTE FORCE Approach 1
// class Solution {
// public:
//     ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
//         unordered_set<ListNode*> A;
//         while(headA!=NULL)
//         {
//             A.insert(headA);
//             headA=headA->next;
//         }
//         while(headB!=NULL)
//         {
//             if(A.count(headB)==1)
//                 return headB;
//             headB=headB->next;
//         }
//         return NULL;
//     }
// };

//APPROACH 2 two points = calculate the difference b/w the lls and the place the pointer of the bigger ll ahead by the diff and then start the iteration for checking whether the nodes are same for finding the intersection
// class Solution {
// public:
//     ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
//             ListNode* pA=headA;
//             ListNode* pB=headB;
//             int Acount = 0;
//             int Bcount = 0;
//             while(pA!=NULL)
//             {
//                 Acount+=1;
//                 pA=pA->next;
//             }
//             while(pB!=NULL)
//             {
//                 Bcount+=1;
//                 pB=pB->next;
//             }
//             pA = headA;
//             pB = headB;
//             int diff = (Acount>Bcount)?Acount-Bcount:Bcount-Acount;
//             for(int i=1;i<=diff;i++)
//             {
//                 if(Acount>Bcount)
//                 {
//                     pA=pA->next;
//                 }
//                 else
//                 {
//                     pB=pB->next;
//                 }
//             }
//             while(pA!=pB)
//             {
//                 pA=pA->next;
//                 pB=pB->next;
//             }
//             return pA;
//     }
// };

//APPROACH 2- Optimised Code but the time and space complexity is same as the earlier soln
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
            ListNode* pA=headA;
            ListNode* pB=headB;
            
            while(pA!=pB)
            {
                pA = (pA==NULL)?pA=headB:pA=pA->next;
                pB = (pB==NULL)?pB=headA:pB=pB->next;
            }
            return pA;
    }
};

