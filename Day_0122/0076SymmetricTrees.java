package Day_0122;

class SymmetricTrees{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.value!=right.value){
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}