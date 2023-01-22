package Day_0121;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class IterativeInOrderTraversal{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.value);
            root = root.right;
        }
        return result;
    }
}