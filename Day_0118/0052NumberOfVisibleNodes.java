package Day_0118;

class NumberOfVisibleNode{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public int countVisibleNodes(TreeNode root){
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root,int maxSoFar){
        if(root == null) return 0;
        int total = 0;
        if(root.value >= maxSoFar) total++;

        total += dfs(root.left, Math.max(root.value, maxSoFar));
        total += dfs(root.right, Math.max(root.value, maxSoFar));

        return total;
    }

}