# Lesson 3: Basic stream operations
# In this lesson, we will explore some basic operations that can be performed using the Stream API in Java. These operations include filtering, mapping, and reducing data in a functional style.
# ## Key Operations in Stream API
# 1. **Filtering**: The `filter` operation allows you to filter elements in a stream based on a given condition. It returns a new stream containing only the elements that match the condition.
# 2. **Mapping**: The `map` operation allows you to transform elements in a stream by applying a function to each element. It returns a new stream containing the transformed elements.
# 3. **Reducing**: The `reduce` operation allows you to combine elements in a stream into a single result by applying a binary operator. It is often used to perform operations like summation, multiplication, or concatenation.
# 4. **Collecting**: The `collect` operation allows you to collect the elements of a stream into a collection, such as a list or a set.

# Streams work with pipelines of operations:
# Intermediate operations: transform the stream (return another stream)
filter, map, sorted, etc.
# Terminal operations: produce a final result
collect, forEach, count, reduce, etc.

# ## Example of Basic Stream Operations
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamApiBasicOperations {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Filtering names that start with 'A'
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered Names: " + filteredNames);

        // Mapping names to their lengths
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("Name Lengths: " + nameLengths);

        // Reducing to find the total length of all names
        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println("Total Length of Names: " + totalLength);
    }
}
```
# Output
```
Filtered Names: [Alice]
Name Lengths: [5, 3, 7, 5, 3]
Total Length of Names: 23
```
# Explanation
# In this example, we demonstrate the following basic stream operations:
# 1. **Filtering**: We filter the names that start with 'A' using the `filter` method and collect the results into a list.
# 2. **Mapping**: We map the names to their lengths using the `map` method and collect the results into a list of integers.
# 3. **Reducing**: We reduce the stream of names to find the total length of all names using the `mapToInt` method and the `sum` operation.
