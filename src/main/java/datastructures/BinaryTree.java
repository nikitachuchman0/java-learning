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


    public boolean contains(K key) {
        if (key == null) throw new NullPointerException("Root is Null!");


        if (root == null) return false;

        Node<K, V> current = root;

        while (current != null) {
            int cmp = compareElements(key, current.key);

            if (cmp == 0) {
                return true;
            } else if (cmp > 0) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        return false;
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
        Objects.requireNonNull(key, "Key is null!");
        if (this.root == null) return false;
        Node<K, V> parent = this.root;
        Node<K, V> current = this.root;
        boolean isLeftChild = false;


        while (compareElements(current.key, key) != 0) {

            parent = current;

            if (compareElements(key, current.key) < 0) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }

            if (current == null) return false;
        }


        if (current.leftChild == null && current.rightChild == null) {

            if (this.root == current) {
                this.root = null;
                size--;
                return true;
            }

            if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            size--;
            return true;
        } else if (current.rightChild != null && current.leftChild != null) {
            Node<K, V> parentSuccessor = current;
            Node<K, V> successor = current.rightChild;
//

            if (successor.leftChild != null) {
                while (successor.leftChild != null) {
                    parentSuccessor = successor;
                    successor = successor.leftChild;
                }

                if (this.root == current) {
                    this.root = successor;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                } else {
                    parent.rightChild = successor;
                }

                parentSuccessor.leftChild = successor.rightChild;
                successor.leftChild = current.leftChild;
                successor.rightChild = current.rightChild;
                size--;
                return true;
            } else {
                if (this.root == current) {
                    this.root = successor;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                } else {
                    parent.rightChild = successor;
                }

                successor.leftChild = current.leftChild;

                size--;
                return true;
            }


        } else {

            if (compareElements(current.key, this.root.key) == 0 && current.leftChild != null) {
                this.root = root.leftChild;
                size--;
                return true;
            } else if (compareElements(current.key, this.root.key) == 0 && current.rightChild != null) {
                this.root = root.rightChild;
                size--;
                return true;
            }

            if (isLeftChild && current.leftChild != null) parent.leftChild = current.leftChild;
            else if (isLeftChild && current.rightChild != null) parent.leftChild = current.rightChild;
            else if (!isLeftChild && current.leftChild != null) parent.rightChild = current.leftChild;
            else parent.rightChild = current.rightChild;

            size--;
            return true;
        }

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


    public List<K> inOrderIterative() {
        Deque<Node<K, V>> stack = new ArrayDeque<>();
        List<K> result = new ArrayList<>(this.size);
        Node<K, V> current = this.root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.leftChild;
            } else {
                current = stack.pop();
                result.add(current.key);
                current = current.rightChild;
            }
        }

        return result;
    }


    public List<K> preOrderIterative() {
        Deque<Node<K, V>> stack = new ArrayDeque<>();
        List<K> result = new ArrayList<>(this.size);
        Node<K, V> current = this.root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                result.add(current.key);
                current = current.leftChild;
            } else {
                current = stack.pop();
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


    public int getSize() {
        return size;
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

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value) && Objects.equals(leftChild, node.leftChild) && Objects.equals(rightChild, node.rightChild);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value, leftChild, rightChild);
        }
    }
}
