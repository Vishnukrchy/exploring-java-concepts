package lamda_expresion.java8_funtional_interface;

import java.util.function.BinaryOperator;

/*
 BinaryOperator is a functional interface that represents an operation on two operands of the same type that produces a result of the same type.
    It is a specialization of the BiFunction interface for the case where the input and output types are the same.
    It has a single abstract method apply(T t, T u) that takes two arguments of type T and returns a value of type T.
    It is often used for operations like addition, multiplication, or combining two values in a way that the input and output types are the same.
    BinaryOperator can be used with lambda expressions or method references.

    its used to define the input and output types as the same type. of an function that takes two arguments and returns a value.
 */
public class E1_BinarayOperatopr {

    public static void main(String[] args) {
        // with BiFunction interface
        java.util.function.BiFunction<Integer, Integer, Integer> addFunction = (a, b) -> a + b;
        System.out.println("Sum using BiFunction: " + addFunction.apply(5, 10)); // Sum using BiFunction: 15
        // Using BinaryOperator to add two integers
        BinaryOperator<Integer> addOperator = (a, b) -> a + b;
        System.out.println("Sum using BinaryOperator: " + addOperator.apply(5, 10)); // Sum using BinaryOperator: 15
        // BinaryOperator is a functional interface that represents an operation on two operands of the same type that produces a result of the same type.
        // it is a specialization of the BiFunction interface for the case where the input and output types are the same.
        java.util.function.BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(5, 10)); // Sum: 15

        // Using BinaryOperator to multiply two integers
        java.util.function.BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Product: " + multiply.apply(5, 10)); // Product: 50

        // Using BinaryOperator to concatenate two strings
        java.util.function.BinaryOperator<String> concatenate = (s1, s2) -> s1 + s2;
        System.out.println("Concatenated String: " + concatenate.apply("Hello, ", "World!")); // Concatenated String: Hello, World!
    }
}
