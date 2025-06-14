package lamda_expresion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class E2_ComparatorInterfaceWithLambda {
    public static void main(String[] args) {
        /*
        List<Student> students = List.of(
                new Student("Alice", 20),
                new Student("Bob", 22),
                new Student("Charlie", 19)
        );
        // list.of() creates an immutable list, so we cannot sort it directly.
         */
      List<Student> students=new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 19));

        System.out.println("Before sorting: " + students);

        // Sort by age in ascending order using lambda expression
      //  students.sort((s1, s2) -> Integer.compare(s1.age, s2.age));
        // or we can use Collections.sort() method with lambda expression
        Collections.sort(students,(Student s1,Student s2)-> s1.age - s2.age);
        System.out.println("After sorting by age in ascending order: " + students);

        // Sort by name in descending order using lambda expression
        students.sort((s1, s2) -> s2.name.compareTo(s1.name));
        // or we can use Collections.sort() method
        Collections.sort(students,(s1,s2)-> s2.name.compareTo(s1.name));
         // or we can use Comparator.comparing() method
         Collections.sort(students, Comparator.comparing(Student::getName).reversed());
        System.out.println("After sorting by name in descending order: " + students);
    }

}
class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
// Override toString() method for better output representation
    // This method is used to print the object in a readable format
    // It returns a string representation of the object, which includes the name and age of the student.
    // if we don't override this method, the default implementation will be used, which may not provide meaningful information about the object.

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }
}
