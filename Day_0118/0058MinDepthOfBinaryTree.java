package Day_0118;

import java.util.ArrayDeque;
import java.util.Deque;

class MinDepthOfBinaryTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public int minDepthOfTree(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = -1;
        while(queue.size()>0){
            depth++;
            int n = queue.size();
            for(int i = 0;i<n;i++){
                TreeNode currentNode = queue.pop();
                if(currentNode.left == null && currentNode.right == null){
                    return depth;
                }
                if(currentNode.left!=null) queue.add(currentNode.left);
                if(currentNode.right!=null) queue.add(currentNode.right);
            }
        }
        return depth;
    }
}