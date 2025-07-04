# Lesson 2: How to create streams
# The Stream API in Java provides a way to process sequences of elements (like collections) in a functional style. In this lesson, we will learn how to create streams from various data sources.
# ## Creating Streams
# Streams can be created from various data sources, including collections, arrays, and I/O channels. Here are some common ways to create streams:
# 1. **From Collections**: You can create a stream from a collection using the `stream()` method.
# 2. **From Arrays**: You can create a stream from an array using the `Arrays.stream()` method.
# 3. **From Static Methods**: You can create a stream using static methods like `Stream.of()`.
# 4. **From Files**: You can create a stream from a file using the `Files.lines()` method.
# 5. **From Generators**: You can create an infinite stream using the `Stream.generate()` method.
# 6. **From Iterators**: You can create a stream from an iterator using the `StreamSupport.stream()` method.

# ## Example of Creating Streams
```java
import java.util.Arrays;    
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class StreamCreationExample {
    public static void main(String[] args) {
        // 1. Creating a stream from a collection
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> nameStream = names.stream();

        // 2. Creating a stream from an array
        String[] nameArray = {"David", "Eve", "Frank"};
        Stream<String> arrayStream = Arrays.stream(nameArray);

        // 3. Creating a stream using Stream.of()
        Stream<String> staticStream = Stream.of("Grace", "Heidi", "Ivan");

        // 4. Creating a stream from a file (assuming the file exists)
        // Path path = Paths.get("path/to/file.txt");
        // Stream<String> fileStream = Files.lines(path);

        // 5. Creating an infinite stream using Stream.generate()
        Stream<Integer> infiniteStream = Stream.generate(() -> (int) (Math.random() * 100)).limit(10);

        // 6. Creating a stream from an iterator
        List<String> list = Arrays.asList("Jack", "Kathy", "Liam");
        Stream<String> iteratorStream = StreamSupport.stream(list.spliterator(), false);

        // Collecting and displaying the streams
        List<String> collectedNames = nameStream.collect(Collectors.toList());
        System.out.println("Names from collection: " + collectedNames);
        
        List<String> collectedArrayNames = arrayStream.collect(Collectors.toList());
        System.out.println("Names from array: " + collectedArrayNames);
        
        List<String> collectedStaticNames = staticStream.collect(Collectors.toList());
        System.out.println("Names from static method: " + collectedStaticNames);
        
        List<Integer> collectedInfiniteNumbers = infiniteStream.collect(Collectors.toList());
        System.out.println("Random numbers from infinite stream: " + collectedInfiniteNumbers);
        
        List<String> collectedIteratorNames = iteratorStream.collect(Collectors.toList());
        System.out.println("Names from iterator: " + collectedIteratorNames);
    }
}
```
# ## Explanation
# In this example, we demonstrate various ways to create streams:
# 1. **From Collections**: We create a stream from a list of names using the `stream()` method.
# 2. **From Arrays**: We create a stream from an array of names using the `Arrays.stream()` method.
# 3. **From Static Methods**: We create a stream using the `Stream.of()` method with static values.
# 4. **From Files**: We can create a stream from a file using the `Files.lines()` method (commented out for demonstration).
# 5. **From Generators**: We create an infinite stream of random integers using the `Stream.generate()` method and limit it to 10 elements.
# 6. **From Iterators**: We create a stream from an iterator using the `StreamSupport.stream()` method.

# ## Conclusion
# The Stream API provides a powerful way to process sequences of elements in a functional style. In this lesson, we learned how to create streams from various data sources, including collections, arrays, static methods, files, generators, and iterators. Understanding how to create streams is the first step in leveraging the full potential of the Stream API for data processing in Java.

# Streams example
```java
class StreamExample {
    public static void main(String[] args) {
        // Creating a stream from a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> numberStream = numbers.stream();

        // Performing operations on the stream
        List<Integer> squaredNumbers = numberStream
                .map(n -> n * n) // Squaring each number
                .collect(Collectors.toList()); // Collecting results into a list

        // Displaying the squared numbers
        System.out.println("Squared Numbers: " + squaredNumbers);
    }
}
```
#Explanation: 
In this example, we create a stream from a list of integers. We then perform a mapping operation to square each number in the stream and collect the results into a new list. Finally, we print the squared numbers.
method used in this 
           1) `stream()`: This method is used to create a stream from a collection.
           2) `map()`: This intermediate operation applies a function to each element in the stream, transforming it.
           3) `collect()`: This terminal operation collects the elements of the stream into a collection, in this case, a list.
              collect method is used to gather the results of the stream operations into a collection, such as a list or set. It is a terminal operation that triggers the processing of the stream and returns the collected results.
Collecting results into a list is done using the `Collectors.toList()` method, which is a common way to gather elements from a stream into a list.
What is purpose of Collectors.toList() in the context of streams?
The `Collectors.toList()` method is used in the context of streams to collect the elements of a stream into a `List`. It is a terminal operation that triggers the processing of the stream and returns the collected results as a list. This method is part of the `Collectors` utility class, which provides various methods for collecting elements from a stream into different types of collections.
     Collectors is a utility class in Java that provides various methods for collecting elements from a stream into different types of collections, such as lists, sets, or maps. The `toList()` method is one of the most commonly used collectors, which collects the elements of a stream into a `List`.



 What is the difference between `stream()` and `collect()`?


# Streams Example
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamExample2 {
    public static void main(String[] args) {
        // Creating a stream from a list of strings
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Filtering names that start with 'A' and collecting them into a new list
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        // Displaying the filtered names
        System.out.println("Filtered Names: " + filteredNames);
    }
}
```
# Explanation:
In this example, we create a stream from a list of strings (names). We then apply a filtering operation to select names that start with the letter 'A' and collect the results into a new list. Finally, we print the filtered names.
# Explanation of `stream()` and `collect()`
whar is the difference between `stream()` and `collect()`?
The `stream()` method is used to create a stream from a collection, allowing you to perform various operations on the elements of that collection in a functional style. It is an intermediate operation that prepares the data for further processing.
The `collect()` method, on the other hand, is a terminal operation that collects the results of the stream operations into a collection, such as a list or set. It triggers the processing of the stream and returns the collected results.
# Streams Example with `collect()`
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamExample3 {
    public static void main(String[] args) {
        // Creating a stream from a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Collecting the square of each number into a new list
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n) // Squaring each number
                .collect(Collectors.toList()); // Collecting results into a list

        // Displaying the squared numbers
        System.out.println("Squared Numbers: " + squaredNumbers);
    }
}
```
# Explanation:
In this example, we create a stream from a list of integers. We then apply a mapping operation to square each number in the stream and collect the results into a new list using the `collect()` method. Finally, we print the squared numbers.

# Streams Example with `filter()`
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamExample4 {
    public static void main(String[] args) {
        // Creating a stream from a list of strings
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Filtering names that contain the letter 'a' and collecting them into a new list
        List<String> filteredNames = names.stream()
                .filter(name -> name.toLowerCase().contains("a"))
                .collect(Collectors.toList());

        // Displaying the filtered names
        System.out.println("Filtered Names: " + filteredNames);
    }
}
```
# Explanation:
In this example, we create a stream from a list of strings (names). We then apply a filtering operation to select names that contain the letter 'a' (case-insensitive) and collect the results into a new list using the `collect()` method. Finally, we print the filtered names.
filter() method is used to filter elements in a stream based on a given condition. It takes a predicate (a function that returns a boolean) as an argument and returns a new stream containing only the elements that satisfy the condition.

