package Day_0124;

class InsertInBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.value = val;
        }
    }

    public TreeNode insert(TreeNode root, int value){
        if(root == null) return new TreeNode(value);
        if(root.value < value){
            root.right = insert(root.right, value);
        } else{
            root.left = insert(root.left, value);
        }
        return root;

    }
}