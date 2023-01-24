package Day_0124;

import java.util.ArrayList;
import java.util.List;

class InorderSuccessorBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> values){
        if(root == null) return;
        inOrderTraversal(root.left, values);
        values.add(root);
        inOrderTraversal(root.right, values);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode node){
        List<TreeNode> nodes = new ArrayList<>();
        if(root == null) return null;
        for(int i = 0;i<nodes.size();i++){
            if(nodes.get(i) == node && i<nodes.size()-1){
                return nodes.get(i+1);
            }
        }
        return null;
    }

}