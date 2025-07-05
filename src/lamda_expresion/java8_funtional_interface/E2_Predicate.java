package lamda_expresion.java8_funtional_interface;

import java.util.List;
import java.util.function.Predicate;

/*
How to use Predicate interface in Java 8 in stream API and lambda expressions.
Predicate is a functional interface that represents a single argument function that returns a boolean value.
It is often used for filtering or matching conditions in collections or streams.

filter() is a method that takes a Predicate as an argument and returns a stream of elements that match the predicate condition.
filter() is a method of the Stream interface that takes a Predicate as an argument and returns a new stream that contains only the elements that match the predicate condition.


 */
public class E2_Predicate {
    public static void main(String[] args) {

        Predicate<Integer> isEven = number -> number % 2 == 0;

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //by loops
        for (Integer number:numbers){
            if (isEven.test(number)) {
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }
        }

        // Using Predicate with stream to filter even numbers
        List<Integer> eveNumbers=numbers.stream()
               // .filter(isEven)// filter() is a method that takes a Predicate as an argument and returns a stream of elements that match the predicate condition
                .filter(number -> number % 2 == 0) // using lambda expression directly write the condition
                .toList();// toList() is a terminal operation that collects the filtered elements into a new list
        System.out.println("Even numbers: " + eveNumbers);

        // using Predicate to sum of even numbers
        int sumOfEvenNumbers=numbers.stream()
                .filter(n->n%2==0)
                .mapToInt(Integer::intValue) // mapToInt() converts the stream of Integer to an IntStream
                .sum(); // sum() is a terminal operation that returns the sum of the elements in the IntStream

        System.out.println("Sum of even numbers: " + sumOfEvenNumbers);
        // Using Predicate to check if a string contains a specific character

        Predicate<String> containsChar = s -> s.contains("a");
        System.out.println(containsChar.test("apple")); // true
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig");
        // Filtering words that contain the character 'a'
        List<String> filteredWords = words.stream()
                .filter(s->s.contains("d")) // using lambda expression directly write the condition
                .toList();
        System.out.println("Words containing 'd': " + filteredWords);

    }
}
