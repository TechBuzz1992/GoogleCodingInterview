package Day_0121;

class PredecessorInBinaryTree{
    class TreeNode{
        int value;
        TreeNode right;
        TreeNode left;
    }

    public TreeNode predecessor(TreeNode root, TreeNode p){
        if(root == null) return null;
        if(root.value>p.value)
            return predecessor(root.left, p);
        TreeNode right = predecessor(root.right, p);
        return right == null  ? root : right;
    }
}