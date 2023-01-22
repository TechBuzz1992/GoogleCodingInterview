package Day_0117;


import java.util.List;

class TreeTraversals{
     class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int value){
            this.val = value;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void preOrderTraversal(TreeNode root, List<Integer> list){
         if(root!=null){
             list.add(root.val);
             if(root.left!=null){
                 preOrderTraversal(root.left, list);
             }
             if(root.right!=null){
                 preOrderTraversal(root.right, list);
             }
         }
    }

    public void postOrderTraversal(TreeNode root, List<Integer> list){
         if(root!=null){
             if(root.left!=null){
                 postOrderTraversal(root.left, list);
             }
             if(root.right!=null){
                 postOrderTraversal(root.right, list);
             }
             list.add(root.val);
         }
    }

    public void inOrderTraversal(TreeNode root, List<Integer> list){
         if(root!=null){
             if(root.left!=null){
                 inOrderTraversal(root.left, list);
             }
             list.add(root.val);
             if(root.right!=null){
                 inOrderTraversal(root.right, list);
             }
         }
    }

}