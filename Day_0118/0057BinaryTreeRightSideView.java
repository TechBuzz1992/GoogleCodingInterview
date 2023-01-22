package Day_0118;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class BinaryTreeRightSideView{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0){
            int n = queue.size();
            res.add(queue.peek().value);
            for(int i = 0;i<n;i++){
                TreeNode currentNode = queue.pop();
                if(currentNode.right!=null) queue.add(currentNode.right);
                if(currentNode.left!=null) queue.add(currentNode.left);
            }
        }
        return res;

    }

}