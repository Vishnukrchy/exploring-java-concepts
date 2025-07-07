package stream_api.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E2_Stream_Like_Sql {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1, "Alice", "HR", 50000, 30, "New York"),
                new Employee(2, "Bob", "IT", 60000, 28, "San Francisco"),
                new Employee(3, "Charlie", "Finance", 70000, 35, "Los Angeles"),
                new Employee(4, "David", "HR", 55000, 32, "Chicago"),
                new Employee(5, "Eve", "IT", 65000, 29, "Seattle"),
                new Employee(6, "Frank", "Finance", 75000, 36, "Miami")
        );
        // understand how to use Stream API like SQL queries
        // Filtering
        /**
         * select * from table where condition
         */
        // in stream api we can use filter method to filter the elements based on a condition
        List<Employee> filterBasedOnAge = employeeList.stream()
                .filter(employee -> employee.getAge() > 20)
                .collect(Collectors.toList());
        System.out.println("Employees older than 20: " + filterBasedOnAge);
        
        List<Employee> filterBasedOnDepartment = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .toList();
        System.out.println("Employees in IT department: " + filterBasedOnDepartment);
        
        // Selecting specific fields
        /**
         * select name, age from table
         */
        // in stream api we can use map method to transform the elements to a specific type
        employeeList.stream()
                .map(employee -> employee.getName() + ", " + employee.getAge())
                .forEach(System.out::println); // print each employee's name and age

        List<String> list = employeeList.stream()
                .map(employee -> employee.getSalary() > 60000 ? employee.getName() : "Not Eligible")
                .toList();
        System.out.println("Employees with salary greater than 60000: " + list);

        // select * from table where
        List<Employee> employeesBasedOnsalry = employeeList.stream()
                .filter(employee -> employee.getSalary() > 60000 && employee.getAge() < 35)
                .map(Employee::new)
                .toList();
        System.out.println("Employees with salary greater than 60000 and age less than 35: " + employeesBasedOnsalry);

        // aggregation
        // select count(*), avg(salary) from table
        long count = employeeList.stream().count(); // count of employees
        employeeList.stream()
                //.mapToDouble(Employee::getSalary) // map to salary
                .mapToDouble(emp->emp.getSalary()) // map to salary
                .average() // calculate average salary
                .ifPresent(avg -> System.out.println("Average Salary: " + avg)); // print average salary

        double averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary) // map to salary
                .average() // calculate average salary
                .orElse(0.0); // if no employees, return 0.0
        System.out.println("Average Salary: " + averageSalary);


        // Grouping data
        /**
         * select department, count(*) from table group by department
         */
        // in stream api we can use collect method with groupingBy collector to group the elements by a specific field
        Map<String,Long> employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
               // .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        System.out.println("Employees grouped by department: " + employeesByDepartment);
        Map<String, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employees grouped by city: " + collect);

        //Employee with 20+ age and salary greater than 60000
        List<Employee> employeesWithAgeAndSalary = employeeList.stream()
                .filter(employee -> employee.getAge() > 20 && employee.getSalary() > 60000)
                .collect(Collectors.toList());


        //sorting data
        /**
         * select * from table order by salary desc
         */
        // in stream api we can use sorted method to sort the elements by a specific field
        Stream<Employee> sorted = employeeList.stream()
                .filter(employee -> employee.getSalary() > 60000)
                // .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // sort by salary in descending order
                //using lambda expression
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        // sort by salary in descending order
        System.out.println("Employees with salary greater than 60000 sorted by salary in descending order: ");
        sorted.forEach(employee -> System.out.println(employee.getName() + ": " + employee.getSalary()));
        // we can also sort by multiple fields
        /**
         * select * from table order by department, salary desc
         */
        List<Employee> sortedByDepartmentAndSalary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()))
                .collect(Collectors.toList());
        System.out.println("Employees sorted by department and salary in descending order: ");
        sortedByDepartmentAndSalary.forEach(employee ->
                System.out.println(employee.getDepartment() + ": " + employee.getName() + ", " + employee.getSalary()));



        // Combining operations
        /**
         * select name, age from table where age > 20 order by salary desc
         */
        List<String> combinedOperations = employeeList.stream()
                .filter(employee -> employee.getAge() > 20)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(employee -> employee.getName() + ", " + employee.getAge())
                .collect(Collectors.toList());
        System.out.println("Employees older than 20 sorted by salary in descending order: " + combinedOperations);
        // Using limit and skip
        /**
         * select * from table limit 5 offset 2
         */
        List<Employee> limitedEmployees = employeeList.stream()
                .filter(employee -> employee.getAge() > 20)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(2) // skip the first 2 employees
                .limit(5) // limit to 5 employees
                .collect(Collectors.toList());
        System.out.println("Employees older than 20 sorted by salary in descending order, skipping first 2 and limiting to 5: " + limitedEmployees);
        // Using distinct
        /**
         * select distinct department from table
         */
        List<String> distinctDepartments = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct() // remove duplicates
                .collect(Collectors.toList());
        System.out.println("Distinct Departments: " + distinctDepartments);
        // Using peek for debugging
        /**
         * select * from table where condition
         */
        employeeList.stream()
                .filter(employee -> employee.getSalary() > 60000)
                .peek(employee -> System.out.println("Debugging: " + employee.getName() + ", " + employee.getSalary())) // print each employee's name and salary
                .collect(Collectors.toList()); // collect the result into a list
        // Using flatMap
        /**
         * select * from table1, table2 where condition
         */
        List<Employee> employeeList1 = List.of(
                new Employee(1, "Alice", "HR", 50000, 30, "New York"),
                new Employee(2, "Bob", "IT", 60000, 28, "San Francisco")
        );
        List<Employee> employeeList2 = List.of(
                new Employee(3, "Charlie", "Finance", 70000, 35, "Los Angeles"),
                new Employee(4, "David", "HR", 55000, 32, "Chicago")
        );
        // Using flatMap to combine two lists of employees and filter based on salary
        List<Employee> combinedEmployeeList = Stream.of(employeeList1, employeeList2)
                .flatMap(List::stream) // flatten the lists into a single stream
                .filter(employee -> employee.getSalary() > 60000) // filter employees with salary greater than 60000
                .collect(Collectors.toList()); // collect the result into a list
        System.out.println("Combined Employees with salary greater than 60000: " + combinedEmployeeList);
        // example 2
        // based on the previous example, we can use flatMap to combine two lists of employees and filter based on age
        List<Employee> itList = Stream.of(employeeList1, employeeList2)
                .flatMap(List::stream) // flatten the lists into a single stream
                .filter(employee -> employee.getAge() > 30 && employee.department.equals("IT")) // filter employees with age greater than 30 and department IT
                .collect(Collectors.toList());// collect the result into a list

        System.out.println("Combined Employees with age greater than 30 and department IT: " + itList);
        //example 3
        List<String> list1 = Stream.of(employeeList1, employeeList2)
                .flatMap(List::stream)// flatten the lists into a single stream
                .filter(employee -> employee.getAge() > 30 && employee.getSalary() > 60000) // filter employees with age greater than 30 and salary greater than 60000
                .map(employee -> employee.getName() + ", " + employee.getAge() + ", " + employee.getSalary()) // map to name, age and salary
                .distinct() // remove duplicates
                .sorted(Comparator.comparing(String::toString)) // sort by name
                .toList();
        System.out.println("Combined Employees with age greater than 30 and salary greater than 60000: " + list1);
        // sorted by lambda expression
        List<String> sortedList = Stream.of(employeeList1, employeeList2)
                .flatMap(List::stream) // flatten the lists into a single stream
                .filter(employee -> employee.getAge() > 30 && employee.getSalary() > 60000) // filter employees with age greater than 30 and salary greater than 60000
                .map(employee -> employee.getName() + ", " + employee.getAge() + ", " + employee.getSalary()) // map to name, age and salary
                .distinct() // remove duplicates
                .sorted((s1, s2) -> s2.compareTo(s1)) // sort by name using lambda expression
                .toList();
        System.out.println("Combined Employees with age greater than 30 and salary greater than 60000: " + list1);



        // Using reduce for aggregation
        /**
         * select sum(salary) from table
         */
        double totalSalary =employeeList.stream()
                .mapToDouble(Employee::getSalary) // map to salary to get a DoubleStream
                .reduce(0.0, Double::sum); // reduce to sum the salaries
        System.out.println("Total Salary of all employees: " + totalSalary);
        // Using findFirst
        /**
         * select * from table where condition limit 1
         */
        Employee firstEmployee = employeeList.stream()
                .filter(employee -> employee.getAge() > 30) // filter employees older than 30
                .findFirst() // find the first employee that matches the condition
                .orElse(null); // if no employee found, return null
        System.out.println("First Employee older than 30: " + (firstEmployee != null ? firstEmployee.getName() : "No employee found"));
        // Using anyMatch
        /**
         * select * from table where condition limit 1
         */
        boolean hasEmployeeInIT = employeeList.stream()
                .anyMatch(employee -> employee.getDepartment().equals("IT")); // check if any employee is in IT department
        System.out.println("Is there any employee in IT department? " + hasEmployeeInIT);
        // Using allMatch
        /**
         * select * from table where condition limit 1
         */
        boolean allEmployeesInHR = employeeList.stream()
                .allMatch(employee -> employee.getDepartment().equals("HR")); // check if all employees are in HR department
        // collecting the result into a list
        System.out.println("Are all employees in HR department? " + allEmployeesInHR);
        // Using noneMatch
        /**
         * select * from table where condition limit 1
         */
        boolean noEmployeesInFinance = employeeList.stream()
                .noneMatch(employee -> employee.getDepartment().equals("Finance")); // check if no employee is in Finance department
        System.out.println("Are there no employees in Finance department? " + noEmployeesInFinance);


        // Using toArray
        /**
         * select * from table
         */
        Employee[] employeeArray = employeeList.stream()
                .filter(employee -> employee.getAge() > 20) // filter employees older than 20
                .toArray(Employee[]::new); // collect the result into an array






    }
}
