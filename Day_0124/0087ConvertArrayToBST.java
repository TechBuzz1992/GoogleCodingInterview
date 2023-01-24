package Day_0124;

import java.util.List;

class ConvertArrayToBST{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
        }
    }

    public TreeNode sortedBST(List<Integer> values){
        return convertListToBST(values, 0, values.size()-1);
    }

    private TreeNode convertListToBST(List<Integer> values, int start, int end){
        if(start>end) return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = convertListToBST(values, start, mid-1);
        root.right = convertListToBST(values, mid+1, end);
        return root;
    }
}