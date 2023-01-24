package Day_0122;

class UniValuedBinaryTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public boolean isUniValuedTree(TreeNode root){
        return isSame(root, root.value);
    }

    private boolean isSame(TreeNode root, int value){
        if(root == null) return true;
        if(root.value !=value) return false;

        boolean left = isSame(root.left, value);
        boolean right = isSame(root.right, value);

        return left && right;
    }
}