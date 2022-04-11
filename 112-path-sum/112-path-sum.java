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

//MY SOLUTION = RECURSION = TOP DOWN APPROACH
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        
        int sum = 0;
        return pathSum(root,sum,targetSum);
    }
    
    private boolean pathSum(TreeNode root, int sum, int targetSum)
    {
        if(root==null)
            return false; 
        if(root.left==null && root.right==null && (sum+root.val)==targetSum)
            return true;
        // else if(root.left==null && root.right==null && (sum+root.val)!=targetSum)
        //     return false;
        
        return pathSum(root.left, sum+root.val, targetSum) || pathSum(root.right, sum+root.val, targetSum);
    }
}

// class Solution {
//     private boolean res = false;
//     public boolean hasPathSum(TreeNode root, int targetSum) {
        
//         if(root==null)
//             return false;
        
//         targetSum-=root.val;
//         if(root.left==null && root.right==null && targetSum==0)
//             return true;
        
//         return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
//     }  
// }