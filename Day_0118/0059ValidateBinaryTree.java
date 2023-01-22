package Day_0118;

class ValidateBinaryTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBinaryTree(TreeNode root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int minValue, int maxValue) {
        if(root == null) return true;
        if(root.value<minValue || root.value>maxValue){
            return false;
        }

        return helper(root.left, minValue, root.value) && helper(root.right, root.value, maxValue);
    }


}