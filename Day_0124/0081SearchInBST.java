package Day_0124;

class SearchInBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode search(TreeNode root, int target){
        if(root == null) return null;
        if(root.value == target) return root;
        if(root.value<target) return search(root.right, target);
        else return search(root.left, target);
    }
}