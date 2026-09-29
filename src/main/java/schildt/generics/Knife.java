package schildt.generics;

public class Knife extends Skin {

    public Knife(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Knife{" +
                "price=" + getPrice() +
                '}';
    }
}
