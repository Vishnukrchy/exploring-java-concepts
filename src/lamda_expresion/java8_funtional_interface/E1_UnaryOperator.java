package lamda_expresion.java8_funtional_interface;

import java.util.function.Function;

/*
    * UnaryOperator is a functional interface that represents an operation on a single operand that produces a result of the same type.
    * It is a specialization of the Function interface for the case where the input and output types are the same.
    * It has a single abstract method apply(T t) that takes an argument of type T and returns a value of type T.
    * It is often used for operations like incrementing, negating, or transforming values in a way that the input and output types are the same.
    * UnaryOperator can be used with lambda expressions or method references.
    *
 */
public class E1_UnaryOperator {
    public static void main(String[] args) {
        //  UnaryOperator is a functional interface that represents an operation on a single operand that produces a result of the same type.
        // we can used to define the input and output types as the same type.
        // like functoion interface, UnaryOperator is a specialization of the Function interface.
        Function<String, String> toUpperCaseFunction = String::toUpperCase;
        // Using UnaryOperator to convert a string to uppercase
        java.util.function.UnaryOperator<String> toUpperCase1 = String::toUpperCase;
        // Using UnaryOperator to increment an integer
        java.util.function.UnaryOperator<Integer> increment = x -> x + 1;
        System.out.println("Incremented value: " + increment.apply(5)); // Incremented value: 6

        // Using UnaryOperator to negate a boolean value
        java.util.function.UnaryOperator<Boolean> negate = b -> !b;
        System.out.println("Negated value: " + negate.apply(true)); // Negated value: false

        // Using UnaryOperator to convert a string to uppercase
        java.util.function.UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println("Uppercase string: " + toUpperCase.apply("hello")); // Uppercase string: HELLO

        // Using UnaryOperator to double a number
        java.util.function.UnaryOperator<Double> doubleValue = d -> d * 2;
        System.out.println("Doubled value: " + doubleValue.apply(10.0)); // Doubled value: 20.0
    }
}
