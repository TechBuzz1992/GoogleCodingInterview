package Day_0121;

import java.util.ArrayList;
import java.util.List;

class MorrisInorderTraversal{
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
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                result.add(curr.value);
                curr = curr.right;
            } else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                } else{
                    prev.right = null;
                    result.add(curr.value);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}