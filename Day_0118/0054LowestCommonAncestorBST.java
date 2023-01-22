package Day_0118;

class LowestCommonAncestorBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public int lcaOfBST(TreeNode root, int p, int q){
        if(p<root.value && q<root.value){
            return lcaOfBST(root.left, p, q);
        } else if(p>root.value && q>root.value){
            return lcaOfBST(root.right,p, q);
        } else{
            return root.value;
        }
    }
}