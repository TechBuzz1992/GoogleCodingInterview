package Day_0118;

class InvertBinaryTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode invertBinaryTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertBinaryTree(right);
        root.right = invertBinaryTree(left);

        return root;
    }

}