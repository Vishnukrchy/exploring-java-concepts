package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E2_Stream {
    public static void main(String[] args) {
        // Example of using Stream API to process a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,2,5,4,7,8,10,12,14,16,18,20);

        // filter even numbers
        List<Integer> evenlist = numbers.stream()
                .filter(num -> num % 2 == 0) // filter even numbers
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenlist);
        // if we want to double the even numbers
        List<Integer> mapedList = evenlist.stream().map(num -> num * 2) // map each even number to its double
                .toList();
        System.out.println("Doubled Even Numbers: " + mapedList);

        // if we  want not repeat the same number
        mapedList.stream().distinct()
                .forEach(System.out::println); // print each distinct doubled even number
        System.out.println("Distinct Doubled Even Numbers: " + mapedList.stream().distinct().collect(Collectors.toList()));
         // if we want to sort the numbers
        List<Integer> sortedList = mapedList.stream()
                .sorted() // sort the numbers in ascending order
                .collect(Collectors.toList());
        System.out.println("Sorted Doubled Even Numbers: " + sortedList);

        // we can do custom sorting
        List<Integer> customSortedList = mapedList.stream()
                .sorted((a, b) -> b - a) // sort the numbers in descending order
                .collect(Collectors.toList());

        // we can write all in one line
        List<Integer> list = numbers.stream()
                .filter(num -> num % 2 == 0) // filter even numbers
                .map(num -> num * 2) // map each even number to its double
                .distinct() // remove duplicates
                //   .sorted()// sort the numbers in ascending order
                .sorted((a, b) -> b - a) // sort the numbers in descending order
                .peek(System.out::println) // print each number
                .collect(Collectors.toList());// collect the result into a list
        System.out.println("All in One Line: " + list);
        // we can used limit and skip methods to limit the number of elements in the stream
        // limit(n) - limits the stream to n elements
        // skip(n) - skips the first n elements of the stream

        numbers.stream()
                .filter(num -> num % 2 == 0) // filter even numbers
                .map(num -> num * 2) // map each even number to its double
                .distinct() // remove duplicates
               // .sorted((a, b) -> b - a) // sort the numbers in descending order
                .limit(5) // limit the stream to 5 elements
                .skip(2) // skip the first 2 elements
                .forEach(System.out::println); // print each number


        // Example of using Stream API to process a list of strings
        List<String> words = List.of("apple", "banana", "cherry", "date");

        // Filtering words that start with 'b' and converting them to uppercase
        List<String> filteredWords = words.stream()
                .filter(word -> word.startsWith("b"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Filtered Words: " + filteredWords);

    }
}
