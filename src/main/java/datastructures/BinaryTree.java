package datastructures;

import java.util.*;

public class BinaryTree<K extends Comparable<K>, V> {

    Node<K, V> root;
    private int size;
    private final Comparator<K> defoultComparator;

    public BinaryTree(Comparator<K> comparator) {
        if (comparator != null) {
            defoultComparator = comparator;
        } else {
            defoultComparator = null;
        }
        this.size = 0;
    }

    public V find(K key) {
        if (key == null) throw new NullPointerException("Root is Null!");
        ;

        if (root == null) return null;

        Node<K, V> current = root;

        while (current != null) {
            int cmp = compareElements(key, current.key);

            if (cmp == 0) {
                return current.value;
            } else if (cmp > 0) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        return null;
    }

    public boolean insert(K key, V value) {
        if (key == null) return false;

        Node<K, V> newNode = new Node<>(key, value);

        if (root == null) {
            root = newNode;
            size++;
            return true;
        }

        Node<K, V> current = root;
        Node<K, V> parent;

        while (true) {

            parent = current;

            if (compareElements(key, current.key) >= 0) {
                current = current.rightChild;
                if (current == null) {

                    parent.rightChild = newNode;
                    size++;
                    return true;

                }
            } else {

                current = current.leftChild;
                if (current == null) {

                    parent.leftChild = newNode;
                    size++;
                    return true;

                }

            }
        }
    }

    public boolean delete(K key) {
        Objects.requireNonNull(key, "key is null!");

        Node<K, V> current = this.root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (compareElements(key, current.key) == 0) {
            parent = current;

            if (compareElements(key, current.key) < 0) {

                isLeftChild = true;
                current = current.leftChild;

            } else {

                isLeftChild = false;
                current = current.rightChild;

            }

            if (current == null) return false;
        }

        if (current.leftChild == null && current.rightChild == null) {

            if (current == this.root) {
                this.root = null;
            }

            if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

        } else if (current.leftChild == null) {
            if (current == this.root) {
                root = current.rightChild;
            }

            if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }

        } else if (current.rightChild == null) {
            if (current == this.root) {
                root = current.leftChild;
            }

            if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }

//   доделать

        return true;
    }

    private int compareElements(K firstValue, K secondValue) {
        if (defoultComparator != null) {
            return defoultComparator.compare(firstValue, secondValue);
        } else {
            return firstValue.compareTo(secondValue);
        }
    }

    public List<K> preOrder() {
        List<K> list = new ArrayList<>(size);
        preOrderInner(this.root, list);
        return list;
    }

    private void preOrderInner(Node<K, V> node, List<K> list) {
        if (node == null) return;

        list.add(node.key);
        preOrderInner(node.leftChild, list);
        preOrderInner(node.rightChild, list);

    }

    public List<K> inOrder() {
        List<K> list = new ArrayList<>(size);
        inOrderInner(this.root, list);
        return list;
    }

    private void inOrderInner(Node<K, V> node, List<K> list) {
        if (node == null) return;

        inOrderInner(node.leftChild, list);
        list.add(node.key);
        inOrderInner(node.rightChild, list);

    }

    public List<K> postOrder() {
        List<K> list = new ArrayList<>(size);
        postOrderInner(this.root, list);
        return list;
    }

    private void postOrderInner(Node<K, V> node, List<K> list) {
        if (node == null) return;

        postOrderInner(node.leftChild, list);
        postOrderInner(node.rightChild, list);

        list.add(node.key);

    }


    public List<K> inOrderIterative(){
        Deque<Node<K,V>> stack = new ArrayDeque<>();
        List<K> result = new ArrayList<>(this.size);
        Node<K,V> current = this.root;

        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                current = current.leftChild;
            }
            else {
                current = stack.pop();
                result.add(current.key);
                current = current.rightChild;
            }
        }

        return result;
    }


    public List<K> preOrderIterative(){
        Deque<Node<K,V>> stack = new ArrayDeque<>();
        List<K> result = new ArrayList<>(this.size);
        Node<K,V> current = this.root;

        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                result.add(current.key);
                current = current.leftChild;
            }
            else {
               current =  stack.pop();
                current = current.rightChild;
            }
        }

        return result;
    }


    public V max() {
        if (this.root == null) return null;

        Node<K, V> current = this.root;

        while (current != null) {
            if (current.rightChild == null) {
                return current.value;
            }

            current = current.rightChild;
        }

        return null;

    }

    public V min() {
        if (this.root == null) return null;

        Node<K, V> current = this.root;

        while (current != null) {
            if (current.leftChild == null) {
                return current.value;
            }

            current = current.leftChild;
        }

        return null;
    }


    private class Node<K, V> {
        private final K key;
        private final V value;
        private Node<K, V> leftChild;
        private Node<K, V> rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        public Node(Node<K, V> oldNode, Node<K, V> leftChild, Node<K, V> rightChild) {
            this.key = oldNode.key;
            this.value = oldNode.value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", key=" + key + '}';
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
