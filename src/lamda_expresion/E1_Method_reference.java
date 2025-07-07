package lamda_expresion;

import java.util.List;

/*
:: is used to refer to a method in Java.
It is a shorthand notation of a lambda expression to call a method.
It can be used to refer to a static method, an instance method, or a constructor.
It is often used in conjunction with functional interfaces.
 */
public class E1_Method_reference {

    // Method reference is a shorthand notation of a lambda expression to call a method.
    // It is used to refer to a method without executing it.
    // It can be used to refer to a static method, an instance method, or a constructor.
    // Method references are often used in conjunction with functional interfaces.

    public static void main(String[] args) {
        // Using method reference to refer to a static method
        Runnable runnable = E1_Method_reference::staticMethod;
        runnable.run(); // Output: Static method called

        // Using method reference to refer to an instance method
        E1_Method_reference instance = new E1_Method_reference();
        Runnable instanceRunnable = instance::instanceMethod;
        instanceRunnable.run(); // Output: Instance method called

        List<String> stringsList = List.of("apple", "banana", "cherry");
        // before method reference
        stringsList.forEach(s->System.out.println(s.toUpperCase()));
        // Using method reference to refer to an instance method of a class
        stringsList.forEach((System.out::println)); // Output: apple, banana, cherry

        // if method is not static method then we need to create an instance of the class to call the method.
        E1_Method_reference methodReference = new E1_Method_reference();
        // Using method reference to refer to an instance method of a class
        stringsList.forEach(methodReference::printUpperCase); // Output: apple, banana, cherry
    }

    public static void staticMethod() {
        System.out.println("Static method called");
    }

    public void instanceMethod() {
        System.out.println("Instance method called");
    }
    public void printUpperCase(String s) {
        System.out.println(s.toUpperCase());
    }
}
