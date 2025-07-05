package lamda_expresion.java8_funtional_interface;

import java.util.function.Function;

/*
Function functional interface Method in Java 8
    * Function is a functional interface that represents a single argument function that returns a value.
    * It has a single abstract method apply(T t) that takes an argument of type T and returns a value of type R.
    * It is part of the java.util.function package and can be used with lambda expressions or method references.
    * Function is often used in conjunction with streams to transform data.

    its has methods like:
    * apply(T t) - Applies the function to the given argument and returns the result.
    * andThen(Function<? super R, ? extends V> after) - Returns a composed function that applies this function followed by the after function.
    * compose(Function<? super V, ? extends T> before) - Returns a composed function that applies the before function followed by this function.
 */
public class E3_Function {
    public static void main(String[] args) {

        Function<Integer, Integer> function1 = num->num*num; // Function to square a number
        System.out.println("Square of 5: " + function1.apply(5)); // 25
        Function<Integer,Integer> function2 = num->num*num*num; // Function to cube a number
        System.out.println("Cube of 5: " + function2.apply(5)); // 125

        // Using andThen to compose functions
        // andThen() is a method that returns a composed function that applies this function followed by the after function.
        Function<Integer,Integer> andThenFunction =function1.andThen(function2);
        System.out.println("Square then Cube of 5: " + andThenFunction.apply(5)); // 25 then 125
        System.out.println("Cube then Square of 5: " + function2.andThen(function1).apply(5)); // 125 then 25
        System.out.println("Square then Cube of 5: " + function1.andThen(function2).apply(5)); // 25 then 125

        // Using compose to compose functions
        // compose() is a method that returns a composed function that applies the before function followed by this function.
        Function<Integer,Integer> composeFunction = function1.compose(function2);
        System.out.println("Cube then Square of 5: " + composeFunction.apply(5)); // 125 then 25
        System.out.println("Square then Cube of 5: " + function2.compose(function1).apply(5)); // 25 then 125
        // Using Function to convert a string to its length
        Function<String, Integer> stringToLength = String::length;
        System.out.println("Length of 'Hello': " + stringToLength.apply("Hello")); // 5
        // Using Function to convert a string to its uppercase
        Function<String, String> toUpperCaseFunction = String::toUpperCase;
        System.out.println("Uppercase of 'hello': " + toUpperCaseFunction.apply("hello")); // HELLO
        // Using Function to convert a string to its lowercase
        Function<String, String> toLowerCaseFunction = String::toLowerCase;
        System.out.println("Lowercase of 'HELLO': " + toLowerCaseFunction.apply("HELLO")); // hello
    }
}
