package schildt.generics;

import java.util.Objects;

public class Pair <K,V>{
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        Objects.requireNonNull(key, "Key must be not null!");
        Objects.requireNonNull(value,"Value must be not null!");
        this.key = key;
        this.value = value;
    }

    public Pair<V,K> swap (){
        return new Pair<>(value, key);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
