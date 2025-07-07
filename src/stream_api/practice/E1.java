package stream_api.practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E1 {
    public static void main(String[] args) {
        //  Compare two Employer List based on their properties name using Stream API
        Employee emp1 = new Employee(1, "Alice", "HR", 50000, 30, "New York");
        Employee emp2 = new Employee(2, "Bob", "IT", 60000, 28, "San Francisco");
        Employee emp3 = new Employee(3, "Charlie", "Finance", 70000, 35, "Los Angeles");

        List<Employee> employeeList1 = List.of(emp1, emp2, emp3);
        List<Employee> employeeList2 = List.of(
                new Employee(4, "David", "HR", 55000, 32, "Chicago"),
                new Employee(5, "Eve", "IT", 65000, 29, "Seattle"),
                new Employee(6, "Frank", "Finance", 75000, 36, "Miami")
        );
        // Using Stream API to compare two employee lists based on their names
        List<Employee> collect = employeeList1.stream()
                .filter(empl1 -> employeeList2.stream()
                        .anyMatch(empl2 -> empl1.getName().equals(empl2.getName())))
                .distinct() // remove duplicates
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName())) // sort by name
                .peek(System.out::println) // print each employee
                .collect(Collectors.toList());
        System.out.println("Compared Employees: " + collect.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "))); // Join names of compared employees



    }

}
