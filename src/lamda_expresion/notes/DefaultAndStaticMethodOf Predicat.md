# Default and Static Method Of Predicate
=> Instead of using the `Predicate` interface directly, you can use the default and static methods provided by the `Predicate` interface in Java 8 and later versions. These methods allow you to create more complex predicates by combining existing ones.
=> Predicates can be combined using methods like `and`, `or`, and `negate`. These methods allow you to create more complex predicates by combining existing ones.
=> Predicates can be used with the `Stream` API to filter collections, making it easier to work with data in a functional style.

# Example of Using Default and Static Methods of Predicate
1 ) and() method combines two predicates and returns a new predicate that is true if both predicates are true.
example:
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class PredicateDefaultStaticExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Predicate to check if a name starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Predicate to check if a name has more than 3 characters
        Predicate<String> hasMoreThan3Chars = name -> name.length() > 3;

        // Combining predicates using and() method
        Predicate<String> combinedPredicate = startsWithA.and(hasMoreThan3Chars);

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
2 ) or() method combines two predicates and returns a new predicate that is true if either of the predicates is true.
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class PredicateOrExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Predicate to check if a name starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Predicate to check if a name has more than 3 characters
        Predicate<String> hasMoreThan3Chars = name -> name.length() > 3;

        // Combining predicates using or() method
        Predicate<String> combinedPredicate = startsWithA.or(hasMoreThan3Chars);

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
3 ) negate() method returns a new predicate that is the negation of the original predicate.
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class PredicateNegateExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Predicate to check if a name starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Negating the predicate
        Predicate<String> notStartsWithA = startsWithA.negate();

        // Filtering the list using the negated predicate
        List<String> filteredNames = filterNames(names, notStartsWithA);

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
4 ) isEqual() method is a static method that returns a predicate that tests if two objects are equal.
```java
import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;
public class PredicateIsEqualExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Using isEqual() method to create a predicate
        Predicate<String> isEqualToAlice = Predicate.isEqual("Alice");

        // Filtering the list using the isEqual predicate
        List<String> filteredNames = filterNames(names, isEqualToAlice);

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
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;



