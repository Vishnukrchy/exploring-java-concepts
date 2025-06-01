
How to create a thread using lambda expression?
 we can use lambda expression to create a thread.
 Runable is an fucntional interface which has only one abstract method run.  by using runable interface we can create a thread. its has one abstract method run.

Example:
// normal way to create a thread by implementing runable interface and override run method
Class MyThread implements Runnable {
    public void run() {
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Value of i: " + i);
            try {
                //Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} 
// main class
class Main{
main(String[] args) {
    
MyThread myThread = new MyThread();
Thread childThread = new Thread(myThread);
childThread.run();

System.out.println("Main thread is running...");
}
}


 
// normal way to create a thread
Thread t = new Thread(new MyThread());
t.start();
// create a thread using lambda expression
Thread t1 = new Thread(() -> {
    for (int i = 0; i < 10; i++) {
        System.out.println("Value of i: " + i);
        try {
            Thread.sleep(1000); // sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
t1.start();