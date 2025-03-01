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
    public int maxDepth(TreeNode root) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return 0;
        q.add(root);// 15 7

        while(!q.isEmpty()){
            int qlen = q.size();//2
            for(int i = 0; i < qlen; i++){
                TreeNode currNode = q.poll();// 7
                if(currNode.left != null)q.add(currNode.left);
                if(currNode.right != null)q.add(currNode.right);
            }
            count++;//3
        }
        return count;
    }
}