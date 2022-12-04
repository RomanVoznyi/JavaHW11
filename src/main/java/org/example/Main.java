package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        testTask1();
        testTask2();
        testTask3();
        testTask4();
        testTask5();
    }

    public static void testTask1(){
        System.out.println("----------Task1 - Filtering and processing a list of names-------------");
        List<String> names = Arrays.asList("Ivan", "Peter", "Anna", "Andrii", "Pavlo", "Dmytro");
        System.out.println("Was list - " + names);
        System.out.println("Became list - " + Task1_NamesHandler.filterNamesArray(names));
        System.out.println();
    }

    public static void testTask2(){
        System.out.println("----------Task2 - Change letter case and Sorting-------------");
        List<String> names = Arrays.asList("Ivan", "Peter", "Anna", "Andrii", "Pavlo", "Dmytro");
        List<String> input =  Task1_NamesHandler.filterNamesArray(names);
        System.out.println("Was list - " + input);
        System.out.println("Option 1 - sorting by descending of string row as they are");
        System.out.println("Became list - " + Task2_CaseAndSorting.changeCaseAndSortingOpt1(input));
        System.out.println();
        System.out.println("Option 2 - sorting by descending of names but indexes in previous order");
        System.out.println("Became list - " + Task2_CaseAndSorting.changeCaseAndSortingOpt2(input));
        System.out.println();
    }

    public static void testTask3(){
        System.out.println("----------Task3 - Find all digits-------------");
        String[] arr = {"1, 2, 0", "4, 5", "h, 10.5, -13.154", "hello", "100, -4.5"};
        System.out.println("Was string list - " + Arrays.toString(arr));
        System.out.println("Became sorted line of digits - " + Task3_FindDigits.getDigits(arr));
        System.out.println();
    }

    public static void testTask4(){
        System.out.println("----------Task4 - Stream of random numbers-------------");
        System.out.println("My random numbers:");
        Task4_RandomNumbers.getRandom(25214903917l, 11, 2 ^ 48)
                .limit(20)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println();
    }

    public static void testTask5(){
        System.out.println("----------Task5 - Zip streams-------------");
        List<Integer> intListOne = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> intListTwo = Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println("Was lists:");
        System.out.println("List 1: " + intListOne);
        System.out.println("List 2: " + intListTwo);
        System.out.println("Became list:");
        System.out.println(Task5_MergeStreams.zip(intListOne.stream(),intListTwo.stream())
                .collect(Collectors.toList()));
        System.out.println();
    }



}