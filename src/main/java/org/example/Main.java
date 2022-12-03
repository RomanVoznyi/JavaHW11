package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Peter", "Anna", "Andrii", "Pavlo", "Dmytro");

        System.out.println("----------Task1 - Filtering and processing a list of names-------------");
        System.out.println("Was list - " + names);
        List<String> updatedList = Task1FilterNamesArray(names);
        System.out.println("Became list - " + updatedList);
        System.out.println();

        System.out.println("----------Task2 - Change letter case and Sorting-------------");
        System.out.println("Was list - " + updatedList);
        System.out.println("Option 1 - sorting by descending of string row as they are");
        System.out.println("Became list - " + Task2ChangeCaseAndSorting(updatedList));
        System.out.println();
        System.out.println("Option 2 - sorting by descending of names but indexes in previous order");
        System.out.println("Became list - " + Task2ChangeCaseAndSortingNames(updatedList));
        System.out.println();

        System.out.println("----------Task3 - Find all digits-------------");
        String[] arr = {"1, 2, 0", "4, 5", "h, 10.5, -13.154", "hello", "100, -4.5"};
        System.out.println("Was string list - " + Arrays.toString(arr));
        System.out.println("Became sorted line of digits - " + Task3FindAllDigits(arr));
        System.out.println();

        System.out.println("----------Task4 - Stream of random numbers-------------");
        System.out.println("My random numbers:");
        Task4GeneratorRandomNumbers(25214903917l, 11, 2 ^ 48)
                .limit(20)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println();

        System.out.println("----------Task5 - Zip streams-------------");
        List<Integer> intListOne = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> intListTwo = Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println("Was lists:");
        System.out.println("List 1: " + intListOne);
        System.out.println("List 2: " + intListTwo);
        System.out.println("Became list:");
        System.out.println(Task5Zip(intListOne.stream(),intListTwo.stream()).collect(Collectors.toList()));
        System.out.println();
    }

    public static List<String> Task1FilterNamesArray(List<String> names) {
        //filters array and returns only with odd index

        List<String> result = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 != 0) {
                result.add(i + ". " + names.get(i));
            }
        }
        return result;
    }

    public static List<String> Task2ChangeCaseAndSorting(List<String> names) {
        //set names to uppercase and sort by descending
        return names.stream().map(String::toUpperCase).sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
    }

    public static List<String> Task2ChangeCaseAndSortingNames(List<String> names) {
        //set names to uppercase and sort by descending of names
        List<String> result = names.stream()
                .map(name -> name.toUpperCase().split(" ")[1])
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int index = 0;
        int oddIndex = 1;
        for (String name : result) {
            result.set(index, oddIndex + ". " + name);
            index++;
            oddIndex += 2;
        }
        return result;
    }

    public static String Task3FindAllDigits(String[] arr) {
        //find all digits from string array fixed format and sort them

        return Arrays.stream(String.join(", ", arr).split(", "))
                .filter(tempNumber -> tempNumber.matches("-?\\d+(\\.\\d+)?"))
                .map(Double::parseDouble)
                .sorted()
                .map(el -> el % 1 == 0 ? String.valueOf(el.intValue()) : el.toString())
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> Task4GeneratorRandomNumbers(long a, long c, long m) {
        //created infinite stream of numbers
        final long seed = 2;
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static <T> Stream<T> Task5Zip(Stream<T> first, Stream<T> second) {
        //merges two streams with an interruption along the length of the minimum of them
        List<T> templistOne = first.collect(Collectors.toList());
        List<T> templistTwo = second.collect(Collectors.toList());
        long limit = Math.min(templistOne.size(), templistTwo.size());
        return Stream.of(templistOne.stream().limit(limit), templistTwo.stream().limit(limit))
                .flatMap(i -> i);
    }
}