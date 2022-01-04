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
class Solution {
    int count = 0;
public:
    int countUnivalSubtrees(TreeNode* root) {  
        if(!root)
            return 0;
        check(root);
        return count;
    }
    
    bool check(TreeNode* root)
    {
        if(!root->left && !root->right)  //condition for the leaf nodes as the have only one value
        {
            count++;
            return true;
        }
        
        bool flag = true;         //flag to keep track of both the children of a root whether they have the same values
        
        if(root->left)      //to iterate the left side of each of the root    
        {
            flag = check(root->left) && root->val==root->left->val; //check whether the root-child values are equal and the left child subtree is uni-value 
        }
        
        if(root->right)     //iterate right side
        {
            flag = check(root->right) && flag && root->val==root->right->val; //check whether the rightchild-root have same values and whether the flag is true from above left side iteration and also the value from the right child subtree 
        }
        
        if(!flag)       //if flag after both the iterations is true then that means the both subchilds of the root are univalue which inturn make the root tree univalue otherwise return false
            return false;
        count++;        //thus increment the count and return true
        return true;  
    }
};