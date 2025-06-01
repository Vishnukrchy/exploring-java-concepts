package File_Handling;
/*
    * @author Vishnu Kumar
    * @version 1.0
    *
    *
    *

    /*
    * Example 2: Synchronization with real-life example
    * In this example, we have a BankAccount class with a balance and a withdraw method.
    * We will create two threads that will withdraw money from the same account at the same time.
    * Without synchronization, the balance will be incorrect.
    * We will use a synchronized block to ensure that only one thread can access the withdraw method at a time.

 */


class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
   // withdraw method is synchronized to ensure that only one thread can access it at a time and here
    // synchronized keyword is used to lock the method so that only one thread  and in this case only one thread can withdraw money at a time
    public synchronized void withdraw(double amount) {
        // Simulating some processing time
        try {
            Thread.sleep(100); // Sleep for 100 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of: " + amount);
        }
    }
    // without synchronized method if two threads try to withdraw money at the same time then it will lead to inconsistent state of balance
    //  here in this case if two threads try to withdraw money at the same time then it will lead to inconsistent state of balance
    // example: if balance is 1000 and two threads try to withdraw 500 at the same time then both threads will withdraw 500 and balance will be 0
    // and both threads will print the same message "Withdrawn: 500, Remaining Balance: 0" which is incorrect
    // Why incorrect? because both threads are accessing the same method at the same time and both threads are updating the balance at the same time
    // but in ideal case if a pesron has 1000 in his account and he tries to withdraw 500 then only one thread should be able to withdraw 500 and balance should be 500

    public  void withdrawWithoutSync(double amount) {
        // Simulating some processing time
        try {
            Thread.sleep(100); // Sleep for 100 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of: " + amount);
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    private double amount;

    public WithdrawThread(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        // Using  withdraw method which is not synchronized to demonstrate the issue
        account.withdrawWithoutSync(amount);
        // Using synchronized withdraw method to avoid the issue
        // account.withdraw(amount);

        // Uncomment the line below to see the issue without synchronization
        // account.withdrawWithoutSync(amount);
    }
}
// In this example, we have a BankAccount class with a balance and a withdraw method.
public class E2_Synchronization {
    public static void main(String[] args) {
        // Run example without synchronization to see the issue
        runExampleWithoutSyn();

        // run the example with synchronization
     //    runExampleWithSyn();

    }
    public  static void runExampleWithoutSyn() {
        BankAccount account = new BankAccount(1000);
        WithdrawThread thread1 = new WithdrawThread(account, 500);
        WithdrawThread thread2 = new WithdrawThread(account, 500);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
        /*
        Expected Output:
           here both threads will withdraw 500 and balance will be 0
              Withdrawn: 500.0, Remaining Balance: 500.0
                Withdrawn: 500.0, Remaining Balance: 0.0
        Inconsistent state of balance because both threads are accessing the same method at the same time of shared resource
        and both threads are updating the balance at the same time
        Final balance: 0.0  this is incorrect because both threads are withdrawing money at the same time

         */
    }


     public static void runExampleWithSyn() {
             BankAccount account = new BankAccount(1000);
             Thread thread1 = new Thread(() -> account.withdraw(500));
             System.out.println("Thread 1 started");
             Thread thread2 = new Thread(() -> account.withdraw(500));
                System.out.println("Thread 2 started");

             thread1.start();
             thread2.start();

             try {
                 thread1.join();
                 thread2.join();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

             System.out.println("Final balance: " + account.getBalance());
         }

    //    public static void runExampleWithSyn() {
//        WithdrawThread thread1 = new WithdrawThread(account, 500);
//        WithdrawThread thread2 = new WithdrawThread(account, 500);
//
//        thread1.start();
//        thread2.start();
//
//        try {
//            thread1.join(); // Wait for thread1 to finish
//            thread2.join(); // Wait for thread2 to finish
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Final balance: " + account.getBalance());
//    }
}
