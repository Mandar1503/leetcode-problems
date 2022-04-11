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

//RECURSIVE APPROACH
class Solution {
    List<List<Integer>> levels = new LinkedList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root==null)          //IF EMPTY TREE
            return levels;
        bfs(root, 0);           //CALL TO BFS
        return levels;
    }
    
    private void bfs(TreeNode node, int level)
    {
        if(node==null)
            return;
        if(levels.size()==level)                    //IF LEVEL.SIZE IS 1 LESS THAN CURR LEVEL
            levels.add(new LinkedList<Integer>());  //ADD A NEW LIST
        
        levels.get(level).add(node.val);            //ADD THE NODE VALUE IN ITS LEVEL LIST
        
        //if(node.left!=null)                         //LOOK FOR LEFT CHILD AND CALL IT RECURSIVELY
            bfs(node.left,level+1);
        //if(node.right!=null)
            bfs(node.right,level+1);                //LOOK FOR RIGHT CHILD AND CALL IT RECURSIVELY
    }
}

//ITERATIVE SOLUTION USING QUEUE
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
        
//         List<List<Integer>> levels = new LinkedList<>();
//         Queue<TreeNode> q = new LinkedList<>();
        
//         if(root==null)                              //IF TREE IS EMPTY
//             return levels;
        
//         int level = 0;                              //LEVELS = 0
//         q.add(root);                                //ADD ROOT INTO Q
        
//         while(!q.isEmpty())                         //UNTIL Q EMPTY
//         {                                           
//             levels.add(new LinkedList<Integer>());  //CREATE A NEW SUBLIST IN LEVELS
//             int qsize = q.size();                   
//             for(int i=0;i<qsize;i++)                //ITERATE FOR LOOP TO ENTER ALL THE ELEMENTS ON THE LEVEL IN ANS BY RUNNING IT FOR Q.SIZE
//             {
//                 TreeNode node = q.remove();         //USE REMOVE() TO REMOVE FROM FRONT
//                 levels.get(level).add(node.val);    //ADD IT TO ITS LEVELS LIST
                
//                 if(node.left!=null)                 //PUSH LEFT CHILD IN Q IF EXISTS
//                     q.add(node.left);
//                 if(node.right!=null)
//                     q.add(node.right);              //PUSH RIGHT CHILD IN Q IF EXISTS
//             }
//             level++;                                //IMPO = INCR LEVEL
//         }
//         return levels;
//     }
// }