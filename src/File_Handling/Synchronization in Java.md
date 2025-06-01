# Synchronization in Java
  => Synchronization in Java is a mechanism that ensures that only one thread can access a resource at a time,
  => preventing data inconsistency and ensuring thread safety in multithreaded environment. 
  => It is crucial in multi-threaded applications where multiple threads may try to read or write shared resources simultaneously.
  => Java provides built-in support for synchronization through the `synchronized` keyword, which can be applied to methods or blocks of code.
# Why Synchronization is Important?
    => In a multi-threaded environment, multiple threads can access shared resources concurrently.
    => If two or more threads modify the same resource at the same time, it can lead to data inconsistency and unpredictable behavior.
    => Synchronization helps to control access to shared resources, ensuring that only one thread can modify the resource at a time.
    => This prevents 
# Types of Synchronization
1. **Method Synchronization**: 
   - When a method is declared with the `synchronized` keyword, it ensures that only one thread can execute that method at a time for a given object.
   - Example:
     ```java
     public synchronized void synchronizedMethod() {
         // code to be synchronized
     }
     ```
2. **Block Synchronization**:
   - Instead of synchronizing an entire method, you can synchronize a specific block of code within a method.
   - This is more flexible and can lead to better performance.
   - Example:
     ```java
     public void someMethod() {
         synchronized(this) {
             // code to be synchronized
         }
     }
     ```
3. **Static Method Synchronization**:
   - When a static method is declared as synchronized, it locks the class object rather than the instance of the class.
   - This means that only one thread can execute that static method at a time across all instances of the class.
   - Example:
     ```java
     public static synchronized void synchronizedStaticMethod() {
         // code to be synchronized
     }
     ```
# Example of Synchronization
```java
class Counter {
    private int count = 0;

    // Synchronized method to increment the count
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

to demonstrate synchronization
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Creating multiple threads that will increment the counter
        Thread thread1 = new CounterThread(counter);
        Thread thread2 = new CounterThread(counter);

        // Starting the threads
        thread1.start();
        thread2.start();

        // Waiting for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Displaying the final count
        System.out.println("Final count: " + counter.getCount());
    }   
}
```
# Output
```
Final count: 2000
```
    => In this example, the `Counter` class has a synchronized method `increment()` that ensures that only one thread can increment the count at a time.
    => The `CounterThread` class extends `Thread` and increments the counter 1000 times.
    => The main method creates two threads, starts them, and waits for them to finish using `join()`.
    => Finally, it prints the final count, which should be 2000 if synchronization is working correctly.
# Conclusion
    => Synchronization is a crucial aspect of Java programming in a multi-threaded environment.
    => It helps to prevent data inconsistency and ensures thread safety by allowing only one thread to access a shared resource at a time.
    => By using the `synchronized` keyword, developers can control access to methods or blocks of code, ensuring that critical sections are executed by only one thread at a time.
    => Proper synchronization is essential for building robust and reliable multi-threaded applications in Java.