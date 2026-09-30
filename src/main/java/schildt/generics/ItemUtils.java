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




}
