package lamda_expresion.java8_funtional_interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
    * This class is used to demonstrate the usage of various functional interfaces in Java 8.
    * It includes examples of Function, Supplier, and other functional interfaces.
 */
public class Used_All {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0; // Predicate to check if a number is even
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        Function<Integer,Integer> squareFunction = number -> number * number; // Function to square a number
        System.out.println("Square of 5: " + squareFunction.apply(5)); // 25
        Consumer<Integer> printConsumer=num-> System.out.println("Consumer is printing: " + num); // Consumer to print a number
        printConsumer.accept(10); // Consumer is printing: 10
        // Using Supplier to generate a random number
        Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100); // Generates a random number between 0 and 99
        System.out.println("Random Number: " + randomNumberSupplier.get()); // Random Number: 42 (example output)

        // Using all functional interfaces together
        for (isEven.test(randomNumberSupplier.get()); isEven.test(randomNumberSupplier.get()); ) {
            System.out.println("Even number generated: " + randomNumberSupplier.get());
        }

        if(isEven.test(randomNumberSupplier.get())){
            printConsumer.accept(squareFunction.apply(randomNumberSupplier.get())); // Consumer is printing: 100 (example output)
        }



        Function<Integer, String> numberToString = number -> "Number: " + number; // Function to convert a number to a string
        Consumer<String> printStringConsumer = str -> System.out.println("Consumer is printing: " + str); // Consumer to print a string
        Integer randomNumber = randomNumberSupplier.get(); // Get a random number
        String numberString = numberToString.apply(randomNumber); // Convert the random number to a string
        printStringConsumer.accept(numberString); // Consumer is printing: Number: 42 (example output)
    }
}
