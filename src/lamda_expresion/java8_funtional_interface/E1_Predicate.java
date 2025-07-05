package lamda_expresion.java8_funtional_interface;

import java.util.function.Predicate;

/**
 * E1_Predicate.java
 *  Prdicate is a functional interface that represents a single argument function that returns a boolean value.
 *  It is often used for filtering or matching conditions in collections or streams.
 *  *  It is part of the java.util.function package and can be used with lambda expressions or method references.
 *  *  It has a single abstract method test(T t) that takes an argument of type T and returns a boolean value.
 *  *  *  It can be used to create predicates for various types, such as String, Integer, etc.
 *
 *  if we not using predicate interface teh we have to create a custom method that takes a String and returns a boolean value.
 */
public class E1_Predicate {
    public static void main(String[] args) {
        //before Java 8, we would have to create a class that implements the Predicate interface
        // and override the test method to provide the implementation.
        //if we not using predicate interface teh we have to create a custom method that takes a String and returns a boolean value.
        //like this
        // Custom method to check if a string is longer than 5 characters
        isLongerThan5("Hello"); // false
        // by suing Predicate interface we can avoid creating a custom method
        Predicate<String> isLongerThan5 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;
            }
        };
        System.out.println(isLongerThan5.test("Hello")); // false
        // Using lambda expression to create a Predicate
        Predicate<String> isLongerThan5Lambda = s -> s.length() > 5;
        System.out.println((isLongerThan5Lambda.test("Hello Vishnu")));// true
       // if we not using predicate interface teh we have to create a custom method that takes a String and returns a boolean value.

        // Using the Predicate with a method reference
        Predicate<String> isLongerThan5MethodRef = E1_Predicate::isLongerThan5;
        System.out.println(isLongerThan5MethodRef.test("Hello World")); // true

        // Using the Predicate  tp check even or odd number
        Predicate<Integer> isEven=(number)->number%2==0;
        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(11)); // false
        // Using the Predicate to check if a string is empty
        Predicate<String> isEmpty=String::isEmpty;
        System.out.println((isEmpty.test(""))); // true
        System.out.println((isEmpty.test("Hello"))); // false

        Predicate<Double> isSalaryGreaterThan=salary->salary>50000.00;
        System.out.println((isSalaryGreaterThan.test(60000.00))); // true

        // Using the Predicate to check if a string starts with a specific character
        Predicate<String> startsWithH = s -> s.startsWith("H");




    }

    private static boolean isLongerThan5(String hello) {
        return hello.length()>5;
    }
}
