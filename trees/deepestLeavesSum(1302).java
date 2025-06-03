class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=maxDepth(root);
        return sumTillDepth(root,depth,1);
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;

        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public int sumTillDepth(TreeNode root,int targetDepth,int currentDepth){
        if(root==null){
            return 0;
        }
        if(currentDepth==targetDepth){
            return root.val;// If current node is at max depth, add its value
        }
        return sumTillDepth(root.left,targetDepth,currentDepth+1)+sumTillDepth(root.right,targetDepth,currentDepth+1);//go deeper left and right
    }
}
