package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3_FindDigits {

    public static String getDigits(String[] arr) {
        //find all digits from string array fixed format and sort them

        return Arrays.stream(updateArrFormat(arr))
                .filter(tempNumber -> tempNumber.matches("-?\\d+(\\.\\d+)?"))
                .map(Double::parseDouble)
                .sorted()
                .map(el -> el % 1 == 0 ? String.valueOf(el.intValue()) : el.toString())
                .collect(Collectors.joining(", "));
    }

    private static String[] updateArrFormat(String[] arr){
        // convert array ["a, b, c", "d", "e, f"] to array ["a","b","c","d","e","f"]

        return String.join(", ", arr).split(", ");
    }
}
