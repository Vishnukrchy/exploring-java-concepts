package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Locale.filter;


/*
  Stream API is a powerful feature introduced in Java 8 that allows for functional-style operations on sequences of elements, such as collections or arrays.
    It provides a way to process data in a declarative manner, enabling operations like filtering, mapping, and reducing without the need for explicit iteration.
    Stream API supports parallel processing, making it easier to take advantage of multi-core processors for performance improvements.
    Stream API is designed to work with functional programming concepts, allowing developers to write concise and expressive code.

 */
public class E1_Stream {
    public static void main(String[] args) {
        //
        List<Integer> list= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // filtering even numbers from the list
        // before stream api
        for (Integer i : list) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        //using stream api to filter even numbers from the list
       List<Integer> list1= list.stream()
                .filter(num->num%2==0) // filter even numbers
                //.forEach(System.out::println); // print each even number
        .collect(Collectors.toList()); // collect the result into a list
        System.out.println("Even numbers using Stream API: " + list1);

        // different ways to use stream api
        differentWaysToUseStreamApi();

    }
    public  static  void differentWaysToUseStreamApi() {
       // on Arrays we can create stream by using Arrays.stream(array)
        String[] array = {"apple", "banana", "cherry"};
        Stream<String> arrayStream = Arrays.stream(array);// Stream of strings from array is created
        // now we can use stream to filter strings longer than 5 characters
        List<String> stringList = arrayStream.filter(s -> s.length() > 5)// filter accepting a predicate to filter strings longer than 5 characters return boolean value
                .collect(Collectors.toList());// collect the result into a list
        System.out.println("Filtered Strings: " + stringList);

        Arrays.stream(array) // another way to create stream from array
                .filter(s -> s.startsWith("b")) // filter strings that start with "b"
                .forEach(System.out::println); // print each string that starts with "b"

        // on Collections we can create stream by using collection.stream()
        List<String> collection = Arrays.asList("apple", "banana", "cherry");
        List<String> filteredCollection = collection.stream()
                .filter(s -> s.length() > 5) // filter strings longer than 5 characters
                .collect(Collectors.toList()); // collect the result into a list
        System.out.println("Filtered Collection: " + filteredCollection);


        // on Stream.of() we can create stream by using Stream.of(elements)
        Stream<Integer> integerStream = Stream.of(1, 3, 4, 5, 6, 7, 8, 9, 10);// create a stream of integers
        List<Integer> collect = integerStream.
                filter(num -> num % 2 == 0) // filter even numbers
                .map(num -> num * 2) // map each even number to its double
                //.collect(Collectors.toList());// collect the result into a list
        //'collect(toList())' can be replaced with 'toList()'
                .toList(); // collect the result into a list

        System.out.println("Even numbers doubled: " + collect);

        // by using iterator
        // iterate
        List<String> stringList1 = Arrays.asList("apple", "banana", "cherry");
        // by using iterator to create stream
        // generating numbers using Stream.iterate()
        Stream<Integer> limit = Stream.iterate(1, number -> number * 2).limit(100);// create a stream of numbers starting from 1, doubling each time, limited to 100 elements
         System.out.println("Generated Numbers: " +limit.collect(Collectors.toList())); // collect the result into a list
        // explanation:
        // Stream.iterate(1, number -> number * 2) creates an infinite stream starting from 1, where each subsequent element is double the previous one.
        // The limit(100) method limits the stream to the first 100 elements.
        // generating even numbers using Stream.iterate()
        Stream.iterate(0,n->n+2).limit(10) // create a stream of even numbers starting from 0, limited to 10 elements
                .forEach(System.out::println); // print each even number


        // by using Stream.generate()
        // generate function to create a stream of random numbers its accepting a supplier
        // supplier is a functional interface that represents a supplier of results, it has a single abstract method get() that returns a value.
        Stream<Integer> generate = Stream.generate(() -> (int)Math.random() * 100)
                .limit(10000); // limit the stream to 10,000 elements
        List<Integer> List = generate
                .filter(num -> num % 2 == 0).collect(Collectors.toList()); // collect the result into a list
        System.out.println("Random Even Numbers: " + List); // print the list of random even numbers
        // generate random numbers using Stream.generate()
        Stream<Double> randomNumbers = Stream.generate(Math::random) // create a stream of random numbers
                .limit(10); // limit the stream to 10 elements
        System.out.println("Random Numbers: " + randomNumbers.toList()); // collect the result into a list


    }
}
