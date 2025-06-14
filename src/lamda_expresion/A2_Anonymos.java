package lamda_expresion;

import java.util.function.Consumer;

public class A2_Anonymos {
    public static void main(String[] args) {
        // Using an anonymous class to create an instance of the Runnable interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from the anonymous class!");
            }
        };

        // Starting a thread with the anonymous Runnable implementation
        Thread thread = new Thread(runnable);
        thread.start();

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Consuming: " + s);
            }
        };
        // Using the Consumer interface with an anonymous class
        consumer.accept("Hello, World!");
        // Using a lambda expression to create a Consumer instance
        Consumer<String> lambdaConsumer = s -> System.out.println("Consuming with lambda: " + s);
        // Using the lambda expression

        lambdaConsumer.accept("Hello, Lambda World!");
        // Using an anonymous class to create a Comparator
        java.util.Comparator<String> comparator = new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length(); // Compare by length
            }
        };
    }

}
class  MyList1{
    public static void main(String[] args) {
        // Using an anonymous class to create a List
        java.util.List<String> list = new java.util.ArrayList<String>() {
            // we can used the anonymous class to add elements to the list and initialize it
            {
                // This is an instance initializer block that runs when the anonymous class is created
                add("Apple");
                add("Banana");
                add("Cherry");
            }
            {
                add("Apple");
                add("Banana");
                add("Cherry");
            }
        };

        // Printing the list
        System.out.println("List: " + list);

        // Using a lambda expression to iterate over the list
        list.forEach(item -> System.out.println("Item: " + item));
    }

}

