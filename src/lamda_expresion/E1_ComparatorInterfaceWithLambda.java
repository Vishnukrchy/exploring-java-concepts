package lamda_expresion;
/*
    * Example of using Comparator interface with lambda expressions
    * This example demonstrates how to use the Comparator interface to sort a list of integers in descending order using a lambda expression.
    * The lambda expression provides a concise way to define the comparison logic without needing to create a separate class.
    * In this example, we first sort the list in ascending order using the default behavior of Collections.sort(),
    * then we sort it in descending order using a custom comparator implemented with a lambda expression.
    * This approach allows for more readable and maintainable code by reducing boilerplate code.
    * The Comparator interface is a functional interface, which means it can be implemented using a lambda expression.
    * This example also shows how to use the Comparator interface without lambda expressions by creating a separate class that implements the Comparator interface.
    */

import java.util.*;

public class E1_ComparatorInterfaceWithLambda {
    public static void main(String[] args) {
//        List<Integer> numbers = List.of(5, 2, 8, 1, 4); // List.of() creates an immutable list, so we cannot sort it directly.
        List<Integer> numbers=new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(4);
        System.out.println("Before sorting: " + numbers);
        // sort list assending order
        Collections.sort(numbers);// Collections.sort() sorts the list in ascending order by default
        System.out.println(" sorting: " + numbers);
        // wait what if we want to sort in descending order? generally we use Comparator interface to sort in descending order
        // and we have to create a class that implements Comparator interface and override the compare method
        //like this:
         Collections.sort(numbers, new IntegerComparator());
        System.out.println("After sorting in descending order: " + numbers);

        // but with lambda expression we can do it in a single line without creating a separate class
        // using lambda expression to sort in descending order
       // Collections.sort(numbers, (num1, num2) -> num1 - num2);//Can be replaced with 'Comparator. comparingInt'
        Collections.sort(numbers, (num1, num2) -> num2 - num1);
        System.out.println("After sorting in descending order using lambda: " + numbers);


    }
}
//how use genneraly used Comparator interface without lambda expression
class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // Sort in descending order
    }
}

// Example of using Comparator interface with lambda expressions in set
class MySetExample {
    public static void main(String[] args) {
        Set<Integer> numbersSet = new TreeSet<>();
        numbersSet.add(5);
        numbersSet.add(2);
        numbersSet.add(8);
        numbersSet.add(2); // Duplicate element, will not be added
        numbersSet.add(1);
        System.out.println("Set of numbers Before Sort: " + numbersSet);// TreeSet automatically sorts the elements in natural order (ascending order)

        // To sort in descending order using a lambda expression, we can use a custom comparator
        // Note: TreeSet does not allow duplicate elements, so we cannot use it to sort in descending order directly.
        // Instead, we can create a new TreeSet with a custom comparator for descending order
        // Using a custom comparator with lambda expression
        // TreeSet Have a constructor that accepts a Comparator to define the order of elements
        Set<Integer> descendingSet = new TreeSet<>((num1,num2)->num2-num1); // Custom comparator for descending order
        descendingSet.addAll(numbersSet); // Add all elements from the original set
        System.out.println("Set of numbers After Sort in descending order: " + descendingSet);
    }

}
