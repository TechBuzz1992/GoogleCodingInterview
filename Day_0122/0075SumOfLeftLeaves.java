package Day_0122;

class SumOfLeftLeaves{
    class TreeNode{
        int value;
        TreeNode right;
        TreeNode left;
    }

    public int sumOfLeftLeaves(TreeNode root){
        return leftLeavesSum(root, false);
    }

    private int leftLeavesSum(TreeNode root, boolean leaf) {
        if(root == null) return 0;
        if(root.left == null && root.right == null && leaf){
            return root.value;
        }
        int left = leftLeavesSum(root.left, true);
        int right = leftLeavesSum(root.right, false);

        return left + right;

    }
}