package schildt.generics;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


public class CollectionUtils {


    private CollectionUtils() {}

    /**
     * Returns the largest element of the list.
     *
     * @param list The list must not be null or empty.
     * @throws NullPointerException if the {@code list} or any of its elements is null
     * @throws NoSuchElementException if {@code list.isEmpty()} is true
     * @return the largest element of the list
     */
    public static <T extends Comparable<? super T>> T max(List<T> list) {
        Objects.requireNonNull(list,"List must not be null!");
        if (list.isEmpty()) throw new NoSuchElementException("List has no elements!");

        T biggest = list.getFirst();

        for (T el : list) {
            Objects.requireNonNull(el,"List has null element!");

            if (el.compareTo(biggest) > 0) {
                biggest = el;
            }
        }

        return biggest;
    }
}
