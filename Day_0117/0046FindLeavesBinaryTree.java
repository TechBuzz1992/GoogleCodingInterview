package Day_0117;

import java.util.ArrayList;
import java.util.List;

class FindLeavesBinaryTree {
  public List<List<Integer>> findLeaves(TreeNode node) {
    List<List<Integer>> leavesList = new ArrayList<>();
    List<Integer> leaves = new ArrayList<>();
    while(node!=null){
      if(isLeaves(node, leaves)) node = null;
      leavesList.add(leaves);
      leaves = new ArrayList<>();
    }
    return leavesList;
  }

  private boolean isLeaves(TreeNode node, List<Integer> leaves) {
    if(node.left == null && node.right == null){
      leaves.add(node.val);
      return true;
    }
    if(node.left!=null){
      if(isLeaves(node.left, leaves)) node.left = null;
    }
    if(node.right!=null){
      if(isLeaves(node.right, leaves)) node.right = null;
    }

    return false;
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
