class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symetry(root.left ,root.right);
    }
    private boolean symetry(TreeNode l , TreeNode r){
        if(l == null && r == null)return true;
        if(l == null || r == null)return false;
        if(l.val != r.val)return false;
        return symetry(l.left , r.right) && symetry(l.right , r.left);
    }
}