package Day_0124;

import java.util.ArrayList;
import java.util.List;

class IncreasingOrderSearchTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
        }
    }

    public TreeNode increasingOrderTree(TreeNode root){
        List<Integer> values = new ArrayList<>();
        if(root == null) return null;
        inOrderTraversal(root, values);
        TreeNode dummy = new TreeNode(-1);
        TreeNode currentNode = dummy;
        for(int value : values){
            currentNode.right = new TreeNode(value);
            currentNode = currentNode.right;
        }
        return dummy.right;

    }

    private void inOrderTraversal(TreeNode root, List<Integer> values){
        if(root == null) return;
        inOrderTraversal(root.left, values);
        values.add(root.value);
        inOrderTraversal(root.right, values);
    }
}