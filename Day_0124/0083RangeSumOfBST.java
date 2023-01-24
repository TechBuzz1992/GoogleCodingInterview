package Day_0124;

class RangeSumOfBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public int rangeSumOfBST(TreeNode root, int low, int high){
        int sum = 0;
        helper(root, low, high, sum);
        return sum;
    }

    private void helper(TreeNode root, int low, int high, int sum){
        if(root == null) return;
        if(root.value<=high && root.value>=low){
            sum += root.value;
        }
        helper(root.right, low, high, sum);
        helper(root.left, low, high, sum);
    }

}