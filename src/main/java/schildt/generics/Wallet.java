package schildt.generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Wallet <T extends Number> {
   private final T[] nums;



    public Wallet(T[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
    }


    public double total(){
        if (nums == null) return -1.0;

        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }

        return sum ;
    }

    public boolean isSameTotal(Wallet<?> /* нужно именно ? потому что мы смлжем не привязывться к конкретному типу который указан в этом классе при создании */ other ){
        if (other == null) throw new NullPointerException("other is null!");
        if (this == other) return true; // тут думал вставлять ли доп иф что бы сразу отскчь и дать елс что бы не заходить в метод и не перещитывать среднию

        return this.total() == other.total();
    }



   public static String describe(Object o){
        if (o instanceof Wallet<?>) //java: java.lang.Object cannot be safely cast to schildt.generics.Wallet<java.lang.Integer> ошибка изза стирания типов джава не может узнать какой параметр типа может быть указан но мы можем точно узнать класс во время выподнения
        {
            return "wallet, total = " + ((Wallet<?>) o).total();
        }
        else {
            return "unknown";
        }
   }


}
