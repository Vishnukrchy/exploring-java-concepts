# Difference between Annoyances and lambda expression
# Annoyances in Java
## In Java, "annoyances" often refer to the boilerplate code and verbosity that can make the code less readable and harder to maintain. Before Java 8, many common tasks required writing a lot of code, such as creating anonymous classes for simple operations like sorting or filtering collections.
## Example of Annoyances
// Before Java 8, sorting a list of strings required creating an anonymous class that implements the `Comparator` interface. This can be verbose and cumbersome, especially for simple comparisons. 
// With the introduction of lambda expressions in Java 8, we can simplify this process significantly.
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class AnnoyancesExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        names.sort((o1, o2) -> o1.compareTo(o2));
        // Using an anonymous class to sort the to overhead of creating a separate class for implementing Comparator method
        Collections.sort(names, new Comparator<String>()
        {
            //  This is Anonymous class implementation of Comparator interface and overrides the compare method
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        // Displaying sorted list
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

# Lambda Expressions in Java
## Lambda expressions are a feature introduced in Java 8 that allow you to write concise and expressive code. They enable you to treat functionality as a method argument, or to create a more functional style of programming.
## Example of Lambda Expressions
```java
import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;
public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Using lambda expression to sort the list
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));

        // Displaying sorted list
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```
# Key Differences
1. **Syntax**: Lambda expressions have a more concise syntax compared to anonymous classes. They eliminate the need for boilerplate code, making the code cleaner and easier to read.
2. **Functionality**: Lambda expressions can be used to implement functional interfaces (interfaces with a single abstract method) directly, without the need for creating an anonymous class.
3. **Readability**: Lambda expressions improve code readability by reducing the amount of code needed to perform operations like sorting, filtering, and mapping collections.
4. **Performance**: Lambda expressions can lead to better performance in some cases, as they can be optimized by the Java compiler and runtime. They also reduce the overhead of creating anonymous classes.

#  Conclusion
  We genrlly used lamda exprincesion  with fucntion interface  to implete this interface. abtract method 
  but lamda onlly used for functional interface.whcih has only one abstract method. but what if we have multiple abstract methods in an interface? In such cases, we cannot use lambda expressions, and we have to implement the interface using an anonymous class or a regular class.
  so conclusion is that lambda expressions are a powerful feature in Java that can help reduce boilerplate code and improve readability, especially when working with functional interfaces. They are not a replacement for all types of classes or interfaces, but they provide a more concise way to express certain types of functionality.
 Anonamous classes are still useful when you need to implement multiple methods or when you need to maintain state across method calls. However, for simple operations, lambda expressions are often the preferred choice due to their simplicity and clarity.

Example of Lambda Expression with Functional Interface
```java

interface Employee {
    int getSalary();
    // This is a functional interface with a single abstract method getSalary
    // If we add another abstract method, it will not compile. if @FunctionalInterface annotation is used then it will throw compile time error.
    // If we add another abstract method, its not a functional interface anymore and we have to create a implementation class to implement the interface.
    String getName(); // This will make it non-functional interface
}

public class LambdaFunctionalInterfaceExample {
    public static void main(String[] args) {
        // Using lambda expression to implement the functional interface
        Employee employee = () -> 50000;// This lambda expression provides the implementation for the getSalary method only working if the interface has only one abstract method.
        // This is a functional interface with a single abstract method getSalary
        // if we add another abstract method, it will not compile. then we have to create a implementation class  to implement the interface. method getSalary and getName
        // instead of using impl class we used anonymous class to implement the interface and avoid the implementation class to override the both method
        //like this
        Employee employeeWithName = new Employee() {
            @Override
            public int getSalary() {
                return 50000;
            }

            public String getName() {
                return "John Doe";
            }
        };
       
        // Displaying the salary
        System.out.println("Employee Salary: " + employee.getSalary());
    }
}
```

