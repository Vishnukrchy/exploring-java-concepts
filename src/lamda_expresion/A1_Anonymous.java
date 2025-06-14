package lamda_expresion;
/*
    * Anonymous class example
    * In this example, we create an anonymous class that implements the Runnable interface.
    * This allows us to define a thread's behavior without creating a separate class.
    * This is useful for quick, one-off implementations where we don't need to reuse the class elsewhere.
 */

import java.util.Comparator;
import java.util.function.Consumer;

public class A1_Anonymous {
    public static void main(String[] args) {
        // different ways to call the work method of Employee1 interface

        // By suing  implementation class
        Employee1 employee = new EmployeeImpl();
        employee.work(); // Employee is working

        // by  Using lambda expression // only works if the interface has only one abstract method (functional interface)
        // if we add another abstract method, it will not compile. then we have to create a implementation class or anonymous class  to implement the interface.

        // This is a functional interface because it has only one abstract method

        //Employee1 employeeLambda =()-> System.out.println("Employee is working using lambda expression");

        // when we add multiple methods in the interface => Multiple non-overriding abstract methods found in interface lamda_expresion. Employee

       // employeeLambda.work(); // Employee is working using lambda expression

        // By using anonymous class
      //  Employee1 employeeAnonymous = new Employee1() ;//Employee1' is abstract; cannot be instantiated

        Employee1 employeeAnonymous = new Employee1()
        {
            // This is an anonymous class  body that implements the Employee1 interface
            @Override
            public void work() {
                System.out.println("Employee is working using anonymous class");
            }

            @Override
            public int getSalary() {
                return 20000; // Example salary
            }

            @Override
            public String getName() {
                return "Vishnu Anonymous"; // Example name
            }
        };
        employeeAnonymous.work(); // Employee is working using anonymous class
        System.out.println("Salary: " + employeeAnonymous.getSalary()); // Salary: 20000
        System.out.println("Name: " + employeeAnonymous.getName()); // Name: Vishnu Anonymous
    }
}
interface  Employee1 {
    void work();
    // This is a functional interface because it has only one abstract method
    // It can be used with lambda expressions or anonymous classes to provide implementations.
    // Functional interfaces are used to represent a single abstract method (SAM) type, which can be implemented using lambda expressions or method references.
    //  // if we add another abstract method, it will not compile. then we have to create a implementation class  to implement the interface. method getSalary and getSalary() and  getName() are not abstract methods, they are default methods with implementation.
    // instead of using impl class we used anonymous class to implement the interface and avoid the implementation class to override the both method

    int getSalary();
    String getName();
}
// Implementation class
class EmployeeImpl implements Employee1 {
    @Override
    public void work() {
        System.out.println("Employee is working");
    }
    @Override
    public int getSalary() {
        return 50000; // Example salary
    }
    @Override
    public String getName() {
        return "Vishnu"; // Example name
    }
}

// List of functional interfaces in Java:
// 1. Runnable: Represents a task that can be executed by a thread.
// 2. Callable: Similar to Runnable, but can return a result and throw exceptions.
// 3. Comparator: Used to compare two objects for sorting.
// 4. Consumer: Represents an operation that takes a single input argument and returns no result.
// 5. Supplier: Represents a supplier of results, providing a method to get a value.
// 6. Function: Represents a function that takes one argument and produces a result.
// 7. Predicate: Represents a boolean-valued function of one argument, often used for filtering.
// 8. BiFunction: Represents a function that takes two arguments and produces a result.
// 9. BiConsumer: Represents an operation that takes two input arguments and returns no result.

class  ListOfFunctionalInterfaces {
    public static void main(String[] args) {
        // Example usage of functional interfaces
        Runnable runnable = () -> System.out.println("Running a task using Runnable");
        runnable.run(); // Running a task using Runnable

        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("apple", "banana")); // Output: -1 (apple is less than banana)

        Consumer<String> consumer = s -> System.out.println("Consuming: " + s);
        consumer.accept("Hello, World!"); // Consuming: Hello, World!
    }
}

// Note: The above code demonstrates the use of functional interfaces and anonymous classes in Java.
// Functional interfaces are a key feature of Java 8 and later versions, enabling the use of lambda expressions and method references for more concise and readable code.
// Anonymous classes allow for quick implementations of interfaces or abstract classes without the need for a separate named class.
// This can be particularly useful for one-off implementations or when you want to keep the code concise and focused on a specific task.

class MyList{
    // This is a custom list class that can be used to store elements.
    // It can be implemented using an array or a linked list, depending on the requirements.
    // For simplicity, we will use an array-based implementation here.

    private Object[] elements;
    private int size;

    public MyList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    public void add(Object element) {
        if (size < elements.length) {
            elements[size++] = element;
        } else {
            System.out.println("List is full");
        }
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public int size() {
        return size;
    }
}
