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

//TOP DOWN APPROACH BUT NOT WORKING
// class Solution {
//     private int answer = 1;
//     public int maxDepth(TreeNode root) {
//         int depth = 1;
//         maxD(root,depth);
//         return answer;
//     }
//     void maxD(TreeNode root,int depth)
//     {
//         if(root==null)
//             return;
        
//         if(root.left==null && root.right==null)
//             answer = Math.max(answer,depth);
        
//         maxD(root.left,depth+1);
//         maxD(root.right,depth+1);
//         return;
//     }
// }


//BOTTOM UP APPROACH
class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root==null)
            return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth,rightDepth)+1;
    }
}