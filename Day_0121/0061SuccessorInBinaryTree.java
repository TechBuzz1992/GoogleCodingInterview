package Day_0121;

class SuccessorInBinaryTree{
    class TreeNode{
        int value;
        TreeNode right;
        TreeNode left;
    }

    public TreeNode successor(TreeNode root, TreeNode p){
        TreeNode res = null;
        while(root!=null){
            if(root.value > p.value){
                res = root;
                root = root.left;
            } else{
                root = root.right;
            }
        }
        return res;
    }
}