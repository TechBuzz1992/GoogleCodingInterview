package Day_0117;

// This BST implementation accepts duplicate values
// leftNode.value <= currentNode.value < rightNode.value
// value <= root-> value goes to left subtree (equal values go to left)
// value < root-> value goes to right subtree

// But if it is (key, value) pair then BST should NOT accept duplicate entries
// rather it should replace the previous value when a new entry with some duplicate
// keys are put in the BST

class Node {
    public Integer value;
    public int size = 1;  //total number of nodes in the subtree
    //with this node as root which includes this node too
    public Node left = null;
    public Node right = null;

    public Node(Integer value) {
        this.value = value;
    }
}


class BST {

    private Node root = null;  //root of BST
    //private int size = 0;
    //we don't need size, since we can get this by invoking root.size

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return size(node.left) + 1 + size(node.right);  //OR // return node.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void insert(int value) {
        if (root == null) {  // OR  //if (isEmpty)
            root = new Node(value);
            return;
        }

        insert(root, value);
    }

    private void insert(Node node, Integer value) {
        int compare = value.compareTo(node.value);

        if (compare > 0) {
            if (node.right != null)     insert(node.right, value);
            else                        node.right = new Node(value);
        }
        if (compare <= 0) {     //equal values go to the left
            if (node.left != null)      insert(node.left, value);
            else                        node.left = new Node(value);
        }

        node.size++;
    }

    public void delete(int value) {
        root = delete(root, value); //delete(root, value) should return root because this way
        //the case in which the root node is deleted is
        //also taken care of
    }

    // Deletes the node and returns the new root (or the old root if the root is unchanged by the delete operation)
    private Node delete(Node node, Integer value) {
        if (node == null) return null;

        int compare = value.compareTo(node.value);

        if (compare > 0) {

            node.right = delete(node.right, value);

        } else if (compare < 0) {

            node.left = delete(node.left, value);

        } else {  //this else part also takes care of deleting root

            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node n = node;
            node = min(n.right);
            node.right = deleteMin(n.right);
            node.left = n.left;

        }

        node.size = node.left.size + 1 + node.right.size;  //the size should be decremented only when
        //the value to be deleted is present in the Tree.
        //so node.size-- is not applicable here
        return node;  //if the root is deleted then the root is updated in the else block
    }

    public void deleteMin() throws Exception {
        if (size() == 0) throw new Exception("Tree is Empty");
        root = deleteMin(root);
    }

    // Deletes Min and returns the root
    public Node deleteMin(Node node) {
        if (node.left == null) return node.right; // short circuit when root is the min
        Node n = node;
        while  (node.left.left != null) {
            node.size--;
            node = node.left;
        }
        node.size--;
        node.left = node.left.right;
        return n;  //returns root
    }

    public int rank(int value) throws Exception {  //rank starts from 1 not 0, in this implementation
        return rank(root.value);
    }

    private int rank(Node node, Integer value) throws Exception {
        if (node == null) throw new Exception("Value not present in the Tree");
        int compare = value.compareTo(node.value);
        if (compare < 0) return rank(node.left, value);
        else if (compare > 0) return node.left.size + 1 + rank(node.right, value);
        else {
            return node.left.size + 1;
        }
    }

    public int select(int index) throws Exception { //index starts from 1 not 0
        if (index < 1 || index > size(root)) throw new Exception("Invalid index");
        return select(root, index);
    }

    private int select(Node node, int index) {
        int rank = node.left.size + 1;
        if (index < rank) return select(node.left, index);
        else if (index > rank) return select(node.right, index - rank);
        else return node.value;
    }

    public Node min() {
        return min(root);
    }
    private Node min(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        else return min(node.left);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) return false;
        if (node.value > value) return contains(node.left, value);
        else if (node.value < value) return contains(node.right, value);
        else return true;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    //Recursive implementation of deleteMin
    public Node deleteMinRECURSIVE(Node node) {
        if (node.left == null) return node.right; // short circuit when root is the min
        node.left = deleteMinRECURSIVE(node.left);
        node.size = node.left.size + 1 + node.right.size;
        return node;
    }


}