# Function Functional Interface Methods
=> # The `Function` functional interface in Java provides methods to apply a function to an input and return a result.
# It is defined in the `java.util.function` package and has a single abstract method `apply(T t)`.
# The `Function` interface can be used to create lambda expressions that represent a function taking one argument and returning a result.
# The `Function` interface also provides default methods for composing functions, such as `andThen` and `compose`.
# These methods allow you to chain multiple functions together, enabling more complex transformations.
[]: # 
[]: # 1. **Mapping Values**: You can use the `Function` interface to map values from one type to another, such as converting a string to its length or transforming an object into a different representation.
[]: # 2. **Chaining Functions**: You can chain multiple functions together using the `andThen` method, allowing you to create a pipeline of transformations.
[]: # 3. **Higher-Order Functions**: You can pass functions as arguments to other functions, enabling functional programming paradigms in Java.
[]: # 
[]: # Example of Using Function Functional Interface
[]: # ```java
[]: # import java.util.function.Function;
[]: # public class FunctionExample {
[]: #     public static void main(String[] args) {
[]: #         // Using Function to convert a String to its length
[]: #         Function<String, Integer> stringLengthFunction = str -> str.length();
[]: #         // String is the input type (T) and Integer is the output type (R)
[]: #         // Applying the function
[]: #         String input = "Hello, World!";
[]: #         Integer length = stringLengthFunction.apply(input);
[]: #

example
```
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
[]: # 
[]: #         // Displaying the result
[]: #         System.out.println("Length of the string \"" + input + "\" is: " + length);// 13
[]: #     }
[]: # }
[]: # ```
# Function Functional Interface Methods
[]: # 
[]: # Real use cases of Function Functional Interface
[]: # 1. **Data Transformation**: You can use the `Function` interface to transform data from one format to another, such as converting a list of strings to a list of their lengths.
[]: # ```java
[]: # import java.util.ArrayList;
[]: # import java.util.List;
[]: # import java.util.function.Function;
[]: # public class DataTransformationExample {
[]: #     public static void main(String[] args) {
[]: #         List<String> names = new ArrayList<>();
[]: #         names.add("Alice");
[]: #         names.add("Bob");
[]: #         names.add("Charlie");
[]: #         names.add("David");
[]: # 
[]: #         // Using Function to convert each name to its length
[]: #         Function<String, Integer> stringLengthFunction = str -> str.length();
[]: # 
[]: #         // Transforming the list of names to their lengths
[]: #         List<Integer> lengths = transformNames(names, stringLengthFunction);
[]: # 
[]: #         // Displaying the lengths
[]: #         for (Integer length : lengths) {
[]: #             System.out.println(length);
[]: #         }
[]: #     }
[]: # 
[]: #     public static List<Integer> transformNames(List<String> names, Function<String, Integer> function) {
[]: #         List<Integer> result = new ArrayList<>();
[]: #         for (String name : names) {
[]: #             result.add(function.apply(name));
[]: #         }
[]: #         return result;
[]: #     }
[]: # }
[]: # ```
[]: # 2. **Chaining Functions**: You can chain multiple functions together using the `andThen` method, allowing you to create a pipeline of transformations.
[]: # ```java
[]: # import java.util.function.Function;
[]: # public class FunctionChainingExample {
[]: #     public static void main(String[] args) {
[]: #         // Function to convert a String to its length
[]: #         Function<String, Integer> stringLengthFunction = str -> str.length();
[]: #         // Function to convert the length to a String representation
[]: #         Function<Integer, String> lengthToStringFunction = length -> "Length: " + length;
[]: # 
[]: #         // Chaining functions using andThen
[]: #         Function<String, String> combinedFunction = stringLengthFunction.andThen(lengthToStringFunction);
[]: # 
[]: #         // Applying the combined function
[]: #         String input = "Hello, World!";
[]: #         String result = combinedFunction.apply(input);
[]: # 
[]: #         // Displaying the result
[]: #         System.out.println(result); // Length: 13
[]: #     }
[]: # }
[]: # }
[]: # ```
[]: # 3. **Higher
# -Order Functions**: You can pass functions as arguments to other functions, enabling functional programming paradigms in Java.
[]: # ```java
[]: # import java.util.ArrayList;
[]: # import java.util.List;
[]: # import java.util.function.Function;
[]: # public class HigherOrderFunctionExample {
[]: #     public static void main(String[] args) {
[]: #         List<String> names = new ArrayList<>();
[]: #         names.add("Alice");
[]: #         names.add("Bob");
[]: #         names.add("Charlie");
[]: #         names.add("David");
[]: # 
[]: #         // Function to convert each name to uppercase
[]: #         Function<String, String> toUpperCaseFunction = name -> name.toUpperCase();
[]: # 
[]: #         // Applying the function to each name
[]: #         List<String> upperCaseNames = applyFunctionToNames(names, toUpperCaseFunction);
[]: # 
[]: #         // Displaying the uppercased names
[]: #         for (String name : upperCaseNames) {
[]: #             System.out.println(name);
[]: #         }
[]: #     }
[]: # 
[]: #     public static List<String> applyFunctionToNames(List<String> names, Function<String, String> function) {
[]: #         List<String> result = new ArrayList<>();
[]: #         for (String name : names) {
[]: #             result.add(function.apply(name));
[]: #         }
[]: #         return result;
[]: #     }
[]: # }
[]: # ```
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class DataTransformationExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Using Function to convert each name to its length
        Function<String, Integer> stringLengthFunction = str -> str.length();

        // Transforming the list of names to their lengths
        List<Integer> lengths = transformNames(names, stringLengthFunction);

        // Displaying the lengths
        for (Integer length : lengths) {
            System.out.println(length);
        }
    }

    public static List<Integer> transformNames(List<String> names, Function<String, Integer> function) {
        List<Integer> result = new ArrayList<>();
        for (String name : names) {
            result.add(function.apply(name));
        }
        return result;
    }
}
```