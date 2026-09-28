package datastructures;


import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class MySingleList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    {
        head = null;
        tail = null;
    }

    public MySingleList() {
    }

    public void add(T item) {
        Objects.requireNonNull(item);

        addInner(item);
    }


    private void addInner(T item) {
        if (head == null) {
            head = new Node<>(item, null);
            tail = head;
        } else {

            tail.next = new Node<>(item, null);
            tail = tail.next;
        }

        size++;

    }


    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> current = head;
        // Просто перепрыгиваем нужное количество раз
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> current = head;
        // Просто перепрыгиваем нужное количество раз
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node<T> temp = current.next.next;

        current.next.next = null;

        current.next = temp;

    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }


    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) && Objects.equals(next, node.next);
        }


    }

    private class MyIterator implements Iterator<T> {

        Node<T> current;

        public MyIterator() {
             current = head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new UnsupportedOperationException();
            }

            T value = current.value;

            current = current.next;

            return value;
        }

        @Override
        public void remove() {
            Node<T> temp = current.next.next;

            current.next.next = null;

            current.next = temp;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Iterator.super.forEachRemaining(action);
        }
    }


}
