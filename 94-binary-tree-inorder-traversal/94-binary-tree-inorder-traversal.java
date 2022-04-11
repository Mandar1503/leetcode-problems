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

//RECURSIVE SOLUTION
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         ArrayList<Integer> l = new ArrayList<>();
//         inorder(root,l);
//         return l;
//     }
    
//     private void inorder(TreeNode root,ArrayList<Integer> l)
//     {
//         if(root==null)
//             return;
        
//         inorder(root.left,l);
//         l.add(root.val);
//         inorder(root.right,l);
//     }
// }

//ITERATIVE APPROACH (FIRST ASSIGN CURR, GO TO LEFT END WHILE ADDING INTO STACK, THEN POP AND PRINT,  GO RIGHT)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;                           //CURR
        
        while(curr!=null || !stack.isEmpty())           
        {
            while(curr!=null)                           //GO LEFT END AND ADD STACK
            {
                stack.add(curr);
                curr=curr.left;
            }
            curr=stack.pop();                           //POP AND PRINT
            l.add(curr.val);    
            curr=curr.right;                            //GO RIGHT
        }
        return l;
    }
}