package interface_java_8;



/***
 * @author Vishnu Kumar
 * @version 1.0
 * @since 2025-05-23
 *
 *  Default Method in Interface (Java 8+ Feature)
 *  Before Java 8:
 * Interface = only abstract methods
 * No method body allowed!
 * Couldn’t add new methods to existing interfaces without breaking all implementing classes.
 * After Java 8: Default Methods to the Rescue
 * You can now write concrete method implementations inside interfaces using the default keyword.
 */
public interface InterfaceDefaultMethod {
    void syaHello();

    default  void sayDefaultHello(){
        System.out.println("Default Hello from interface!");
    }

}
// default method is provided the default implementation for the method. in interface , in implementation class  its inherited we can override the default method. and provide our own implementation.
class MyClass implements InterfaceDefaultMethod{
    public void syaHello(){
        System.out.println("Hello from MyClass");
    }
}
class  Main {
    public static void main(String[] args) {
        MyClass myClass =new MyClass();
        //concrete method of interface implemented in myclass
        myClass.syaHello();//Hello from MyClass
        //default method of interface inherited in myclass
        myClass.sayDefaultHello();//Default Hello from interface
    }
}
/*
💡 Why Default Methods?
Backward compatibility — You can add new methods to interfaces without breaking existing code.
Multiple behavior sharing — Like a mixin/trait-lite.
Java 8 Streams API uses this a lot (forEach, stream(), etc.)
 */
