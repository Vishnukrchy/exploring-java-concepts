package lamda_expresion.java8_funtional_interface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
 // BiPredicate is a functional interface that represents a predicate (boolean-valued function) of two arguments.
        // It has a single abstract method test(T t, U u) that takes two arguments of types T and U and returns a boolean value.
        // It is often used for filtering or matching conditions based on two inputs.
        // BiPredicate can be used with lambda expressions or method references.
 */
public class E1_BiPredicate {
    public static void main(String[] args) {
        // generally we used Predicates for single argument like this
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        // what if we want to check two arguments like isEven and isGreaterThan 10
        BiPredicate<Integer, Integer> isEvenAndGreaterThan = (num, threshold) -> num % 2 == 0 && num > threshold;
        System.out.println("Is 4 even and greater than 10? " + isEvenAndGreaterThan.test(4, 10)); // false

        // Using BiPredicate to check if two strings are equal
        BiPredicate<String, String> areEqual = (str1, str2) -> str1.equals(str2);
        System.out.println("Are 'hello' and 'hello' equal? " + areEqual.test("hello", "hello")); // true

        //check if two numbers are equal
        BiPredicate<Integer, Integer> areNumbersEqual = (num1, num2) -> num1.equals(num2);
        System.out.println("Are 5 and 5 equal? " + areNumbersEqual.test(5, 5)); // true

        // check two employee list is equal or not
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", 30),
                new Employee("Bob", 25)
        );
        List<Employee> employees2 = Arrays.asList(
                new Employee("Alice", 30),
                new Employee("Bob", 25)
        );
        // Using BiPredicate to check if two lists of employees are equal
        BiPredicate<List<Employee>, List<Employee>> areEmployeeListsEqual = (list1,list2)->{
            if (list1.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list1.size(); i++) {
                Employee emp1 = list1.get(i);
                Employee emp2 = list2.get(i);
                if (!emp1.getName().equals(emp2.getName()) || emp1.getAge() != emp2.getAge()) {
                    return false;
                }
            }
            return true;
        };
        System.out.println("Are employee lists equal? " + areEmployeeListsEqual.test(employees1, employees2)); // true
        // by using streams
        List<Employee> employees3 = Arrays.asList(
                new Employee("Alice", 30),
                new Employee("Bob", 25)
        );
        List<Employee> employees4 = Arrays.asList(
                new Employee("Alice", 30),
                new Employee("Bob", 25)
        );
        // Using streams to check if two lists of employees are equal
        BiPredicate<List<Employee>,List<Employee>>  areEmployeeListsEqualStream =  (list1, list2) -> {
            if (list1.size() != list2.size()) {
                return false;
            }
            return list1.stream().allMatch(emp1->
                      list2.stream().anyMatch(emp2->
                              emp1.getName().equals(emp2.getName()) && emp1.getAge() == emp2.getAge()));
//            return list1.stream().allMatch(emp1 ->
//                    list2.stream().anyMatch(emp2 ->
//                            emp1.getName().equals(emp2.getName()) && emp1.getAge() == emp2.getAge()));
        };

        System.out.println("Are employee lists equal using streams? " + areEmployeeListsEqualStream.test(employees3, employees4)); // true




    }
    public  static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
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
