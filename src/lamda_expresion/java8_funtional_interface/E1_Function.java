package lamda_expresion.java8_funtional_interface;

import java.util.List;
import java.util.function.Function;

/*
Function is a functional interface that represents a single argument function that returns a value.
this have a single abstract method apply(T t) that takes an argument of type T and returns a value of type R.

 */
public class E1_Function {
    public static void main(String[] args) {
        // Using Function interface to convert a string to its length

        Function<String,Integer> stringIntegerFunction=new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(stringIntegerFunction.apply("Hello")); // 5
        // Using lambda expression to create a Function
        Function<String,Integer> stringIntegerFunction1=s->s.length();
        System.out.println(stringIntegerFunction1.apply("Hello Vishnu")); // 11
        // Using method reference to create a Function
        Function<String,Integer> stringIntegerFunction2=String::length;

        System.out.println(stringIntegerFunction2.apply("Hello World")); // 11
        // Using Function to convert a string to its uppercase
        Function<String,String> toUpperCaseFunction = String::toUpperCase;
        System.out.println(toUpperCaseFunction.apply("hello")); // HELLO
        // Using Function to convert a string to its lowercase
        Function<String,String> toLowerCaseFunction = String::toLowerCase;
        System.out.println(toLowerCaseFunction.apply("HELLO")); // hello

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        List<Integer> nameLengths = names.stream()
                .map(String::length) // Using method reference to get the length of each name
                .toList(); // Collecting the lengths into a list
        System.out.println(nameLengths); // [5, 3, 7, 5]

        // Using Function to convert a string to its first character
        Function<String, Character> firstCharacterFunction = s -> s.charAt(0);

        System.out.println(firstCharacterFunction.apply("Hello")); // H
        System.out.println(firstCharacterFunction.apply("vishnu")); // V

        // Function is often used in conjunction with streams to transform data.
        List<String> words = List.of("apple", "banana", "cherry", "date");
        List<Integer> wordLengths = words.stream()
                .map(String::length) // Using method reference to get the length of each word
                .toList(); // Collecting the lengths into a list

        System.out.println(wordLengths); // [5, 6, 6, 4]

    }

}
