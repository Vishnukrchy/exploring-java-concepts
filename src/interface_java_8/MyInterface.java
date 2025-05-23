package interface_java_8;
/*
🧠 Important Points:

Can have default and static methods (multiple)

Can inherit other interfaces (but still must have only one abstract method in total)

@FunctionalInterface annotation is optional, but it helps catch errors during compile time.

🔥 Why use @FunctionalInterface?
This annotation does 2 major things:

Makes your intent clear – you’re building a functional interface

Compiler throws an error if you add more than one abstract method
 */
@FunctionalInterface
public interface MyInterface {
    void sayHello();  // if  this interface contains only one abstract method then its a functional interface
    //void sayBye(); compiler throw error if you add more than one abstract method if @FunctionalInterface annotation is added

}

@FunctionalInterface
interface ParentInterface{
    void sayHello();

    //we can write default and static methods
    default void sayBye(){
        System.out.println("Bye");
    }
    static void sayHi(){
        System.out.println("Hi");
    }
}
