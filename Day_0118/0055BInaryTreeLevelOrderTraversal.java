package Day_0118;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class BinaryTreeLevelOrderTraversal{
    class TreeNode{
        int value;
        TreeNode right;
        TreeNode left;
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0){
            int queueSize = queue.size();
            List<Integer> newLevel = new ArrayList<>();
            for(int i = 0;i<queueSize;i++){
                TreeNode currentNode = queue.pop();
                newLevel.add(currentNode.value);
                if(currentNode.left!=null) queue.add(currentNode.left);
                if(currentNode.right!=null) queue.add(currentNode.right);
            }
            result.add(newLevel);
        }
        return result;
    }
}