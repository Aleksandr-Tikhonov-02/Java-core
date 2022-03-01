package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> emptyIntegerList = new ArrayList<>();
        System.out.println("AverageOfIntegerList");
        System.out.println("Result is " + getAverageOfList(List.of(1, 2, 5, 7, 9)));
        System.out.println("Result is " + getAverageOfList(emptyIntegerList));
        System.out.println("------------------");
        System.out.println("toUpperCaseWithAppendNew");
        toUpperCaseWithAppendNew(List.of("hello", "Sasha", "Goodbye"))
                .forEach(System.out::println);
        System.out.println("------------------");
        System.out.println("getSquaresOfSingleElements");
        getSquaresOfSingleElements(List.of(1, 1, 3, 5, 5, 8, 9))
                .forEach(System.out::println);
        System.out.println("------------------");
        System.out.println("getSortedCollectionOfWordsStartsWithLetter");
        getSortedCollectionOfWordsStartsWithLetter(
                List.of("banana", "apple", "potato", "butterfly", "blink"), 'b')
                .forEach(System.out::println);
        System.out.println("------------------");
        System.out.println("getLastElementOfCollection");
        List<String> emptyStringList = new ArrayList<>();
        try {
            System.out.println(getLastElementOfCollection(
                    List.of("banana", "apple", "potato", "butterfly", "blink")));
            System.out.println(getLastElementOfCollection(
                    List.of(1, 2, 3, 4, 5, 6)));
            System.out.println(getLastElementOfCollection(emptyStringList));
        } catch (NoSuchElementException e) {
            System.out.println("Collection is empty");
        }
        System.out.println("------------------");
        System.out.println("getSumOfEvenNumbers");
        int [] array1 = {1, 2, 3, 4, 5, 6};
        int [] array2 = {1, 3, 5};
        System.out.println(getSumOfEvenNumbers(array1));
        System.out.println(getSumOfEvenNumbers(array2));
        System.out.println("------------------");
        System.out.println("getMapFromStreamOfStrings");
        Map<String, String> map = getMapFromListOfStrings
                (List.of("apple", "banana", "orange", "raspberry", "potato"));
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static double getAverageOfList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static List<String> toUpperCaseWithAppendNew(List<String> list) {
        return list.stream().map(String::toUpperCase)
                .map(str -> str = "_new_" + str)
                .toList();
    }

    public static  List<Integer> getSquaresOfSingleElements(List<Integer> list) {
        return list.stream().filter((e) -> Collections.frequency(list, e) == 1)
                .map(i -> i * i)
                .toList();
    }

    public static Collection<String> getSortedCollectionOfWordsStartsWithLetter(Collection<String> collection, char letter) {
        return collection.stream()
                .filter(str -> str.startsWith(Character.toString(letter)))
                .sorted()
                .toList();
    }


    public static  <T> T getLastElementOfCollection(Collection<T> collection) throws  NoSuchElementException {
        return collection.stream().reduce((el1, el2) -> el2).orElseThrow(RuntimeException::new);
    }

    public static int getSumOfEvenNumbers(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0)
                .sum();
    }

    public static Map<String, String> getMapFromListOfStrings(List<String> list) {
        return list.stream().collect(Collectors.toMap
                (s -> s.substring(0, 1), s -> s.substring(1)));
    }
}
