package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5_MergeStreams {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        //merges two streams with an interruption along the length of the minimum of them

        List<T> templistOne = first.collect(Collectors.toList());
        List<T> templistTwo = second.collect(Collectors.toList());
        long limit = Math.min(templistOne.size(), templistTwo.size());

        return Stream.of(templistOne.stream().limit(limit), templistTwo.stream().limit(limit))
                .flatMap(i -> i);
    }
}
