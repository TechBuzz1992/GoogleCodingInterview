package Day_0124;

import java.util.Map;

class HouseRobberIII{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.value, rob(root.left) + rob(root.right));
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.value, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    private int[] robSub2(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub2(root.left);
        int[] right = robSub2(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.value + left[0] + right[0];

        return res;
    }
}