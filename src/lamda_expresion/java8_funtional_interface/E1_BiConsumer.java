package lamda_expresion.java8_funtional_interface;
/*
    * BiConsumer is a functional interface that represents an operation that accepts two input arguments and returns no result.
    *  It has a single abstract method accept(T t, U u) that takes two arguments of types T and U and returns no result.
    *
 */
public class E1_BiConsumer {
    public static void main(String[] args) {
        // how we used Consumer for single argument like this
        java.util.function.Consumer<String> printConsumer = s -> System.out.println("Consumer is printing: " + s);
        printConsumer.accept("Hello World"); // Consumer is printing: Hello World
        // what if we want to print two arguments like name and age
        java.util.function.BiConsumer<String, Integer> printNameAndAge = (name, age) ->
            System.out.println("Name: " + name + ", Age: " + age);
        printNameAndAge.accept("Vishnu", 25); // Name: Vishnu, Age: 25
        // Using BiConsumer to print two strings
        java.util.function.BiConsumer<String, String> printTwoStrings = (str1, str2) ->
            System.out.println("String 1: " + str1 + ", String 2: " + str2);
    }
}
