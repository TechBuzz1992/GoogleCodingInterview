package Day_0121;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class IterativePreOrderTraversal{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.removeLast();
            result.add(currentNode.value);
            if(currentNode.right!=null){
                stack.add(currentNode.right);
            }
            if(currentNode.left!=null){
                stack.add(currentNode.left);
            }
        }
        return result;
    }
}