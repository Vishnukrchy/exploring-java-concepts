package lamda_expresion;
/* * In this example, we create a thread using a lambda expression that prints "Hello from the thread!".
 * The lambda expression is passed to the Thread constructor, which implements the Runnable interface.
 * This is a concise way to create a thread without needing to define a separate class or method.
 */


// by extending the Thread class normally we create a thread like this: and we can override the run method to define the task that the thread will execute.
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is running: " + i);
        }
    }
}
// and then create a thread like this:
class ThreadCreationExample2 {
    public static void main(String[] args) {
        //without lamda expression
        MyThread myThread = new MyThread();
        myThread.start(); // Start the thread

        // Using a lambda expression to create a thread directly instead of creating a separate class for implementation
        Thread thread=new Thread(()->{
            for (int i = 0; i < 7; i++) {
                System.out.println("Lambda Thread is running: " + i);
            }
        });
        thread.start(); // Start the thread


    }
}
// Normally, we would create a thread by implementing the Runnable interface or extending the Thread class.
//like this:
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from the thread!");
    }
}

// and then create a thread like this:
class ThreadCreationExample {
    public static void main(String[] args) {
        //without lambda expression
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start(); // Start the thread
        // Using a lambda expression to create a thread directly instead of creating a separate class for implementation
        Thread thread = new Thread(() -> System.out.println("this is lambda thread!"));
       thread.start(); // Start the thread

        // Runnable can also be used to define a task that can be executed by a thread.
        // Runnable is a functional interface, so we can use a lambda expression to create an instance of it.
        // here is an example of using a lambda expression to create a Runnable instance: and providing the implementation of the run method directly in the lambda expression.
        Runnable runnable=()->{
            // task to be executed by the thread
            for (int i = 0; i < 5; i++) {
                System.out.println("Runnable thread is running: " + i);
            }
        };
        runnable.run(); // This will not start a new thread, it will just run the task in the current thread
    }
}



public class E1_TreadCreationByLambda {
}

