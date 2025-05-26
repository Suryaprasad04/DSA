class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.val == 0 || root.val == 1) {
            return root.val == 1;
        }

        TreeNode parent = root;

        if (parent.val == 3) { // AND
            if (evaluateTree(parent.left) && evaluateTree(parent.right)) {
                return true;
            }
            return false;
        } else if (parent.val == 2) { // OR
            if (evaluateTree(parent.left) || evaluateTree(parent.right)) {
                return true;
            }
            return false;
        }

        return false; // fallback
    }
}
