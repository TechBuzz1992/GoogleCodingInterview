package Day_0117;

import java.util.ArrayList;
import java.util.List;

class HasPathWithGivenSum {
  public List<List<Integer>> pathSum(TreeNode root, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    pathSumHelper(root, 0, target, new ArrayList<Integer>(), result);
    return result;
  }

  private void pathSumHelper(
      TreeNode root,
      int sumSoFar,
      int target,
      ArrayList<Integer> pathSoFar,
      List<List<Integer>> result) {
    pathSoFar.add(root.val);
    int sum = sumSoFar + root.val;
    ArrayList<Integer> currentPath = new ArrayList<>(pathSoFar);
    if (root.left == null && root.right == null && sumSoFar == target) {
      result.add(currentPath);
    }
    if (root.left != null) {
      pathSumHelper(root.left, sum, target, currentPath, result);
    }
    if (root.right != null) {
      pathSumHelper(root.right, sum, target, currentPath, result);
    }
    pathSoFar.remove(pathSoFar.size() - 1);
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int value) {
      this.val = value;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
