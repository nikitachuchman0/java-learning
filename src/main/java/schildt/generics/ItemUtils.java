package schildt.generics;

import java.util.List;

public class ItemUtils {
    public static double totalPrice(List<? extends Item> list) { // это продюсер
        if (list == null) return -1;

        double sum = 0;

        for (Item it : list) {
            sum += it.getPrice();
        }

        return sum;
    }

    public static <T extends Item> T max(List<T> list) {
        if (list == null) throw new NullPointerException("List is null!");

        T result = list.getFirst();
        for (T item : list) {
            if (result.compareTo(item) < 0) {
                result = item;
            }
        }

        return result;
    }

    public static <T extends Item> T min(List<T> list) {
        if (list == null) throw new NullPointerException("List is null!");

        T result = list.getFirst();
        for (T item : list) {
            if (result.compareTo(item) > 0) {
                result = item;
            }
        }

        return result;
    }

    public static <T extends Item> int countGreaterThan(List<T> list, T item) {
        if (list == null || item == null) throw new NullPointerException("list or item is null!");

        int counter = 0;

        for (T it : list) {
            if (it.getPrice() > item.getPrice()) counter++;
        }

        return counter;
    }
}
