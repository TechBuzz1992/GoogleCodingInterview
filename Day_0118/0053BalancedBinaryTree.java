package Day_0118;

class BalancedBinaryTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBalanced(TreeNode root){
        return treeHeight(root)!=-1;
    }

    private int treeHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight)+1;
    }

}