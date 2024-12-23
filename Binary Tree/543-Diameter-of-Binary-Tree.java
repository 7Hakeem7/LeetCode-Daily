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
    int maxi = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        maxi = 0;
        height(root);
        return maxi;
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        //keep moving to left
        int left = height(root.left);
        //keep moving to right
        int right = height(root.right);
        //cal the maximum of diameter till this node(i.e.;till below this node including this node)
        maxi = Math.max(maxi , left + right);
        return 1 + Math.max(left , right);
    }
}