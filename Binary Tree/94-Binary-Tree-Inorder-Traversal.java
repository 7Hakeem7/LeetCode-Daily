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
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode currNode = root;
        while(true){
            if(currNode != null){
                st.push(currNode);
                currNode = currNode.left; 
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                currNode = st.pop();
                ans.add(currNode.val);
                currNode = currNode.right;
            }
        }
        return ans;
    }
    
}