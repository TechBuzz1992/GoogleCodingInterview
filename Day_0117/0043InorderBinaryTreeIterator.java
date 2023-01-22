package Day_0117;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

class InorderBinaryTreeIterator implements Iterator<Node> {
    Deque<Node> stack = new ArrayDeque<>();
    public InorderBinaryTreeIterator(Node root){
        goAllTheWayLeft(root);
    }

    private void goAllTheWayLeft(Node root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        if(!hasNext()){
            throw new NoSuchElementException("All nodes have been visited!");
        }
        Node next = stack.pop();
        goAllTheWayLeft(next.right);
        return next;
    }
}