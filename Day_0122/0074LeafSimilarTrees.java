package Day_0122;

import java.util.ArrayList;
import java.util.List;

class LeafSimilarTrees{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSimilarLeaves(TreeNode rootOne, TreeNode rootTwo){
        List<Integer> rootOneLeaves = new ArrayList<>();
        List<Integer> rootTwoLeaves = new ArrayList<>();

        traversal(rootOne, rootOneLeaves);
        traversal(rootTwo, rootTwoLeaves);

        return rootOneLeaves.equals(rootTwoLeaves);
    }

    private void traversal(TreeNode root, List<Integer> leaves) {
        if(root == null) return;
        if(root.left == null && root.right == null) leaves.add(root.value);

        if(root.left!=null){
            traversal(root.left, leaves);
        }
        if(root.right!=null){
            traversal(root.right, leaves);
        }
    }
}