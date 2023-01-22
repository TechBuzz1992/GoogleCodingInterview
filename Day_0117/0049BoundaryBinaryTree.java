package Day_0117;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BoundaryBinaryTree{
    List<Integer> leftBoundary;
    List<Integer> rightBoundary;
    List<Integer> leaves;

    public List<Integer> boundaryOfBinaryTree(TreeNode root){
        List<Integer> boundary = new ArrayList<>();
        if(root == null){
            return boundary;
        }

        leftBoundary = new ArrayList<>();
        rightBoundary = new ArrayList<>();
        leaves = new ArrayList<>();

        boundary.add(root.val);
        preOrder(root.left, true, false);
        preOrder(root.right, true, false);

        boundary.addAll(leftBoundary);
        boundary.addAll(leaves);
        Collections.reverse(rightBoundary);
        boundary.addAll(rightBoundary);

        return boundary;
    }

    private void preOrder(TreeNode currentNode, boolean isLeftBoundary, boolean isRightBoundary) {

        if(currentNode!=null){
            if(isLeftBoundary){
                leftBoundary.add(currentNode.val);
            } else if(isRightBoundary){
                rightBoundary.add(currentNode.val);
            } else if(currentNode.left == null && currentNode.right == null){
                leaves.add(currentNode.val);
            }

            preOrder(currentNode.left, isLeftBoundary, isRightBoundary && currentNode.right == null);

            preOrder(currentNode.right, isLeftBoundary && currentNode.left == null, isRightBoundary);
        }
    }

}