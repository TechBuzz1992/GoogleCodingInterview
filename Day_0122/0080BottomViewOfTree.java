package Day_0122;

import java.util.*;

class BottomViewOfTree{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> bottomViewOfTree(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.peek().node;
            int currentLevel = queue.peek().level;
            queue.poll();
            map.put(currentLevel, currentNode.value);
            if(currentNode.left!=null){
                queue.offer(new Pair(currentNode.left, currentLevel-1));
            }
            if(currentNode.right!=null){
                queue.offer(new Pair(currentNode.right, currentLevel+1));
            }
        }

        result = (ArrayList<Integer>)(map.values());
        return result;
    }

}