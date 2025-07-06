# Supplier Interface Functional Interface
# => The Supplier interface is a functional interface in Java that represents a supplier of results.
# => It is defined in the java.util.function package and has a single abstract method get().
# => The get() method does not take any arguments and returns a value of type T.
# => The Supplier interface is often used to generate values or provide instances of a class without requiring any input.
# => It can be used with lambda expressions to create concise and readable code.

# ```java
class SupplierExample {
    public static void main(String[] args) {
        // Using Supplier to generate a random number
        Supplier<Double> randomNumberSupplier = () -> Math.random();
        
        // Getting a random number
        Double randomNumber = randomNumberSupplier.get();
        
        // Displaying the random number
        System.out.println("Random Number: " + randomNumber);
    }
}
```
# ```java
import java.util.function.Supplier;
class SupplierExample {
    public static void main(String[] args) {
        // Using Supplier to provide a greeting message
        Supplier<String> greetingSupplier = () -> "Hello, World!";
        
        // Getting the greeting message
        String greeting = greetingSupplier.get();
        
        // Displaying the greeting message
        System.out.println(greeting); // Output: Hello, World!
    }
}
```
# ```java
class ExampleSupplier {
    public static void main(String[] args) {
        // Using Supplier to create a new instance of a class
        Supplier<Student> studentSupplier = () -> new Student("John Doe", 20);
        
        // Getting the student instance
        Student student = studentSupplier.get();
        
        // Displaying the student's information
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
    }
}
