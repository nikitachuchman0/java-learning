package dataStructuries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class MyLinkedList <T> implements Iterable<T>{

    Node<T> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }


    public void add(T item){
        Objects.requireNonNull(item);

        head = new Node<>(item, head);
        size++;

    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIter();
    }

    public class LinkedListIter implements Iterator<T>{
        Node<T> current;

        private LinkedListIter() {
            this.current = head;
        }

        public boolean hasNext (){
            return current != null;
        }

        public T next(){
            if (!hasNext()) throw new RuntimeException();

            T temp = current.value;
            current = current.next;
            return temp;
        }

    }


    private class Node<T>{
       private final T value;
        private final Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }
    }
}




