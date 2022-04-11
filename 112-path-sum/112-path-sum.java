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

//MY SOLUTION = RECURSION = TOP DOWN APPROACH (100% FAST)
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
    // else if(root.left==null && root.right==null && (sum+root.val)!=targetSum)//it works even if this is removed
    //     return false;
        
        return pathSum(root.left, sum+root.val, targetSum) || pathSum(root.right, sum+root.val, targetSum);
    }
}

//Same as above(TOP DOWN APPROACH)
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


//MY SOLUTION = ITERATIVE 
// class Solution {
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         Stack<TreeNode> stack = new Stack<>();
//         Stack<Integer> l = new Stack<>();
        
//         if(root==null)
//             return false;
        
//         stack.push(root);
//         l.push(targetSum-root.val);
        
//         TreeNode curr;
//         int curr_sum;
//         while(!stack.isEmpty())
//         {
//             curr = stack.pop();
//             curr_sum = l.pop();
            
//             if(curr.right==null && curr.left==null && curr_sum==0)
//                 return true;
            
//             if(curr.right!=null)
//             {
//                 stack.push(curr.right);
//                 l.push(curr_sum-curr.right.val);
//             }
//              if(curr.left!=null)
//             {
//                 stack.push(curr.left);
//                 l.push(curr_sum-curr.left.val);
//             }
//         }
//         return false;
//     } 
// }