package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1_NamesHandler {

    public static List<String> filterNamesArray(List<String> names) {
        //filters list by odd indexes
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + names.get(i))
                .collect(Collectors.toList());
    }
}
