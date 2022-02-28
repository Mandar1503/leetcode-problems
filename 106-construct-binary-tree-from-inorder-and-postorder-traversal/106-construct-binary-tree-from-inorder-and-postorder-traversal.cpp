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
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size()!=postorder.size())
            return NULL;
        
        map<int,int> hm;  //to get the position of the root from inorder
        
        for(int i=0; i<inorder.size(); i++)
            hm[inorder[i]] = i;
        
        return buildTreePosIn(inorder, 0, inorder.size()-1, postorder, 0, postorder.size()-1, hm); 
    }
    
    
    TreeNode* buildTreePosIn(vector<int>& inorder, int is, int ie, vector<int>& postorder, int ps, int pe, map<int,int>& hm)
    {
        if(is>ie || ps>pe)  //if no right or left node remaining
            return NULL;
        
        TreeNode* root = new TreeNode(postorder[pe]); //o/w get the root
        int inRoot = hm[postorder[pe]]; //index of root in the inorde
        int numsLeft = inRoot - is;     //number of elements in the left of root in inorder
        
        root->left = buildTreePosIn(inorder, is, inRoot-1, postorder, ps, ps+numsLeft-1, hm);   //call for left part of the root
        root->right = buildTreePosIn(inorder, inRoot+1, ie, postorder, ps+numsLeft, pe-1, hm);            //call for right part of the root
        
        return root;    //return the root each time
    }
};