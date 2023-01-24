package Day_0124;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DiagonalTraversal{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> DiagonalTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            while(curr != null){
                if(curr.left != null)q.offer(curr.left);
                ans.add(curr.value);
                curr = curr.right;
            }
        }
        return ans;
    }
}