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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        root.val = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            map = new HashMap<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                map.put(cur, new ArrayList<>());
                if(cur.left != null) {
                    sum += cur.left.val;
                    q.add(cur.left);
                    map.get(cur).add(cur.left.val);
                }
                if(cur.right != null) {
                    sum += cur.right.val;
                    q.add(cur.right);
                    map.get(cur).add(cur.right.val);
                }
            }
            for(Map.Entry<TreeNode,List<Integer>> entry : map.entrySet()) {
                if(entry.getValue().size() == 2) {
                    int num = entry.getValue().get(0)+entry.getValue().get(1);
                    entry.getKey().left.val = sum - num;
                    entry.getKey().right.val = sum - num;
                } else if(entry.getValue().size() == 1) {
                    if(entry.getKey().left != null) entry.getKey().left.val = sum - entry.getValue().get(0);
                    else if(entry.getKey().right != null) entry.getKey().right.val = sum - entry.getValue().get(0);
                }
            }
        }
        return root;
    }
}