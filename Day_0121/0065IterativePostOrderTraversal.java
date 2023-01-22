package Day_0121;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class IterativePostOrderTraversal{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            result.add(currentNode.value);
            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }
            if(currentNode.right!=null){
                stack.push(currentNode.right);
            }
        }
        return result;
    }
}