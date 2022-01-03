/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
//RECURSIVE METHOD
// class Solution {
// public:
//     bool isSymmetric(TreeNode* root) {
//       return isSym(root,root);
//     }
    
//     bool isSym(TreeNode* t1,TreeNode* t2)
//     {
//         if(t1==NULL && t2==NULL)   //both of them null
//             return true;
//         if(t1==NULL || t2==NULL)   //if only one of them is null
//             return false;
        
//         return (t1->val==t2->val) && isSym(t1->right,t2->left) && isSym(t1->left,t2->right);  //ans from children nodes
//     }
// };

//ITERATIVE METHOD
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);  //push root
        q.push(root);  //push root
        
        while(!q.empty())
        {
            TreeNode* t1 = q.front(); //pop two elements here 
            q.pop();
            TreeNode* t2 = q.front();
            q.pop();
            
            if(t1==NULL && t2==NULL) //if both null continue
                continue;
            if(t1==NULL || t2==NULL) //if one of them null then return false
                return false;
            if(t1->val!=t2->val)     //if not equal then return false
                return false;
            
            q.push(t1->right);       //else push two next values from each side such that they are consecutive
            q.push(t2->left);
            q.push(t1->left);
            q.push(t2->right);
        }
        return true;                 //return true if all the tree is traversed with all the conditions
    }
};

