package dataStructuries;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private T[] array;
    private int size;
    private final static int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T item) {
        Objects.requireNonNull(item, "item is null");

        innerAdd(item);
    }

    public void add(int index, T item) {
        Objects.requireNonNull(index);
        Objects.requireNonNull(item);
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index is above bounds of array!");

        innerAdd(index, item);
    }


    public void innerAdd(int index, T item) {

        if (size == array.length) {
            extendArray();
        }

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = item;

        size++;

    }

    private void innerAdd(T item) {
        if (size == array.length) {
            extendArray();
        }

        array[size++] = item;
    }

    private void extendArray() {
        Arrays.copyOf(array, array.length * 2);
    }


    public T get(int index) {
        if (index < 0 || index >= array.length)
            throw new IndexOutOfBoundsException();

        return array[index];
    }


    public void remove(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();

        removeInner(index);
    }

    private void removeInner(int index) {
        System.arraycopy(array, index + 1, array, index, (size - index) - 1);

        array[--size] = null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,size));

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && Objects.deepEquals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(array), size);
    }
}
