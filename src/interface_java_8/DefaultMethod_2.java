package interface_java_8;
/*
⚔️ What if Two Interfaces Have Same Default Method?
If two interfaces have the same default method, they can be combined into a single interface.
  // must override because of ambiguity because of same method name created the ambiguity form implementation class which interface  method inherited in implementation class
   then we can override the default method and we can call the specific method by using interface name.super.methodName();

 */
public interface DefaultMethod_2 {
    default void sayHello(){
        System.out.println("Hello from DefaultMethod_A");
    }
}
interface DefaultMethod_B {
    default void sayHello(){
        System.out.println("Hello from DefaultMethod_B");
    }
}
class  C implements DefaultMethod_2,DefaultMethod_B{
   //here C is implementation    of DefaultMethod_2 and DefaultMethod_B  amd its inherited the default method from DefaultMethod_2 and DefaultMethod_B and its created the ambiguity
    //  // must override because of ambiguity

    @Override
    public void sayHello() {
        System.out.println("Hello from C");
        DefaultMethod_B.super.sayHello();// we can still call specific one
        DefaultMethod_2.super.sayHello();
    }

    public static void main(String[] args) {
        C c=new C();
        c.sayHello();
//        Hello from C
//        Hello from DefaultMethod_B
//        Hello from DefaultMethod_A
    }

}
/*
🧠 Summary Table
Feature	Before Java 8	After Java 8
Abstract methods	✅ Yes	✅ Yes
Concrete methods	❌ No	✅ Via default
Static methods in interface	❌ No	✅ Yes
Lambda expressions	❌ No	✅ Yes



 */
