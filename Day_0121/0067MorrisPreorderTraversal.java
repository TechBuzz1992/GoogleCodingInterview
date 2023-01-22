package Day_0121;

import java.util.ArrayList;
import java.util.List;

class MorrisPreorderTraversal{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> preOrderTraversal(MorrisInorderTraversal.TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        MorrisInorderTraversal.TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                result.add(curr.value);
                curr = curr.right;
            } else{
                MorrisInorderTraversal.TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    result.add(curr.value);
                    prev.right = curr;
                    curr = curr.left;
                } else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

}