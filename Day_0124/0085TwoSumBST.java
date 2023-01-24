package Day_0124;

import java.util.ArrayList;
import java.util.List;

class TwoSumBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    private void inOrderTraversal(IncreasingOrderSearchTree.TreeNode root, List<Integer> values){
        if(root == null) return;
        inOrderTraversal(root.left, values);
        values.add(root.value);
        inOrderTraversal(root.right, values);
    }

    public boolean findTarget(TreeNode root, int target){
        List<Integer> values = new ArrayList<>();
        if(root == null) return false;
        int low = 0;
        int high = values.size() - 1;
        while(low<high){
            int sum = values.get(low) + values.get(high);
            if(target == sum) return true;
            if(sum > target) high--;
            else low++;
        }
        return false;
    }
}