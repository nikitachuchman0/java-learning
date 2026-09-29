package schildt.generics;

import java.util.Comparator;
import java.util.List;

public class Item implements Comparable<Item> {
    private final double price;

    public <T extends Number> Item(T price) {
        this.price = price.doubleValue();
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.price, o.price);
    }


}
