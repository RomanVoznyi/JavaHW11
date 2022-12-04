package org.example;

import java.util.stream.Stream;

public class Task4_RandomNumbers {

    public static Stream<Long> getRandom(long a, long c, long m) {
        //created infinite stream of numbers
        final long seed = 2;
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}
