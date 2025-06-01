package File_Handling;
/*
    * @author Vishnu Kumar
    * @version 1.0
    * @since 2025-05-31
    * * What is Synchronization in Java?
    * Synchronization in Java is a mechanism that ensures that only one thread can access a resource at a time.
    * It is used to prevent thread interference and memory consistency errors.
    * * Why is Synchronization important?
    * Synchronization is important in Java to ensure that shared resources are accessed in a thread-safe manner.
    * It helps to avoid issues
 */

//class  Counter{
//    private  int count=0;
//    public  void increment() {
//        count++;
//    }
//    public  int getCount() {
//        return count;
//    }
//    // Without synchronization, multiple threads can access this method simultaneously,
//In the above code, the `Counter` object is shared between two threads (`t1` and `t2`). Both threads increment the counter 1000 times. Ideally, the final count should be 2000. However, due to the lack of synchronization, the final count may be less than 2000 because the increment operation (`count++`) is not atomic and can be interrupted.
//
//}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends  Thread{
    Counter counter;
    public CounterThread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public  void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
public class E1_Synchronization {
    public static void main(String[] args) {
        Counter counter=new Counter();
        CounterThread thread1 = new CounterThread(counter);
        CounterThread thread2 = new CounterThread(counter);
        thread1.start();
        thread2.start();
        try {
            //  .join() method is used to wait for a thread to finish its execution. if the main thread calls join() on another thread, it will block until that thread completes.
            // This ensures that the main thread waits for both threads to finish before printing the final count.
            thread1.join(); // Wait for thread1 to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join(); // Wait for thread2 to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final count: " + counter.getCount());
    }
}
// Output: Final count: very high number (2000) but not always its  may be less 2000 due to thread interference and memory consistency errors
// Explanation: In this example, two threads are incrementing the same counter without synchronization.
// This can lead to thread interference, where both threads read the same value of count and increment it, resulting in a final count that is less than 2000.
// To fix this, we can use synchronization to ensure that only one thread can access the increment method at a time.
// To make the increment method thread-safe, we can use the synchronized keyword:


    /*
    * Example 2: Synchronization with real-life example
    * In this example, we have a BankAccount class with a balance and a withdraw method.
    * We will create two threads that will withdraw money from the same account at the same time.
    * Without synchronization, the balance will be incorrect.
    * We will use a synchronized block to ensure that only one thread can access the withdraw method at a time.
    */
//    class BankAccount {
//        private double balance;
//
//        public BankAccount(double balance) {
//            this.balance = balance;
//        }
//
//        public double getBalance() {
//            return balance;
//        }
//
//        public synchronized void withdraw(double amount) {
//            balance -= amount;
//        }
//    }
//
//    class WithdrawThread extends Thread {
//        BankAccount account;
//        double amount;
//
//        public WithdrawThread(BankAccount account, double amount) {
//            this.account = account;
//            this.amount = amount;
//        }
//
//        @Override
//        public void run() {
//            account.withdraw(amount);
//        }
//    }
//
//    public static void main(String[] args) {
//        BankAccount account = new BankAccount(1000);
//        WithdrawThread thread1 = new WithdrawThread(account, 500);
//        WithdrawThread thread2 = new WithdrawThread(account, 500);
//        thread1.start();
//        thread2.start();
//        try {
//            thread1.join(); // Wait for thread1 to finish
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            thread2.join(); // Wait for thread2 to finish
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Final balance: " + account.getBalance());
//    }


