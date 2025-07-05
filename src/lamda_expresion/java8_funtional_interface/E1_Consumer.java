package lamda_expresion.java8_funtional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
Consumer is a functional interface that represents an operation that takes a single argument and returns no result.
It is often used for performing actions on objects, such as printing or modifying them.
its has a single abstract method accept(T t) that takes an argument of type T and returns no result.
 its has methods like:
    * andThen(Consumer<? super T> after) - Returns a composed Consumer that performs this operation followed by the after operation.

 */
public class E1_Consumer {
    public static void main(String[] args) {
        Consumer<String> printConsumer =new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Consumer is printing: " + s);
            }
        };
        printConsumer.accept("Hello World"); // Consumer is printing: Hello World`
        // Using lambda expression to create a Consumer
        Consumer<String> printConsumerLambda = s -> System.out.println("Consumer is printing: " + s);
        printConsumerLambda.accept("Hello Vishnu"); // Consumer is printing: Hello Vishnu
        // Using method reference to create a Consumer
        Consumer<String> printConsumerMethodRef = System.out::println;
        printConsumerMethodRef.accept("Hello Method Reference"); // Hello Method Reference

        // ex 1 increase the salary by 10%
        Consumer<Double> increaseslaryBy10Percent=salary->{
            double newSalary = salary + (salary * 0.10);
            System.out.println("New Salary after 10% increase: " + newSalary);
        };
        increaseslaryBy10Percent.accept(50000.00); // New Salary after 10% increase: 55000.0

        //ex 2 print the name in uppercase
        Consumer<String> printNameInUpperCase = name -> {
            String upperCaseName = name.toUpperCase();
            System.out.println("Name in uppercase: " + upperCaseName);
        };
        printNameInUpperCase.accept("vishnu"); // Name in uppercase: VISHNU

        // ex 3 increase the 100 in a list of integers
        Consumer<List<Integer>> increaseBy100=number->{
            for (Integer num :number){
                int newNumber = num + 100;
                System.out.println("New Number after adding 100: " + newNumber);
            }
        };
        increaseBy100.accept(List.of(1, 2, 3, 4, 5)); // New Number after adding 100: 101, 102, 103, 104, 105

        Consumer<List<Integer>> descreaseBy100=number->{
            for (Integer num :number){
                int newNumber = num - 100;
                System.out.println("New Number after subtracting 100: " + newNumber);
            }
        };
        descreaseBy100.accept(List.of(101, 102, 103, 104, 105)); // New Number after subtracting 100: 1, 2, 3, 4, 5

        // Using andThen to compose Consumers
        increaseBy100.andThen(descreaseBy100).accept(Arrays.asList(100, 200, 300, 400, 500));
    }
}
