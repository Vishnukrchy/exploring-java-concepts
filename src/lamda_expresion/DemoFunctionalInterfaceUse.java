package lamda_expresion;
/*
Use of Functional Interface with Lambda Expression

Problem with old way
Had to write boilerplate classes
Verbose anonymous classes
Hard to pass behavior around

Solution
Use functional interface
 */
@FunctionalInterface
interface Printer {
    void print();
}
// older way   to implement interface in implementation class
class Demo implements Printer {
//    public static void main(String[] args) {
//        Printer printer = new Printer() {
//            @Override
//            public void print() {
//                System.out.println("Hey Vishnu, Java 8 is lit! 🔥");
//            }
//        };
//        printer.print();
//    }

    @Override
    public void print() {
        System.out.println(" Java 8 is lit! ");
    }
}
public class DemoFunctionalInterfaceUse {
    public static void main(String[] args) {
        // before
        Demo demo = new Demo();
        demo.print();// Java 8 is lit!
        // after  using functional interface with lambda don't need to create class  for implementation
        Printer printer = () -> System.out.println("Java 8 with Lambda is lit! ");// only one abstract method so no need to create class
        printer.print();

        GreetDemo g= (name)->System.out.println("Hello "+name);
        g.greet("Vishnu");

        GreetDemo g1= name-> System.out.println(name.length()+" "+name);
        g1.greet("Vishnu");



    }
}

interface  GreetDemo{
    void greet(String name);
}
