# different methods of stream
[]: # The Stream API is a powerful feature introduced in Java 8 that allows you to process sequences of elements in a functional style. It provides a wide range of operations for filtering, mapping, and reducing data, making it easier to write concise and readable code. Understanding the key features and operations of the Stream API is essential for effective data processing in Java.

# Methods of Stream
[]: # The Stream API provides a rich set of methods to perform various operations on streams. Here are some of the key methods categorized by their functionality:
[]: # 
[]: # ## Intermediate Operations
[]: # These operations return a new stream and do not modify the original stream.
[]: # - `filter(Predicate<? super T> predicate)`: Filters elements based on a condition.
[]: # - `map(Function<? super T, ? extends R> mapper)`: Transforms elements by applying a function.
[]: # - `flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`: Flattens nested streams into a single stream.
[]: # - `distinct()`: Removes duplicate elements from the stream.
[]: # - `sorted()`: Sorts the elements in natural order or using a custom comparator.
[]: # - `peek(Consumer<? super T> action)`: Performs an action on each element without modifying the stream.
[]: # - `limit(long maxSize)`: Limits the number of elements in the stream.
[]: # - `skip(long n)`: Skips the first n elements in the stream.

# example
class StreamApiMethodsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Intermediate operations
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                 map(s->s.toUpperCase())
                //.map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered and Sorted Names: " + filteredNames);
    }
}
[]: # 
[]: # ## Terminal Operations
[]: # These operations produce a result or a side effect and terminate the stream.
[]: # - `collect(Collector<? super T, A, R> collector)`: Collects elements into a collection or other data structure.
[]: # - `forEach(Consumer<? super T> action)`: Performs an action on each element of the stream.
[]: # - `reduce(T identity, BinaryOperator<T> accumulator)`: Combines elements using a binary operator.
[]: # - `count()`: Returns the number of elements in the stream.
[]: # - `anyMatch(Predicate<? super T> predicate)`: Checks if any element matches a condition.
[]: # - `allMatch(Predicate<? super T> predicate)`: Checks if all elements match a condition.
[]: # - `noneMatch(Predicate<? super T> predicate)`: Checks if no elements match a condition.
[]: # - `findFirst()`: Returns the first element of the stream, if present.
[]: # - `findAny()`: Returns any element of the stream, if present.
[]: # - `toArray()`: Converts the stream to an array.
[]: # - `min(Comparator<? super T> comparator)`: Finds the minimum element based on a comparator.
[]: # - `max(Comparator<? super T> comparator)`: Finds the maximum element based on a comparator.
[]: # 
[]: # ## Example of Stream Methods
class StreamEx{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Intermediate operations
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered and Sorted Names: " + filteredNames);

        // Terminal operations
        long count = names.stream().count();
        System.out.println("Total Names: " + count);

        String firstName = names.stream().findFirst().orElse("No names found");
        System.out.println("First Name: " + firstName);
    }
}
[]: # 
[]: # ## Conclusion
[]: # The Stream API provides a powerful and flexible way to process collections of data in Java. By understanding the various methods available, you can write more concise and expressive code that is easier to read and maintain. The combination of intermediate and terminal operations allows for complex data processing tasks to be performed in a clear and efficient manner.
[]: # Whether you are filtering, mapping, or reducing data, the Stream API offers a wide range of methods to suit your needs. Embracing the functional programming paradigm with streams can lead to more elegant and efficient Java code.  
[]: # 
[]: # For more information, refer to the official Java documentation on the Stream API.

// real project use case
class Employee {
    String name;
    int age;
    String department;

    Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", department='" + department + "'}";
    }
}

class StreamApiUseCase {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, "HR"),
                new Employee("Bob", 25, "IT"),
                new Employee("Charlie", 35, "Finance"),
                new Employee("David", 28, "IT"),
                new Employee("Eve", 40, "HR")
        );

        // Example: Filter employees in IT department and collect their names
        List<String> itEmployees = employees.stream()
                .filter(e -> "IT".equals(e.department))
                .map(e -> e.name)
                .collect(Collectors.toList());

        System.out.println("IT Employees: " + itEmployees);

        // Example: Find the average age of employees in HR department
        double averageAgeHR = employees.stream()
                .filter(e -> "HR".equals(e.department))
                .mapToInt(e -> e.age)
                .average()
                .orElse(0.0);
        System.out.println("Average Age of HR Employees: " + averageAgeHR);
        // Example: Count employees older than 30
        long countOlderThan30 = employees.stream()
                .filter(e -> e.age > 30)
                .count();
        System.out.println("Number of Employees Older Than 30: " + countOlderThan30);
        // Example: Group employees by department
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));

        explanation  
                   here employees are grouped by their department, creating a map where the key is the department name and the value is a list of employees in that department.
        System.out.println("Employees by Department: " + employeesByDepartment);
// output
        // IT Employees: [Bob, David]
        // Average Age of HR Employees: 35.0
        // Number of Employees Older Than 30: 2
        // Employees by Department: {HR=[Employee{name='Alice', age=30, department='HR'}, Employee{name='Eve', age=40, department='HR'}], IT=[Employee{name='Bob', age=25, department='IT'}, Employee{name='David', age=28, department='IT'}], Finance=[Employee{name='Charlie', age=35, department='Finance'}]}
     //example: Find the maximum age of employees in the list
        int maxAge = employees.stream()
                .mapToInt(e -> e.age)
                .max()
                .orElse(0);
        System.out.println("Maximum Age of Employees: " + maxAge);

        // Example: Check if all employees are older than 20
        boolean allOlderThan20 = employees.stream()
                .allMatch(e -> e.age > 20);
        System.out.println("All Employees Older Than 20: " + allOlderThan20);
    }
}
/explanation
// In this example, we demonstrate various operations using the Stream API on a list of `Employee` objects.
// 1. **Filtering**: We filter employees in the IT department and collect their names into a list.
// 2. **Mapping**: We map the filtered employees to their names.
