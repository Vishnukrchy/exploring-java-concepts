# Function Functional Interface
# A functional interface is an interface that has exactly one abstract method. Lambda expressions can be used to provide the implementation of this single abstract method.
# Function is a functional interface in Java that represents a function that takes one argument and produces a result. It is defined in the `java.util.function` package and has the following signature:
```java
package java.util.function;
import java.util.function.Function;
public interface Function<T, R> {
    R apply(T t);
}
```
# Example of Using Function Functional Interface
```java
import java.util.function.Function;
public class FunctionExample {
    public static void main(String[] args) {
        // Using Function to convert a String to its length
        Function<String, Integer> stringLengthFunction = str -> str.length();
        // String is the input type (T) and Integer is the output type (R)
        // Applying the function
        String input = "Hello, World!";
        Integer length = stringLengthFunction.apply(input);

        // Displaying the result
        System.out.println("Length of the string \"" + input + "\" is: " + length);// 13
    }
}
```
# How to Use Function Functional Interface
# 1. **Mapping Values**: You can use the `Function` interface to map values from one type to another, such as converting a string to its length or transforming an object into a different representation.
# 2. **Chaining Functions**: You can chain multiple functions together using the `andThen` method, allowing you to create a pipeline of transformations.
# 3. **Higher-Order Functions**: You can pass functions as arguments to other functions, enabling functional programming paradigms in Java.

example:
```java
class FunctionChainingExample {
    public static void main(String[] args) {
        // Function to convert a String to its length
        Function<String, Integer> stringLengthFunction = str -> str.length();
        // Function to convert the length to a String representation
        Function<Integer, String> lengthToStringFunction = length -> "Length: " + length;

        // Chaining functions using andThen
        Function<String, String> combinedFunction = stringLengthFunction.andThen(lengthToStringFunction);

        // Applying the combined function
        String input = "Hello, World!";
        String result = combinedFunction.apply(input);

        // Displaying the result
        System.out.println(result); // Length: 13
    }
}
```
# Real use cases of Function Functional Interface
# 1. **Data Transformation**: You can use the `Function` interface to transform data from one format to another, such as converting a list of strings to a list of their lengths.
```java
 class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }
}

public class FunctionDataTransformationExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 21));

        // Function to convert Student to String representation
        Function<Student, String> studentToStringFunction = student -> "Name: " + student.getName() + ", Age: " + student.getAge();

        // Transforming the list of students to a list of their string representations
        List<String> studentStrings = transformStudents(students, studentToStringFunction);

        // Displaying the transformed list
        for (String studentString : studentStrings) {
            System.out.println(studentString);
        }
    }

    public static <T, R> List<R> transformStudents(List<T> items, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T item : items) {
            result.add(function.apply(item));
        }
        return result;
    }
}
```java
import java.util.ArrayList;

class FunctionExample {
    public static void main(String[] args) {
        // Using Function to convert a String to its length
        Function<String, Integer> stringLengthFunction = str -> str.length();
        // String is the input type (T) and Integer is the output type (R)
        // Applying the function
        String input = "Hello, World!";
        Integer length = stringLengthFunction.apply(input);

        // Displaying the result
        System.out.println("Length of the string \"" + input + "\" is: " + length);// 13
    }
}
```

