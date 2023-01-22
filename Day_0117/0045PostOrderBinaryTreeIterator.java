package Day_0117;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

class PostOrderBinaryTreeIterator implements Iterator<Node> {
    Deque<Node> stack = new ArrayDeque<Node>();

    public PostOrderBinaryTreeIterator(Node root){
        findNextLeafNode(root);
    }

    private void findNextLeafNode(Node node) {
        while(node!=null){
            stack.push(node);
            if(node.left!=null){
                node = node.left;
            }else{
                node = node.right;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        if(!hasNext()){
            throw new NoSuchElementException("All elements are visited!");
        }
        Node next = stack.pop();
        if(!stack.isEmpty()){
            Node top = stack.peek();
            if(next == top.left){
                findNextLeafNode(top.right);
            }
        }
        return next;
    }
}