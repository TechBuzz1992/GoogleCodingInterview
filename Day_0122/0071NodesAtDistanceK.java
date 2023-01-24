package Day_0122;

import java.util.*;

class NodesAtDistanceK{
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> distanceKNodes(TreeNode root, TreeNode target, int k){
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int currentLevel = 0;
        while(queue.size()>0){
            int size = queue.size();
            if(currentLevel == k) break;
            currentLevel++;
            for(int i = 0;i<size;i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null && visited.get(currentNode.left) == null){
                    queue.offer(currentNode.left);
                    visited.put(currentNode.left, true);
                }
                if(currentNode.right!=null && visited.get(currentNode.right) == null){
                    queue.offer(currentNode.right);
                    visited.put(currentNode.right, true);
                }
                if(parents.get(currentNode)!=null && visited.get(parents.get(currentNode))==null){
                    queue.offer(parents.get(currentNode));
                    visited.get(parents.get(currentNode));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(queue.size()>0){
            TreeNode currentNode = queue.poll();
            result.add(currentNode.value);
        }
        return result;
    }

    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()>0){
            TreeNode currentNode = queue.poll();
            if(currentNode.left!=null){
                parents.put(currentNode.left, currentNode);
                queue.offer(currentNode.left);
            }
            if(currentNode.right!=null){
                parents.put(currentNode.right, currentNode);
                queue.offer(currentNode.right);
            }
        }
    }

}