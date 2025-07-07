# Step to create a lambda expression

private static void printMessage() {
    System.out.println("hello world");
}

 1. Remove the method body or modifiers
 2. Remove the method name
 3  Remove return type

 4. Add -> operator
 5. Add method body
Case 1:
example:
normal method
private static void printMessage() {
    System.out.println("hello world");
}

lambda expression
() -> System.out.println("hello world");

 Case 2: having  method argument
example:
private static void printMessage(int a ,int b) {
    System.out.println(a+b);
}

lambda expression
(a,b)-> System.out.println(a+b);

Case 3: having  method argument and return type
example:
private static int printMessage(int a ,int b) {
    return a+b;
}

lambda expression
(int a,int b)-> {return a+b;};

Notes:  we can used type inference in lambda expression. (compiler will infer the return type and date type of argument automatically.)
        we can remove curly braces if there is only one statement in method body.
        we can remove return keyword if there is only one statement in method body.

example:  (a,b)->a+b;

 if we have only one argument, we can remove  ().
 public static int returnMessageLength(String a){ {
   return a.length;
 }

 //public static int returnMessageLength(String a) -> a.length;
  (String a) -> a.length;  => a->a.length;

Benefits of lambda expression  :

1. It is more readable
2. It is more compact
3. It is more efficient

Its enable functional programming in java.
to make lamda expression more readable and more efficient, we can use method references.
jar file size is reduced.
eliminate shadow variable.

Example 4: Constructor Reference
public class Car {
    private String color;
    private int year;

    public Car(String color, int year) {
        this.color = color;
        this.year = year;
    }
}

public class CarFactory {
    public static Car createCar(String color, int year) {
        return new Car(color, year);
    }
}

//using lambda expression
Supplier<Car> supplier = () -> CarFactory.createCar("red", 2022);
Car car1 = supplier.get();
//using constructor reference
Supplier<Car> supplier2 = CarFactory::createCar;
Car car2 = supplier2.get();

Example 5: Method Reference
public class Car {
    public void printMessage(String message) {
        System.out.println(message);
    }
}

public class CarFactory {
    public static void printCarMessage(Car car, String message) {
        car.printMessage(message);
    }
}

//using lambda expression
BiConsumer<Car, String> biConsumer = (car, message) -> CarFactory.printCarMessage(car, message);
biConsumer.accept(new Car(), "Hello World!");

//using method reference
BiConsumer<Car, String> biConsumer2 = CarFactory::printCarMessage;
biConsumer2.accept(new Car(), "Hello World!");