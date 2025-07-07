# Method Reference in Java
 ist a shorthand notation of a lambda expression to call a method.
 its a way to refer to a method without executing it.
 we can use method reference to refer to a method of a class or an instance of a class.
 
Example 1: Static Method Reference
```java
import java.util.function.Consumer;
class StaticMethodReferenceExample {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        // Using method reference to refer to a static method
        Consumer<String> consumer = StaticMethodReferenceExample::printMessage;
        
        // Applying the consumer
        consumer.accept("Hello, World!"); // Output: Hello, World!
    }
}
```
```java
class exa{
main(String[] args){
      List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Using method reference to refer to a static method
        names.forEach(StaticMethodReferenceExample::printMessage);
}
}
```
using method reference to refer to a static method
```java
import java.util.Arrays;
import java.util.List;
class StaticMethodReferenceExample {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Using method reference to refer to a static method
        names.forEach(StaticMethodReferenceExample::printMessage);
        
        
    }
}
```

