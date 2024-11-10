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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qt = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();
        if(root == null) return wrapList;
        qt.offer(root);
        while(!qt.isEmpty()){
            int size = qt.size();
            List<Integer> subList = new ArrayList<>();
            for(int i =0 ; i < size ; i++){
                TreeNode node = qt.poll();
                subList.add(node.val);
                if(node.left != null) qt.add(node.left);
                if(node.right != null) qt.add(node.right);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}