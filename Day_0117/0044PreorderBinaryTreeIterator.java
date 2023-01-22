package Day_0117;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

class PreorderBinaryTreeIterator implements Iterator<Node> {
    Deque<Node> stack = new ArrayDeque<>();
    public PreorderBinaryTreeIterator(Node root){
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        if(!hasNext()){
            throw new NoSuchElementException("All Elements have been visited");
        }

        Node next = stack.pop();
        if(next.right!=null){
            stack.push(next.right);
        }
        if(next.left!=null){
            stack.push(next.left);
        }
        return next;
    }
}