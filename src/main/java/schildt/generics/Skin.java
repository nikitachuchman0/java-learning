package schildt.generics;

import java.util.List;

public class Skin extends Item{
    public Skin(double price) {
        super(price);
    }


    public static void addStarterSkins(List<? super Skin> dest){ /* писать: Skin и его наследников (Knife) ✅   Item ❌ — вдруг это List<Skin>?
                                                                    читать: только Object — вдруг это List<Object>? */
        if (dest == null) throw new NullPointerException("Array is Null, cant add starter skins!");

        dest.add(new Skin(12.3));
        dest.add(new Knife(123.3));
        dest.add(new Knife(98.9));
        // при чтении из листа мы получаем object потому что это наша верхняя граница
    }


    @Override
    public String toString() {
        return "Skin{" +
                "price=" + getPrice() +
                '}';
    }
}
