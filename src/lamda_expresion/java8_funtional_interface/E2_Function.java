package lamda_expresion.java8_funtional_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
Uses of Function interface in Java 8 in stream API and lambda expressions.
 */
public class E2_Function {
    public static void main(String[] args) {
        Function<String,Integer> stringToLength = s -> s.length();
        System.out.println(stringToLength.apply("Hello")); // 5
        Function<String, String> substringFunction = s -> s.substring(0, 3);
        System.out.println(substringFunction.apply("Hello World")); // Hello

        // Using Function to convert a string to its uppercase
        Function<String, String> toUpperCaseFunction = String::toUpperCase;
        System.out.println(toUpperCaseFunction.apply("hello")); // HELLO

        //Function apply() basically takes an input and returns a value.
        // its works as  functional interface that represents a single argument function that returns a value.
        Function<Student, String> studentToName = student -> student.getName();
        System.out.println(studentToName.apply(new Student("Alice", 20))); // Alice
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 21));
        students.add(new Student("David", 19));
        ArrayList<String> studentNames = new ArrayList<>();

        // Function is using to whose  age is greater than 20
//        for (Student student : students) {
//            if (student.getAge() > 20) {
//                studentNames.add(studentToName.apply(student));
//            }
//        }
          Function<List<Student>,Boolean> isGreaterThan20 = std->std.stream()
                .anyMatch(student -> student.getAge() > 20);
        for (Student student : students) {
            if (isGreaterThan20.apply(students)) {
                studentNames.add(studentToName.apply(student));
            }
        }
        System.out.println("Student names with age greater than 20: " + studentNames); // [Bob, Charlie]
        // Student names whose age is greater than 20 and  contains 'a'

        Function<List<Student>,List<Student>> studentsWithAgeGreaterThan20 = std ->
        {
            ArrayList<Student> filteredStudents = new ArrayList<>();
            for (Student student:std){
                if (isGreaterThan20.apply(std) && student.getName().contains("a")) {
                    filteredStudents.add(student);
                }
            }
            return filteredStudents;
        };
        System.out.println("Students with age greater than 20 and name contains 'a': " + studentsWithAgeGreaterThan20.apply(students)); // [Bob, Charlie]

        Function<List<Student>, List<String>> studentNamesWithAgeGreaterThan20 = std ->
                std.stream()
                .filter(student -> student.getAge() > 20 && student.getName().contains("a"))
                .map(studentToName)//here map is used to convert the Student object to its name
                .toList();


    }

    public  static class Student {
        private String name;
        private int age;

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
    }
}
