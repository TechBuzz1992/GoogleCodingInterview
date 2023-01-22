package Day_0117;

class BinaryTreeSearch{
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }

    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root == null) return root;
        if(root.val == val){
            return root;
        }
        else{
            return val<root.val ?
                    searchBSTRecursive(root.left,val) :
                    searchBSTRecursive(root.right,val);
        }
    }
}