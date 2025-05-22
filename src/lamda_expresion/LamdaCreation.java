package lamda_expresion;

/*
Step To create lamda expression
1. Reomeve the method name
2. Remove the return type

 */

public class LamdaCreation {
    // normal method
    private static void printMessage() {
        System.out.println("hello world");
    }
    // lamda expression
  public static void main(String[] args) {
      // normal method call
      printMessage();
      // lamda expression call
      Runnable r = () -> System.out.println("hello world");
      r.run();
  }
}
