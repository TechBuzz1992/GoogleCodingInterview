package Day_0117;

import java.util.Stack;

class HasRootToLeafPathWithGivenSum{
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int value) {
            this.val = value;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean hasPathWithGivenSum(TreeNode node, int sum){
        if(node == null){
            return false;
        }
        Stack<Integer> sumStack = new Stack<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(node);
        sumStack.push(node.val);

        while(!nodeStack.isEmpty()){
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();
            if(currentNode.left == null && currentNode.right == null && currentSum == sum){
                return true;
            }
            if(currentNode.left!=null){
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum + currentNode.left.val);
            }
            if(currentNode.right!=null){
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum + currentNode.right.val);
            }
        }
        return false;
    }

}