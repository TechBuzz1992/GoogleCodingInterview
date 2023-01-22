package Day_0118;

class MaxDepthOfTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }
    public int maxDepth(TreeNode node){
        if(node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
    }
}