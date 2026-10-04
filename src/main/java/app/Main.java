package app;


import datastructures.BinaryTree;
import schildt.generics.Item;
import schildt.generics.Knife;
import schildt.generics.Skin;
import schildt.generics.Wallet;

import java.util.*;

import static schildt.generics.ItemUtils.totalPrice;

public class Main {
    public static void main(String[] args) {

        List<String> strings = createEmptyList();
        strings.add("ddd");
        System.out.println(strings.toString());

        List<String> marketItems = new ArrayList<>(List.of("AK-47", "StatTrack Survival Knife", "AWP", "M4A4"));

        marketItems.set(marketItems.indexOf("StatTrack Survival Knife"), "Sport Gloves");

        System.out.println(marketItems);

        List<String> weekPlan = new ArrayList<>(List.of("Отдых", "Грудь/Бицепс", "Спина/Трицепс", "Ноги", "Отдых", "Кардио"));

        List<String> subList = List.copyOf(weekPlan.subList(1, 4));

        System.out.println(subList);


        List<String> txHistory = new ArrayList<>(List.of("TX-993", "TX-994", "TX-998"));
        List<String> missingTx = List.of("TX-991", "TX-992");

        txHistory.addAll(0, missingTx);
        txHistory.sort(null);
        System.out.println(txHistory);

        ArrayList<String> list = new ArrayList<>(10_000_000);

        for (int i = 0; i <= 100; i++) {
            list.add(String.valueOf(i));
        }

        list.trimToSize();


        ArrayList<Integer> ids = new ArrayList<>(List.of(2, 1, 0));
        ids.remove(1);


        System.out.println(ids);

        ArrayList<String> allPasses = new ArrayList<>(List.of("pass1", "pass3", "pass12", "pass45", "pass433"));
        ArrayList<String> activeToday = new ArrayList<>(List.of("pass12", "pass433"));

        allPasses.removeAll(activeToday);
        System.out.println(allPasses);

        ArrayList<String> names = new ArrayList<>(List.of("Антон", "Борис", "Иван"));

        names.removeIf(str -> str.equals("Борис"));

        LinkedList<String> taskQueue = new LinkedList<>();

        for (int i = 1; i <= 3; i++) {
            taskQueue.addLast("TX-" + i);
        }

        // обьясни почему нельзя использовать !taskQueue.isEmpty() ?
        while (true) {
            var temp = taskQueue.poll();
            if (temp == null) break;
            System.out.println(temp);
        }

        LinkedList<String> undoStack = new LinkedList<>();

        for (int i = 1; i <= 3; i++) {
            undoStack.push("слово" + i);
        }

        System.out.println("top of stack: " + undoStack.peek());


        for (int i = 0; i < 2; i++) {
            System.out.println(undoStack.pop());
        }

        LinkedList<String> recentItems = new LinkedList<>(List.of("Товар А", "Товар Б", "Товар В"));

        recentItems.poll();
        recentItems.push("Товар Г");

        System.out.println(recentItems);

        List<String> list1 = new ArrayList<>(List.of("23", "43", "90", "33"));
        List<String> list2 = new ArrayList<>(List.of("90", "65", "67", "16", "33"));

        Set<String> set = new HashSet<>(list1);
        set.addAll(list2);
        System.out.println(set);


        Set<String> yesterday = new HashSet<>(List.of("A", "B", "C"));
        Set<String> today = new HashSet<>(List.of("B", "C", "D"));

        today.add(null);

        System.out.println(simetrucSet(yesterday, today));

        Object object = "skank";

        System.out.println(object.getClass());

        /// union(13);

        BinaryTree<Integer, String> binaryTree = new BinaryTree<>(null);


        binaryTree.insert(30, "30");
        binaryTree.insert(20, "20");
        binaryTree.insert(20, "20");
        binaryTree.insert(40, "40");
        binaryTree.insert(45435, "45435");
        binaryTree.insert(2, "2");


        System.out.println(binaryTree.insert(35, "35"));


        System.out.println(binaryTree.find(903));

        System.out.println(binaryTree.max());
        System.out.println(binaryTree.min());
        System.out.println(binaryTree.inOrder());

        String rawLog = "tx-monero-901;   TX-MONERO-104;   tx-monero-901 ; tx-bitcoin-200 ; TX-Monero-104 ;   tx-monero-33  ";

        String log = "tx-monero-901;   TX-MONERO-104;   tx-monero-901 ; tx-bitcoin-200 ; TX-Monero-104 ;   tx-monero-33 ; TX-Monero-154 ;    TX-Monero-123 ";
        System.out.println(parseLog(log));


        List<String> list3 = new ArrayList<>();

        //   printAll(list3); // можем передать любой тип на чтение
        //  printObjects(list3);


        List<Item> itemList = new ArrayList<>();
        List<Skin> skinList = new ArrayList<>();
        List<Knife> knifeList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        totalPrice(itemList);
        totalPrice(knifeList);
        totalPrice(skinList);
        // Item.totalPrice(objectList); не скопилиться из-за того что верхняя граница айтем

        Skin.addStarterSkins(itemList);
        Skin.addStarterSkins(skinList);
        Skin.addStarterSkins(objectList);
        //  Skin.addStarterSkins(knifeList); // не скомпилиться потому что нижняя граница это скин


        knifeList = List.of(new Knife(456), new Knife(23), new Knife(11));

        System.out.println(max(knifeList)); /* java: method max in class app.Main cannot be applied to given types;
  required: java.util.List<T>
  found:    java.util.List<schildt.generics.Knife>
  reason: inference variable T has incompatible equality constraints schildt.generics.Item,schildt.generics.Knife
  */
        System.out.println(min(knifeList));

        System.out.println(new Wallet<Integer>(new Integer[0]).getClass() == new Wallet<Double>(new Double[0]).getClass()); // Иде даже подсказывает что всегда будет тереть потому что стирание типов компилятор не знает параметр типа

        Item item = new Item(12);
        Knife knife = new Knife(12);
        item = (Item) knife;

        BinaryTree<Integer,Integer> binaryTree1 = new BinaryTree<>(null);
        BinaryTree<Integer,Integer> emptyBinaryTree = new BinaryTree<>(null);

       List<Integer> list4 = List.of(50, 30, 70, 20, 40);  //, 60, 80, 35

       for (Integer integer : list4){
           binaryTree1.insert(integer,integer);
       }

        System.out.println(binaryTree1.inOrder().equals(binaryTree1.inOrderIterative()));
        System.out.println(emptyBinaryTree.inOrder().equals(emptyBinaryTree.inOrderIterative()));

        System.out.println(binaryTree1.inOrderIterative());

    }


    public static <T extends Comparable<? super T>> int countGreaterThan(List<T> list, T item) {
        if (list == null || item == null) throw new NullPointerException("list or item is null!");
        if (list.isEmpty()) throw new NoSuchElementException("List is Empty!");

        int counter = 0;

        for (T it : list) {
            if (it.compareTo(item) > 0) counter++;
        }

        return counter;
    }

    /**
     *
     * @param <T>
     * @param list
     * @return T
     * @throws NullPointerException when list is null
     * @throws NoSuchElementException when list is empty
     */


    public static <T extends Comparable<? super T>> T max(List<T> list) {
        if (list == null) throw new NullPointerException("List is null!");
        if (list.isEmpty()) throw new NoSuchElementException("List is Empty!");

        T result = null;
        for (T item : list) {
            if (result == null) {
                result = list.getFirst();
                continue;
            }

            if (result.compareTo(item) < 0) {
                result = item;
            }
        }

        return result;
    }

    /**
     *
     * @param <T extends Comparable<? super T>>
     * @param list<T>
     * @return T
     * @throws NullPointerException when list is null
     * @throws NoSuchElementException when list is empty
     */


    public static <T extends Comparable<? super T>> T min(List<T> list) {
        if (list == null) throw new NullPointerException("List is null!");
        if (list.isEmpty()) throw new NoSuchElementException("List is Empty!");

        T result = null;
        for (T item : list) {
            if (result == null) {
                result = list.getFirst();
                continue;
            }

            if (result.compareTo(item) > 0) {
                result = item;
            }
        }

        return result;

    }

    public static <T> void copy(List<? extends T> src, List<? super T> dst) {
        Objects.requireNonNull(src, "List src is null!");
        Objects.requireNonNull(dst, "List dst is null!");

        dst.addAll(src);
    }


    public static void printAll(List<?> list) {
        System.out.println(list);
        // list.add("x"); записывть можем только нал компилятор не знает конкретного параметра типа во время выполнения
    }

    public static void printObjects(List<Object> list) {// так же не передадим сюда лист с другим параметром класа из-за инвариативности
        System.out.println(list); // тут знаю что будет печтать только хеш и класс листа потому что не будет реализации вывода елементов
        list.add("x"); // можем потому что я не знаю разобрать этот момент отдельно в чате без воды простиым языком
    }


    public static <T extends Comparable<T>> T first(T[] arr) {
        return arr[0];
    }

    public static String parseLog(String input) {
        if (input == null || input.isBlank()) return "";


        input = input.toUpperCase();
        Set<Integer> treeSet = new TreeSet<>();
        for (String str : input.split(";")) {
            if (str.contains("MONERO")) {
                str = str.strip();

                str = str.replaceAll("\\D", "");

                treeSet.add(Integer.valueOf(str));
            }

        }

        StringBuilder sb = new StringBuilder("MONERO REPORT: ");

        for (Integer integer : treeSet) {
            sb.append(integer).append(", ");
        }

        if (!treeSet.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();

    }


    public static <T> Set<T> simetrucSet(Set<T> oldSet, Set<T> newSet) {
        Objects.requireNonNull(oldSet);
        Objects.requireNonNull(newSet);

        Set<T> tempOldSet = new HashSet<>(oldSet);
        Set<T> tempNewSet = new HashSet<>(newSet);

        tempOldSet.removeAll(tempNewSet);
        tempNewSet.removeAll(oldSet);
        tempNewSet.addAll(tempOldSet);

        return tempNewSet;
    }


    public static <T> List<T> createEmptyList() {
        return new ArrayList<>();
    }

    // public static <K,V> Map<K,V> zip(List<K> keyList, List<V> valueList)

    public static <T extends Comparable<T>> T findMax(List<T> comparableList) {
        T biggestElement = comparableList.getFirst();
        for (T elemnt : comparableList) {
            if (biggestElement.compareTo(elemnt) < 0) {
                biggestElement = elemnt;
            }
        }

        return biggestElement;
    }


    public static void fillWithIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        System.out.println(list.toString());
    }

    public static void printAllElements(List<? extends Number> Numbers) {
        for (Number numbers : Numbers) {
            int tempValue = numbers.intValue();
            int resultOfCompute = 0;
            for (int i = 1; i <= tempValue; i++) {
                resultOfCompute += i;
            }
            System.out.println("Number: " + tempValue + '\t' + "result: " + resultOfCompute);
        }
    }


}