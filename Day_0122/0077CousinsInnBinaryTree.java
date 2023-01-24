package Day_0122;

class CousinsInBinaryTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
            this.left = this.right = null;
        }
    }

    public boolean areCousins(TreeNode root, int valueOne, int valueTwo){
        int[] level = {-1, -1};
        int[] parents = {-1, -1};

        findNodes(root, valueOne, valueTwo, parents, level, 0, new TreeNode(-1));
        if(level[0] == level[1] && parents[0]!=parents[2]){
            return true;
        }
        return false;
    }

    private void findNodes(TreeNode root, int valueOne, int valueTwo, int[] parents, int[] level, int currentLevel, TreeNode parent) {
        if(root == null){
            return;
        }
        if(root.value == valueOne){
            level[0] = currentLevel;
            parents[0] = parent.value;
        }

        if(root.value == valueTwo){
            level[1] = currentLevel;
            parents[1] = parent.value;
        }

        findNodes(root.left, valueOne, valueTwo, parents, level, currentLevel+1, root);
        findNodes(root.right, valueOne, valueTwo, parents, level, currentLevel+1, root);

    }

}