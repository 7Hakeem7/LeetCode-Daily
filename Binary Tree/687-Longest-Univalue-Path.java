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
    private int longestPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longestPath;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        int leftPath = 0, rightPath = 0;

        if(root.left != null && root.left.val == root.val){
            leftPath = leftLen + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rightPath = rightLen + 1;
        }

        longestPath = Math.max(longestPath , leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }
}