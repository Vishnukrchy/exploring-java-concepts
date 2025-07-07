package lamda_expresion;

import java.util.List;

/*
:: is used to refer to a constructor in Java.
It is a shorthand notation of a lambda expression to call a constructor.
It can be used to refer to a constructor of a class.
It is often used in conjunction with functional interfaces.

It is used to create an instance of a class using a functional interface.
 */
public class E1_Constructor_Reference {
    public E1_Constructor_Reference(Object s) {

    }

    public E1_Constructor_Reference() {

    }

    public static void main(String[] args) {
        // Using constructor reference to create an instance of a class
        // Constructor reference is a shorthand notation of a lambda expression to call a constructor.
        // It is used to refer to a constructor without executing it.
        // It can be used to refer to a constructor of a class.
        // It is often used in conjunction with functional interfaces.

        java.util.function.Supplier<E1_Constructor_Reference> supplier = E1_Constructor_Reference::new;
        E1_Constructor_Reference instance = supplier.get(); // Creates an instance of E1_Constructor_Reference
        System.out.println("Instance created: " + instance);

        // Using constructor reference to create an instance of a class with parameters
        java.util.function.Function<String, E1_Constructor_Reference> function = E1_Constructor_Reference::new;
        E1_Constructor_Reference instanceWithParam = function.apply("Hello");
        System.out.println("Instance with parameter created: " + instanceWithParam);

        List<String> stringsList = List.of("apple", "banana", "cherry");
        // Using method reference to refer to an instance method of a class
        stringsList.forEach(System.out::println); // Output: apple, banana, cherry
        // Using constructor reference to create an instance of a class with parameters
        java.util.function.Function<String, E1_Constructor_Reference> constructorRef = E1_Constructor_Reference::new;
    }
}
