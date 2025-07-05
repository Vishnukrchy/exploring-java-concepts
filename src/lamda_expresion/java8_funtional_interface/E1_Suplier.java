package lamda_expresion.java8_funtional_interface;

import java.util.function.Supplier;

/*
    * Supplier is a functional interface that represents a supplier of results.
    * It has a single abstract method get() that returns a value of type T.
    * It is often used for lazy evaluation, where the value is computed only when needed.
    * It is part of the java.util.function package and can be used with lambda expressions or method references.
    * Supplier is often used in conjunction with streams to generate values or provide default values.
    * It is commonly used in scenarios where a value needs to be provided without any input, such as generating random numbers, creating objects, or providing default values.
    * Supplier is often used in functional programming to create factories or providers for objects.
    * It is also used in scenarios where a value needs to be provided lazily, such as in caching or memoization.
    *
 */
public class E1_Suplier {
    public static void main(String[] args) {
        // print the
        Supplier<String> stringSupplier =()-> "Hello, Supplier!"; // Using lambda expression to create a Supplier
        System.out.println(stringSupplier.get()); // Hello, Supplier!
        // using Supplier to generate a random number
        Supplier<Integer> randomNumberSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100); // Generates a random number between 0 and 99
            }
        };
        System.out.println("Random Number: " + randomNumberSupplier.get()); // Random Number: 42 (example output)
        // Using lambda expression to create a Supplier
        Supplier<Integer> randomNumberSupplierLambda=()-> Math.random() > 0.5 ? 1 : 0; // Generates a random number between 0 and 1
        System.out.println("Random Number: " + randomNumberSupplierLambda.get()); // Random Number: 1 (example output)

        // Using method reference to create a Supplier
        Supplier<Double> randomDoubleSupplier = Math::random; // Generates a random double between 0.0 and 1.0
        System.out.println("Random Double: " + randomDoubleSupplier.get()); // Random Double: 0.123456789 (example output)

    }
}
