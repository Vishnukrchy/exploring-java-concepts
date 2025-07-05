# Consumer Functional Interface in Java
=> Consumer is a functional interface in Java that represents an operation that takes a single input argument and returns no result.
=>It is often used to perform operations on objects without returning any value, such as printing or modifying an object.
=> The Consumer interface is defined in the java.util.function package and has a single abstract method accept(T t).
=> The accept method takes an argument of type T and performs the operation on it.
=> The Consumer interface can be used with lambda expressions to create concise and readable code.

```java
class ConsumerExample {
    public static void main(String[] args) {
        // Using Consumer to print a string
        Consumer<String> printConsumer = str -> System.out.println(str);
        
        // Applying the consumer
        printConsumer.accept("Hello, World!"); // Output: Hello, World!
    }
}
```
```java
import java.util.ArrayList;
class ConsumerExample {
    public static void main(String[] args) {
        // Using Consumer to print a list of strings
        Consumer<String> printConsumer = str -> System.out.println(str);
        
        // Creating a list of strings
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        // Applying the consumer to each element in the list
        names.forEach(printConsumer);
    }
}
```
class ExampleConsumer {
    public static void main(String[] args) {
        // Using Consumer to modify a list of integers
        Consumer<List<Integer>> doubleValuesConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 2);
            }
        };
        
        // Creating a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        // Applying the consumer to double the values in the list
        doubleValuesConsumer.accept(numbers);
        
        // Displaying the modified list
        System.out.println(numbers); // Output: [2, 4, 6]
    }
}
```
```java
class Ex2ampleConsumer {
    public static void main(String[] args) {
        // Using Consumer to print a list of integers
        Consumer<Integer> printConsumer = num -> System.out.println(num);
        
        // Creating a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        // Applying the consumer to each element in the list
        numbers.forEach(printConsumer); // Output: 1 2 3
    }
}
```
```java
 
// Using Consumer to modify a list of strings
class ExampleConsumer {
    public static void main(String[] args) {
        Consumer<List<String>> toUpperCaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };
        
        // Creating a list of strings
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        // Applying the consumer to convert each name to uppercase
        toUpperCaseConsumer.accept(names);
        
        // Displaying the modified list
        System.out.println(names); // Output: [ALICE, BOB, CHARLIE]
    }
}
```