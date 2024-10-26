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
    int[] level = new int[1_00_001], depth = new int[1_00_001], d1 = new int[1_00_001], d2 = new int[1_00_001];
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root, 0);
        var res = new int[queries.length];
        for(var i=0; i<queries.length; i++){
            var nodeVal = queries[i];
            var l = level[nodeVal];
            if(depth[nodeVal] == d1[l]){
                res[i] = level[nodeVal] + d2[l] - 1;
            }
            else res[i] = level[nodeVal] + d1[l] - 1;
        }
        return res;
    }
    int dfs(TreeNode node, int l){
        if(node == null) return 0;
        level[node.val] = l;

        var leftDepth = dfs(node.left, l+1);
        var rightDepth = dfs(node.right, l+1);

        depth[node.val] = 1 + Math.max(leftDepth, rightDepth);

        if(depth[node.val] > d1[l]){
            d2[l] = d1[l];
            d1[l] = depth[node.val];
        }
        else if(depth[node.val] > d2[l]) d2[l] = depth[node.val];

        return depth[node.val];
    }
}