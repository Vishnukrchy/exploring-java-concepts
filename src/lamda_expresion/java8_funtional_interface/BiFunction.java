package lamda_expresion.java8_funtional_interface;

import javax.swing.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/*
    * BiFunction is a functional interface that represents a function that takes two arguments and produces a result.
    * It has a single abstract method apply(T t, U u) that takes two arguments of types T and U and returns a value of type R.
    * It is often used for combining or transforming two inputs into a single output.
    * It is part of the java.util.function package and can be used with lambda expressions or method references.
    * BiFunction is often used in functional programming to create functions that operate on two inputs, such as combining two values, performing calculations, or transforming data.
    * It is also used in scenarios where two inputs need to be processed together, such as in map-reduce operations or data transformations.
    *
 */
class E_BiFunction {
    public static void main(String[] args) {
        // how generally we used Function for single argument like this
        Function<Integer,Integer> squareFunction = num -> num * num;
        System.out.println("Square of 5: " + squareFunction.apply(5)); // Square of 5: 25
        // what if we want to combine two arguments like adding two numbers
        BiFunction<Integer, Integer, Integer> addFunction = (num1, num2) -> num1 + num2;
        System.out.println("Sum of 5 and 10: " + addFunction.apply(5,10)); // Sum of 5 and 10: 15
        // notes first argument is Integer and second argument is Integer and return type is also Integer
        // Using BiFunction to concatenate two strings
        BiFunction<String ,String,String> concatenateFunction =(str1,str2)->str1+str2;
        System.out.println("Concatenation of 'Hello' and 'World': " + concatenateFunction.apply("Hello", " World")); // Concatenation of 'Hello' and 'World': Hello World
        // Using BiFunction to calculate the area of a rectangle
        BiFunction<Double, Double, Double> areaFunction = (length, width) -> length * width;
        System.out.println("Area of rectangle with length 5.0 and width 3.0: " + areaFunction.apply(5.0, 3.0)); // Area of rectangle with length 5.0 and width 3.0: 15.0
        // Using BiFunction to calculate the total price of items with quantity and price per item
        BiFunction<Integer, Double, Double> totalPriceFunction = (quantity, pricePerItem) -> quantity * pricePerItem;
        System.out.println("Total price for 3 items at $20.0 each: " + totalPriceFunction.apply(3, 20.0)); // Total price for 3 items at $20.0 each: 60.0
        // Using BiFunction to create a Student object from name and age
        BiFunction<String, Integer, Student> studentFunction = (name, age) -> new Student(name, age);
        Student student = studentFunction.apply("Alice", 20);
        System.out.println("Student Name: " + student.getName() + ", Age: " + student.getAge()); // Student Name: Alice, Age: 20

        // Compare Two Students student List by their age
        BiFunction<Student, Student, String> compareStudentsByAge = (student1, student2) -> {
            if (student1.getAge() > student2.getAge()) {
                return student1.getName() + " is older than " + student2.getName();
            } else if (student1.getAge() < student2.getAge()) {
                return student1.getName() + " is younger than " + student2.getName();
            } else {
                return student1.getName() + " and " + student2.getName() + " are of the same age";
            }
        };
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Bob", 22);
        System.out.println(compareStudentsByAge.apply(student1, student2)); // Alice is younger than Bob

        //by using streams
        List<Student> students = List.of(
                new Student("Alice", 20),
                new Student("Bob", 22),
                new Student("Charlie", 21)
        );
        BiFunction<List<Student>, Integer, List<Student>> filterStudentsByAge = (studentList, age) -> {
            return studentList.stream()
                    .filter(std->std.getAge()>age)
                    .toList();
        };
        List<Student> filteredStudents = filterStudentsByAge.apply(students,20);

        // now compare the two students list by threir age and name
        BiFunction<List<Student>, List<Student>, List<Student>> compareStudentLists = (list1, list2) -> {
           if (list1.size()!=list2.size()) return List.of();

           for (int i = 0; i < list1.size(); i++) {
               Student std1 = list1.get(i);
               Student std2 = list2.get(i);
               if (!std1.getName().equals(std2.getName()) || std1.getAge() != std2.getAge()) {
                   return List.of();
               }else {
                   return List.of(std1,std2);
               }
           }
           return List.of();
        };

        // using Streams to compare two lists of students
        BiFunction<List<Student>, List<Student>, List<Student>> compareStudentListsStream = (list1, list2) -> {
            if (list1.size() != list2.size())return List.of();
            return list1.stream()
                    .filter(std1->list2.stream()
                            .anyMatch(std2->std1.getName().equals(std2.getName()) && std1.getAge() == std2.getAge()))
                    .collect(Collectors.toList());


        };
        List<Student> studentList1 = List.of(
                new Student("Alice", 20),
                new Student("Bob", 22)
        );
        List<Student> studentList2 = List.of(
                new Student("Alice", 20),
                new Student("Bob", 22)
        );
        List<Student> comparedStudents = compareStudentLists.apply(studentList1, studentList2);
        System.out.println("Compared Students: " + comparedStudents.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "))); // Compared Students: Alice, Bob



    }
    public static class Student{
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
