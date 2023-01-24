package Day_0122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PrintAllNodesHavingNoSiblings{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> nodesHavingNoSiblings(TreeNode root){
        List<Integer> result = new ArrayList<>();
        findNodes(root, result);
        if(result.size() == 0) result.add(-1);
        Collections.sort(result);
        return result;
    }

    private void findNodes(TreeNode root, List<Integer> result){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.left!=null && root.right!=null){
            findNodes(root.left, result);
            findNodes(root.right, result);
        }

        if(root.left!=null){
            result.add(root.left.value);
            findNodes(root.left, result);
        }

        if(root.right!=null){
            result.add(root.right.value);
            findNodes(root.right, result);
        }
    }
}