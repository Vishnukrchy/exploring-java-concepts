# Unary and Binary Operator
 its a special type of functional interface in Java that represents a single operand operation.
# It is part of the `java.util.function` package and is commonly used in scenarios where you need to perform operations on a single operand, such as negation or incrementing a value.

example:
```java
import java.util.function.UnaryOperator;
class UnaryOperatorExample {
    public static void main(String[] args) {
        // Using UnaryOperator to increment a number
        UnaryOperator<Integer> increment = x -> x + 1;
        
        // Applying the UnaryOperator
        int result = increment.apply(5);
        
        // Displaying the result
        System.out.println("Incremented Value: " + result); // Output: Incremented Value: 6
    }
}
```
```java
import java.util.function.UnaryOperator;
class UnaryOperatorExample {
    public static void main(String[] args) {
        // Using UnaryOperator to convert a string to uppercase
        UnaryOperator<String> toUpperCase = str -> str.toUpperCase();
        
        // Applying the UnaryOperator
        String result = toUpperCase.apply("hello");
        
        // Displaying the result
        System.out.println("Uppercase String: " + result); // Output: Uppercase String: HELLO
    }
}
```
```java
import java.util.function.UnaryOperator;
class UnaryOperatorExample {
    public static void main(String[] args) {
        // Using UnaryOperator to negate a boolean value
        UnaryOperator<Boolean> negate = bool -> !bool;
        
        // Applying the UnaryOperator
        boolean result = negate.apply(true);
        
        // Displaying the result
        System.out.println("Negated Value: " + result); // Output: Negated Value: false
    }
}
```
```java
import java.util.function.UnaryOperator;
class UnaryOperatorExample {
    public static void main(String[] args) {
        // Using UnaryOperator to square a number
        UnaryOperator<Integer> square = x -> x * x;
        
        // Applying the UnaryOperator
        int result = square.apply(4);
        
        // Displaying the result
        System.out.println("Squared Value: " + result); // Output: Squared Value: 16
    }
}
```