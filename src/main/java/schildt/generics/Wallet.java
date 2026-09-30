package schildt.generics;

import java.util.Arrays;
import java.util.Objects;

public class Wallet<T extends Number> {
    private final T[] nums;
    private static final double EPSILON = 1e-9;

    /**
     * @throws NullPointerException if nums is null or have null element
     */
    public Wallet(T[] nums) {
        Objects.requireNonNull(nums, "nums must not be null!");

        T[] copyOfNums = Arrays.copyOf(nums, nums.length);

        int indexNull = indexOfFirstNull(copyOfNums);
        if (indexNull != -1) {
            throw new NullPointerException("Array has null elements! index of first null: " + indexNull);
        }
        this.nums = copyOfNums;
    }

    /**
     *
     * @param array
     * @return index of first null element or -1 if array does not have any null elements
     */
    private int indexOfFirstNull(T[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) return i;
        }

        return -1;
    }


    public double total() {
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }

        return sum;
    }

    public boolean isSameTotal(Wallet<?> /* нужно именно ? потому что мы смлжем не привязывться к конкретному типу который указан в этом классе при создании */ other) {
        if (other == null) throw new NullPointerException("other is null!");
        if (this == other)
            return true; // тут думал вставлять ли доп иф что бы сразу отскчь и дать елс что бы не заходить в метод и не перещитывать среднию

        return Math.abs(this.total() - other.total()) < EPSILON;
    }


    public static String describe(Object o) {
        if (o instanceof Wallet<?>) //java: java.lang.Object cannot be safely cast to schildt.generics.Wallet<java.lang.Integer> ошибка изза стирания типов джава не может узнать какой параметр типа может быть указан но мы можем точно узнать класс во время выподнения
        {
            return "wallet, total = " + ((Wallet<?>) o).total();
        } else {
            return "unknown";
        }
    }


}
