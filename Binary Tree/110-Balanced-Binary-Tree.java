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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int maxDepthToLeft = getHeight(root.left);
        int maxDepthToRight = getHeight(root.right);

        if(Math.abs(maxDepthToLeft - maxDepthToRight) > 1)return false;
        boolean tryNextNodeLeft = isBalanced(root.left);
        boolean tryNextNodeRight = isBalanced(root.right);
        if(!tryNextNodeLeft || !tryNextNodeRight)return false;
        else return true;
	}
    private int getHeight(TreeNode root){
        if(root == null)return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left , right);
    }
}