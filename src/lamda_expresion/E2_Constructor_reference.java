package lamda_expresion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
:: is used to refer to a constructor in Java.
 */
public class E2_Constructor_reference {
    // Constructor reference is a shorthand notation of a lambda expression to call a constructor.
    // It is used to refer to a constructor without executing it.
    // It can be used to refer to a constructor of a class.
    // It is often used in conjunction with functional interfaces.

    public E2_Constructor_reference() {
        System.out.println("Default Constructor called");
    }

    public E2_Constructor_reference(String message) {
        System.out.println("Parameterized Constructor called with message: " + message);
    }

    public static void main(String[] args) {
        java.util.function.Supplier<E2_Constructor_reference> supplier = E2_Constructor_reference::new;
        E2_Constructor_reference instance = supplier.get(); // Creates an instance of E2_Constructor_reference

        java.util.function.Function<String, E2_Constructor_reference> function = E2_Constructor_reference::new;
        E2_Constructor_reference instanceWithParam = function.apply("Hello");
        System.out.println("Instance created: " + instance);
        System.out.println("Instance with parameter created: " + instanceWithParam);

        // Using constructor reference to create an instance of Student class
        java.util.function.Supplier<Student> studentSupplier = Student::new;
        Student student = studentSupplier.get(); // Creates an instance of Student with default values
        System.out.println("Student Name: " + student.getName() + ", Age: " + student.getAge());

        // Using constructor reference to create an instance of Student class with a name
        java.util.function.Function<String, Student> studentFunction = Student::new;
        Student studentWithName = studentFunction.apply("John Doe");
        System.out.println("Student Name: " + studentWithName.getName() + ", Age: " + studentWithName.getAge());
        // Using constructor reference to create an instance of Student class with a name and age
        java.util.function.BiFunction<String, Integer, Student> studentBiFunction = Student::new;
        Student studentWithNameAndAge = studentBiFunction.apply("Jane Doe", 22);

        System.out.println("Student Name: " + studentWithNameAndAge.getName() + ", Age: " + studentWithNameAndAge.getAge());

        // List of students using constructor reference
        List<Student> students= Arrays.asList(
                new Student("Alice", 20),
                new Student("Bob", 22),
                new Student("Charlie", 21),
                new Student("David", 19)
        );
        // Using method reference to print student names
        students.forEach(studentItem -> System.out.println("Student Name: " + studentItem.getName() + ", Age: " + studentItem.getAge()));
        // Using constructor reference to create a new Student instance for each student in the list
        java.util.function.Function<Student, Student> studentCreator = Student::new;
        List<Student> newStudents = students.stream()
                .map(studentCreator)
                .toList();
        System.out.println("New Students List: ");
        newStudents.forEach(newStudent -> System.out.println("Student Name: " + newStudent.getName() + ", Age: " + newStudent.getAge()));

        List<String> studentList = Arrays.asList("Alice", "Bob", "Charlie", "David");


      List<Student> students1  =studentList.stream()
                .map(std->new Student(std)) // Using constructor reference to create a new Student instance for each name
                .collect(Collectors.toList());
      students1.forEach(studentItem -> System.out.println("Student Name: " + studentItem.getName() + ", Age: " + studentItem.getAge()));




    }
    public static  class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Student() {
            this.name = "Default Name";
            this.age = 18;
        }
        public Student(String name) {
            this.name = name;
        }

        public Student(Student student) {
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
