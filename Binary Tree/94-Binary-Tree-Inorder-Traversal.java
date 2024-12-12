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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //left -> root -> right
        //if the node is not null
        //we will pe pushing node onto the stack
        //and keep on going left
        //if the curr node is null
        //assign the curr node the top stack node
        //we will add to loist the top of stack(left most done)
        //now we will go to right of curr node

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        
        while(true){
            
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}