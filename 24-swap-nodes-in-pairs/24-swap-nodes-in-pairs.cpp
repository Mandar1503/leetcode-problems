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

//ITERATIVE SOLUTION : USING SENTINEL NODE, INCREMENTING HEAD & USE OF TWO POINTERS
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        
        //Use a dummy node/sentinel node 
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        
        ListNode* prevN = dummy;
        
        while(head!=NULL && head->next!=NULL) //check if head is NULL or not for even no of elements and head->next for odd elements
        {
            //set the 1st and 2nd pointer
            ListNode* p1 = head;
            ListNode* p2 = head->next;
        
            //swap the 1st and 2nd pointer and connect the prevNode to 1st swaped element
            prevN->next = p2;
            p1->next = p2->next;
            p2->next = p1;
        
            //update the prevNode and head for next swap
            prevN = p1;
            head = p1->next;
        }
        return dummy->next;
    }
};


//RECURSIVE APPROACH
// class Solution {
// public:
//     ListNode* swapPairs(ListNode* head) {
     
//         if(head==NULL || head->next==NULL) //terminal condition for last iteration when head==NULL(even nos) and head->next== NULL(odd nos)
//             return head;
        
//         ListNode* p1 = head;                //initialise the 1st pointer for each iteration for swaping
//         ListNode* p2 = head->next;          //similarly initialise 2nd pointer
        
//         //swapping
//         p1->next = swapPairs(p2->next);     //the head from the swaped elements from the next iteration is connected to the 1st pointer sinces it is going to 2nd no after swapping
//         p2->next = p1;                      //connect the 2nd no to first
        
//         return p2;                          //return 2nd no since it is going to be the first element after swapping and a next element to connect for the previous iterations
//     }
// };

