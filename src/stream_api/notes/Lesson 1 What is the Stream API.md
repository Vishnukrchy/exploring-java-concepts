# Lesson 1: What is the Stream API?
   stream api comes with Java 8 and provides a way to process sequences of elements (like collections) in a functional style.
    It allows you to perform operations like filtering, mapping, and reducing on collections in a more readable and concise way.
# Key Features of Stream API
1. **Functional Style**: Stream API allows you to write code in a functional style, making it more readable and expressive.
2. **Lazy Evaluation**: Streams are evaluated lazily, meaning that operations are not executed until a terminal operation is invoked. This allows for optimization and better performance.
3. **Chaining Operations**: You can chain multiple operations together, such as filtering, mapping, and reducing, to create a pipeline of operations on the data.
4. **Parallel Processing**: Stream API supports parallel processing, allowing you to take advantage of multi-core processors for better performance.
5. **Type Inference**: Stream API uses type inference, which means you don't need to specify the type of elements in the stream explicitly.
6. **Intermediate and Terminal Operations**: Stream API provides a wide range of intermediate operations (like `filter`, `map`, `sorted`) and terminal operations (like `collect`, `forEach`, `reduce`) to process data.
7. **Support for Functional Interfaces**: Stream API works with functional interfaces, allowing you to pass behavior as parameters using lambda expressions.
# Example of Stream API
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamApiExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using Stream API to filter and collect names that start with 'A'
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        // Displaying filtered names
        filteredNames.forEach(System.out::println);
    }
}
```
# Stream vs Collection
The Stream API is designed to work with collections, but it provides a different approach to processing data compared to traditional collection methods. Here are some key differences:
👉 A stream does not store data — it works on data from a source, applies operations, and ends.
👉 Streams are not data structures; they are a sequence of elements that can be processed.
👉 Streams can be processed in parallel, while collections are typically processed sequentially.


# Conclusion
