package collections;

import java.util.Comparator;

/**
 * Binary Search Tree
 */
public class BinaryTree<T> implements CountableCollection {
    private Comparator<? super T> _comparator;
    private int _size;
    private Node<T> _root;

    /**
     * Creates new instance of BST
     */
    @SuppressWarnings("unchecked")
    public BinaryTree() {
        this(null, (Comparator<T>)Comparator.naturalOrder());
    }

    /**
     * Creates new instance of BST
     */
    public BinaryTree(Comparator<? super T> comparator) {
        this(null, comparator);
    }

    /**
     * Creates new instance of BST
     */
    @SuppressWarnings("unchecked")
    public BinaryTree(Node<T> rootNode) {
        this(rootNode, (Comparator<T>)Comparator.naturalOrder());
    }

    /**
     * Creates new instance of BST
     */
    public BinaryTree(Node<T> rootNode, Comparator<? super T> comparator) {
        _root = rootNode;
        _comparator = comparator;
    }

    public void insert(T data) {
        if (_root == null) {
            _root = new Node<T>(data);
            _size++;
            return;
        }

        Node<T> prevNode = null;
        var currentNode = _root;
        while (currentNode != null) {
            if (_comparator.compare(currentNode.data, data) >= 1) {
                prevNode = currentNode;
                currentNode = currentNode.prev;
            }
            else if (_comparator.compare(currentNode.data, data) <= -1) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        if (_comparator.compare(prevNode.data, data) >= 1) {
            prevNode.prev = new Node<T>(data);
        }
        else if (_comparator.compare(prevNode.data, data) <= -1) {
            prevNode.next = new Node<T>(data);
        }
        _size++;
    }

    public Node<T> getRoot() {
        return _root;
    }

    public int getDepth() {
        return getDepth(_root);
    }

    private int getDepth(Node<T> node) {
        if (node == null) {
            return -1;
        }

        int leftDepth = getDepth(node.prev);
        int rightDepth = getDepth(node.next);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    private String getWhitespaces(int count) {
        var strBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            strBuilder.append(" ");
        }

        return strBuilder.toString();
    }

    @Override
    public String toString() {
        var strBuilder = new StringBuilder();

        return strBuilder.toString();
    }

    @Override
    public boolean isEmpty() {
        return _root == null;
    }

    @Override
    public int size() {
        return _size;
    }
}
