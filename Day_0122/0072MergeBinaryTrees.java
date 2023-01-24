package Day_0122;

class MergeBinaryTrees{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
            this.left = this.right = null;
        }
    }

    public TreeNode mergeTrees(TreeNode rootOne, TreeNode rootTwo){
        return merge(rootOne, rootTwo);
    }

    private TreeNode merge(TreeNode rootOne, TreeNode rootTwo){
        if(rootOne == null && rootTwo == null) return null;
        if(rootOne == null) return rootTwo;
        if(rootTwo == null) return rootOne;

        TreeNode root = new TreeNode(rootOne.value + rootTwo.value);
        root.left = merge(rootOne.left, rootTwo.left);
        root.right = merge(rootOne.right, rootTwo.right);

        return root;
    }

}