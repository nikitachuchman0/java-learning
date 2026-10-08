package schildt.generics;

import java.util.Comparator;

public class ByPriceDescComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Double.compare(o2.getPrice(), o1.getPrice());
    }
}
