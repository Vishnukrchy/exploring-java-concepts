package lamda_expresion.java8_funtional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
Default and static methods in Predicate interface
Predicate interface in Java 8 has default and static methods that can be used to combine multiple predicates or negate a predicate.
 and() is a default method that takes another predicate as an argument and returns a new predicate that represents the logical AND of the two predicates.
or() is a default method that takes another predicate as an argument and returns a new predicate that represents the logical OR of the two predicates.
negate() is a default method that returns a new predicate that represents the logical negation of the original predicate.
isEquals() is a default method that checks if the current predicate is equal to another predicate.
 */
public class E3_Predicate {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Predicate to check if a number is even
        Predicate<Integer> isEven = number -> number % 2 == 0;
        // Predicate to check if a number is greater than 5
        Predicate<Integer> isGreaterThan5 = number -> number > 5;
        // Using and() to combine two predicates
        Predicate<Integer> isEvenAndGreaterThan5 = isEven.and(isGreaterThan5);
        System.out.println(isEvenAndGreaterThan5.test(5) );// false
        System.out.println(isEvenAndGreaterThan5.test(6) );// true

        // Using or() to combine two predicates
        Predicate<Integer> isEvenOrGreaterThan5 = isEven.or(isGreaterThan5);
        System.out.println(isEvenOrGreaterThan5.test(4) );// true
        System.out.println(isEvenOrGreaterThan5.test(3) );// false
        // Using negate() to negate a predicate
        //negate() returns a new predicate that represents the logical negation of the original predicate.
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println(isOdd.test(3) );// true
        System.out.println(isOdd.test(4) );// false

        // Using isEqual() to check if two predicates are equal
        Predicate<Integer> isEqualTo5 = Predicate.isEqual(5);
        System.out.println(isEqualTo5.test(5) );// true
        System.out.println(isEqualTo5.test(6) );// false
        // Using isEqual() to check if two predicates are equal with a list of numbers
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> filteredNumbers = new ArrayList<>();
        for (Integer number : numbersList) {
            if (isEqualTo5.test(number)) {
                filteredNumbers.add(number);
            }
        }
        System.out.println("Filtered numbers equal to 5: " + filteredNumbers); // Filtered numbers equal to 5: [5]
        // Using isEqual() with a list of strings
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        Predicate<String> isEqualToApple = Predicate.isEqual("apple");
        List<String> filteredStrings = new ArrayList<>();
        for (String str : stringList) {
            if (isEqualToApple.test(str)) {
                filteredStrings.add(str);
            }
        }
        System.out.println("Filtered strings equal to 'apple': " + filteredStrings); // Filtered strings equal to 'apple': [apple]
        List<String> filteredStrings2 = stringList.stream()
                .filter(Predicate.isEqual("banana")) // Using isEqual() with a stream
                .toList();




    }

}
