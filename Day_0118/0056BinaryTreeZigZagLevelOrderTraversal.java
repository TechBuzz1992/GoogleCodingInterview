package Day_0118;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class BinaryTreeZigZagLevelOrderTraversal{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> zigZagLevelOrder(BinaryTreeLevelOrderTraversal.TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        ArrayDeque<BinaryTreeLevelOrderTraversal.TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftToRight = true;
        while(queue.size()>0){
            int queueSize = queue.size();
            List<Integer> newLevel = new ArrayList<>();
            for(int i = 0;i<queueSize;i++){
                BinaryTreeLevelOrderTraversal.TreeNode currentNode = queue.pop();
                if(leftToRight){
                    newLevel.add(currentNode.value);
                } else{
                    newLevel.add(0, currentNode.value);
                }

                if(currentNode.left!=null) queue.add(currentNode.left);
                if(currentNode.right!=null) queue.add(currentNode.right);
            }
            result.add(newLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}