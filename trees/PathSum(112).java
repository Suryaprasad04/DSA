class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, 0, targetSum);
    }
    private boolean hasPathSumHelper(TreeNode root,int sum,int target){
        if(root==null)
            return false;
        sum+=root.val;
        if(root.left==null && root.right==null){
            return sum==target;
        }
        return  hasPathSumHelper(root.left,sum, target)|| hasPathSumHelper(root.right, sum, target);
    }
}
