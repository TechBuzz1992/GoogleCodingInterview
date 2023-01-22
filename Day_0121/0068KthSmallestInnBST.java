package Day_0121;

import java.util.Stack;

class KthSmallestInBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(k!=0){
            TreeNode current = stack.pop();
            k--;
            if(k == 0) return current.value;
            TreeNode rightNode = current.right;
            while(rightNode!=null){
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return -1;
    }
}