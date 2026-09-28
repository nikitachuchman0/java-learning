package app;



import datastructures.BinaryTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {


//        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
//
//        for (int i = 0; i < 20; i++) {
//            linkedList.add(i);
//        }
//
//        Iterator<Integer> iterator = linkedList.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }
//
//
//        int[] arr = new int[5];
//        for (int i = 0; i < arr.length; i++) {
//            if (i % 2 == 0) {
//                arr[i] = (i + 5) * 3;
//                continue;
//            }
//
//            arr[i] = i + 3;
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//        //  System.out.println(Arrays.toString(mergeSort.sortMerge(arr)));
//
//
////         int[] array = new Random().ints(1, 1000000000).distinct().limit(99999999).toArray();
////
////         for (int i = 0; i < 30; i++) {
////             System.out.println(array[i]);
////         }
//
//         // ОБЯЗАТЕЛЬНО присваиваем результат переменной array!
////         array = mergeSort.sortMerge(array);
//
//
//        System.out.println(tringle(4));
//
//        System.out.println(factorial(3));
//        System.out.println();
//        raketa(5);
//
//        System.out.println(sum(6));
//
//
//        Knife knife = new Knife("knife 1");
//        Medkit medkit = new Medkit("med kit 1");
//
//        knife.use();
//        medkit.use();
//        Integer a = 127;
//        Integer b = 127;
//        System.out.println(a == b); // Что выведет?
//
//        Integer c = 128;
//        Integer d = 128;
//        System.out.println(c == d); // А что выведет здесь?
//
//    }
//
//
//
//    public static int tringle(int n) {
//        if (n == 1) return n;
//
//        return n + tringle(n - 1);
//    }
//
//    public static int factorial(int n) {
//        if (n < 2) return 1;
//
//        return n * factorial(n - 1);
//
//    }
//
//    public static void raketa(int n) {
//        if (n == 0) {
//            System.out.println("pusk");
//            return;
//        }
//
//        System.out.println(n);
//        raketa(n - 1);
//    }
//
//    public static int sum(int n) {
//        if (n == 1){
//            return n;
//        }
//
//       return n += sum(n - 1);
//


//        List<Dragon> dragonList = List.of(new Dragon("dragon 1", 34), new Dragon("dragon 2", 56), new Dragon("dragon 65", 34), new Dragon("dragon 67", 34),
//                new Dragon("dragon 23", 34), new Dragon("dragon 34", 34));
//
//        makeFlyAll(dragonList);
//
//        List<Number> numberList = new ArrayList<>(List.of(new Double(16.5), new Float(14.5F), new Integer(3)));
//
//        printAllElements(numberList);
//
//        fillWithIntegers(new ArrayList<Number>(5));
//
//
//        List<Integer> integerList = List.of(12, 432, 45465, 3322, 32);
//        copy(integerList, numberList);
//
//        System.out.println(findMax(integerList));

        List<String> strings = createEmptyList();

        strings.add("ddd");
        System.out.println(strings.toString());

        List<String> marketItems = new ArrayList<>(List.of("AK-47", "StatTrak Survival Knife", "AWP", "M4A4"));

        marketItems.set(marketItems.indexOf("StatTrak Survival Knife"), "Sport Gloves");

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

        Object object = "skadjka";

        System.out.println(object.getClass());

        /// nnnn(13);

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

       


    }




    public static <T extends Comparable<T>> T first(T[] arr){
        return arr[0];
    }

    public static String parseLog(String input) {
        if (input == null || input.isBlank()) return "";


        input = input.toUpperCase();
        Set<Integer> treeSet = new TreeSet<>();
        for (String str : input.split(";")){
            if (str.contains("MONERO"))
            {
                str = str.strip();

                str = str.replaceAll("\\D", "");

                treeSet.add(Integer.valueOf(str));
            }

        }

        StringBuilder sb = new StringBuilder("MONERO REPORT: ");

        for (Integer integer : treeSet){
            sb.append(integer).append(", ");
        }

        if (!treeSet.isEmpty()){
            sb.setLength(sb.length()- 2);
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


    public static <T> void copy(List<? extends Integer> source, List<? super Number> dst) {
        for (Integer numSource : source) {
            dst.add(numSource);
        }
        System.out.println(dst.toString());
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