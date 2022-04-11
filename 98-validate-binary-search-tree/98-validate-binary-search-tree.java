/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//RECURSION APPROACH WITH A RANGE
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return validBST(root,null,null);
        
//     }
    
//     boolean validBST(TreeNode root,Integer low, Integer high)
//     {
//         if(root==null)
//             return true;
        
//         if((low!=null && low > root.val) || (high!=null && high < root.val))
//             return false;
        
//         return validBST(root.left,low,root.val) && validBST(root.right,root.val,high);
//     } 
// }

//RECURSIVE APPROACH USING INORDER
class Solution {
    
    Integer prev = null;
    
    public boolean isValidBST(TreeNode root) {
        
        if(root==null)
            return true;
        
        if(!isValidBST(root.left))
            return false;
        if(prev!=null && root.val<=prev)
            return false;
        prev = root.val;
        return isValidBST(root.right);
        
    }
}