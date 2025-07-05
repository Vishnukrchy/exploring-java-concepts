# Predicates in Java
# Predicates are functional interfaces in Java that represent a single argument function that returns a boolean value. 
# They are often used in filtering operations, such as in the Stream API.
# The `Predicate<T>` interface is defined in the `java.util.function` package and has a single method `test(T t)`.
# Here's an example of how to use predicates in Java:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class PredicateExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Using a predicate to filter names that start with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Filtering the list using the predicate
        List<String> filteredNames = filterNames(names, startsWithA);

        // Displaying filtered names
        for (String name : filteredNames) {
            System.out.println(name);
        }
    }

    public static List<String> filterNames(List<String> names, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (predicate.test(name)) {
                result.add(name);
            }
        }
        return result;
    }
}
```
# How we can use predicates in Java:
# 1. **Filtering Collections**: You can use predicates to filter collections based on certain conditions.
# 2. **Stream API**: Predicates are commonly used with the Stream API to filter elements in a stream.
# 3. **Custom Conditions**: You can define custom conditions using predicates to apply complex filtering logic.
# 4. **Combining Predicates**: You can combine multiple predicates using logical operations like `and`, `or`, and `negate`.

# Example of Combining Predicates
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
class PredicateCombinationExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Predicate to check if a name starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");
        // Predicate to check if a name has more than 3 characters
        Predicate<String> hasMoreThanThreeChars = name -> name.length() > 3;

        // Combining predicates using 'and'
        Predicate<String> combinedPredicate = startsWithA.and(hasMoreThanThreeChars);

        // Filtering the list using the combined predicate
        List<String> filteredNames = filterNames(names, combinedPredicate);

        // Displaying filtered names
        for (String name : filteredNames) {
            System.out.println(name);
        }
    }

    public static List<String> filterNames(List<String> names, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (predicate.test(name)) {
                result.add(name);
            }
        }
        return result;
    }
}
```
# Example of Using Predicates with Streams
example of using predicates with Java Streams to filter a list of names based on a condition:
example 1
```javaimport java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class PredicateStreamExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Using a predicate to filter names that start with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Filtering the list using the predicate with streams
        List<String> filteredNames = names.stream()
              //  .filter(startsWithA)
                .filter(name -> name.startsWith("A")) // Directly using a lambda expression
                .collect(Collectors.toList());

        // Displaying filtered names
        filteredNames.forEach(System.out::println);
    }
}
```
Explanation: filter method is used to filter elements in the list based on the predicate condition. In this case, it filters names that start with 'A'. The filtered names are collected into a new list using `Collectors.toList()`, and then printed to the console.
example 2
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class PredicateStreamExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Using a predicate to filter names that have more than 3 characters
        Predicate<String> hasMoreThanThreeChars = name -> name.length() > 3;

        // Filtering the list using the predicate with streams
        List<String> filteredNames = names.stream()
                //.filter(hasMoreThanThreeChars)
                .filter(name -> name.length() > 3) // Directly using a lambda expression
                .collect(Collectors.toList());

        // Displaying filtered names
        filteredNames.forEach(System.out::println);
    }
}
```
# Example of Using Predicates with Streams
```javaimport java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class PredicateStreamExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Using a predicate to filter names that start with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Filtering the list using the predicate with streams
        List<String> filteredNames = names.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());

        // Displaying filtered names
        filteredNames.forEach(System.out::println);
    }
}
```
