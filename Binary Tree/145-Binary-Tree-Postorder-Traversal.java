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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        func(root , ans);
        return ans;
    }
    private void func(TreeNode currNode , List<Integer> ans){
        if(currNode == null)return;

        func(currNode.left , ans);
        func(currNode.right , ans);
        ans.add(currNode.val);
    }
}