package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task2_CaseAndSorting {

    public static List<String> changeCaseAndSortingOpt1(List<String> names) {
        //set names to uppercase and sort by descending
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<String> changeCaseAndSortingOpt2(List<String> names) {
        //set names to uppercase and sort by descending of names
        List<String> tempResult = names.stream()
                .map(name -> name.toUpperCase().split(" ")[1])
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return addOddIndex(tempResult);
    }

    private static List<String> addOddIndex(List<String> names) {
        //add odd index to the list
        return IntStream.range(0, names.size() * 2)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + names.get(i / 2))
                .collect(Collectors.toList());
    }
}
