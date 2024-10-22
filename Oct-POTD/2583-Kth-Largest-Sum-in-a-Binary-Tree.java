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

    // TC: O(nlogn)
    // SC: O(n)
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a,b)->a>b ? -1 : 1);
        if(root==null){
            return 0;
        }
        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.offer(root);
        while(!levelQ.isEmpty()){
            final int n = levelQ.size();
            long currLevelSum = 0;
            for(int i=0;i<n;i++){
                TreeNode currNode = levelQ.poll();
                currLevelSum+=currNode.val;
                if(currNode.left!=null){
                    levelQ.offer(currNode.left);
                }
                if(currNode.right!=null){
                    levelQ.offer(currNode.right);
                }
            }
            maxHeap.offer(currLevelSum);
        }
        long kthLargest = 0;
        int i=1;
        if(maxHeap.size()<k){
            return -1;
        }
        while(i<=k){
            kthLargest = maxHeap.poll();
            i++;
        }
        return kthLargest;
    }
}