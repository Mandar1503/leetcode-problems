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

//RECURSIVE SOLUTION
class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        
        if(!root)                       //terminal condition when root is NULL
            return false;
        
        targetSum-=root->val;           //subtract the value from target sum
        
        if(!root->left && !root->right) //terminal condition when leaf node is reached
            return(targetSum==0);
        
        return hasPathSum(root->left,targetSum) || hasPathSum(root->right,targetSum); //to iterate to both the child nodes
    }                                                                                 
};

//ITERATIVE APPROACH (THIS SOLUTIONS DOESN'T SOLVE ONE TESTCASE)
// class Solution {
// public:
//     bool hasPathSum(TreeNode* root, int targetSum) {
        
//         if(!root)                           //check if the root is empty 
//             return false;
        
//         stack<pair<TreeNode*,int>> sk;      //declare a stack of pair values <TreeNode*,int>
//         sk.push({root,targetSum-root->val});//push the root node and the corr value
//                      //make node root
        
//         while(!sk.empty())
//         {
//             TreeNode* node = sk.top().first;          //get the node from top of stack
//             int sum = sk.top().second;      //get value of the sum from the top of the stack
//             sk.pop();                       //pop the ele at top
            
//             if(node->right!=NULL)
//             {
//                 sk.push({node->left,sum-node->right->val}); //push the right ele
//             }
//             if(node->left!=NULL)                      
//             {
//                 sk.push({node->left,sum-node->left->val});  //push the left ele
//             }
//             if(!node->right && !node->left && sum==0)       //check if the node is leaf and the sum is zero
//                 return true;
//         }
//         return false;
//     }
// };