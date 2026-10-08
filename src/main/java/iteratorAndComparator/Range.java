package iteratorAndComparator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Range implements Iterable<Integer>{

    private final int from;
    private final int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }



    @Override
    public Iterator<Integer> iterator() {
        return new IteratorRange();
    }


   private   class IteratorRange implements Iterator<Integer>{

       private int cursor;

        public IteratorRange() {
            this.cursor = from;
        }

        @Override
        public boolean hasNext() {
           return cursor < to;
        }

        @Override
        public Integer next() {
            if (hasNext()) return cursor++;
            throw new NoSuchElementException("No next element!");
        }


    }
}
