package Day_0121;

import java.util.ArrayList;
import java.util.List;

class DirectionsFromOneNodeToAnotherNode{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public String getDirections(TreeNode root, int startValue, int endValue){
        TreeNode ancestor = lowestCommonAncestor(root, startValue, endValue);

        List<String> toStart = new ArrayList<>();
        getDirection(ancestor, startValue, toStart);

        List<String> toEnd = new ArrayList<>();
        getDirection(ancestor, endValue, toEnd);

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<toStart.size();i++) sb.append("U");

        for(String s : toEnd) sb.append(s);

        return sb.toString();
    }

    private boolean getDirection(TreeNode ancestor, int value, List<String> steps) {
        if(ancestor == null) return false;

        if(ancestor.value == value) return true;

        steps.add("L");
        if(getDirection(ancestor.left, value, steps)) return true;
        steps.remove(steps.size()-1);

        steps.add("R");
        if(getDirection(ancestor.right, value, steps)) return true;
        steps.remove(steps.size()-1);

        return false;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int startValue, int endValue) {
        if(root == null || root.value == startValue || endValue == root.value) return root;

        TreeNode left = lowestCommonAncestor(root.left, startValue, endValue);

        TreeNode right = lowestCommonAncestor(root.right, startValue, endValue);

        if(left!=null && right!=null)
            return root;
        else
            return left == null ? right : left;
    }
}