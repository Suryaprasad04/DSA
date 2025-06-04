class Solution {
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int c=count(root);
        int s=sum(root);
        int current = (root.val == (s / c)) ? 1 : 0;
        return  current+ averageOfSubtree(root.left)+ averageOfSubtree(root.right);
    }

    public int count(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+sum(root.left)+sum(root.right);
    }
}
