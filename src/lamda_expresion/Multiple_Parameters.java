package java_8_Feature.lamdaExpression;

@FunctionalInterface
interface MultipleParametrs {
    int operation(int a, int b);
}
// By using lambda expression we can  used interface  method without creating a class or implementing it
public class Multiple_Parameters {
    public static void main(String[] args) {
        // implementing multiple parameters with implicit return type and no data type
        MultipleParametrs multiplication= (a,b)->a*b;
        System.out.println(multiplication.operation(2, 3));
        // implementing multiple parameters with implicit return type and data type
        MultipleParametrs addition = (int a, int b) -> a + b;
        System.out.println(addition.operation(2, 3));
        // explicit return type
        MultipleParametrs subtraction = (a, b) -> {
            return a - b;
        };
        System.out.println(subtraction.operation(2, 3));

        MultipleParametrs p= (a,b)->{
            return a/b;
        };
        System.out.println(p.operation(4, 3));

        // cHECK GREATER NUMBER OF THREE


// The lambda expression is missing a functional interface that matches a three-parameter operation
        Functional greater= (a,b,c)-> {
            if (a > b && a > c) {
                return a;
            } else if (b > a && b > c) {
                return b;
            } else {
                return c;
            }
        };
        System.out.println("greater.operation(2, 3, 4) = " + greater.operation(2, 3, 4)); // Output: "greater.operation(2, 3, 4));

        Functional smaller= (int a, int b, int c) -> {
            if (a < b && a < c) {
                return a;
            } else if (b < a && b < c) {
                return b;
            } else {
                return c;
            }
        };
        System.out.println("smaller.operation(2, 3, 4) = " + smaller.operation(2, 3, 4));

    }
}
@FunctionalInterface
interface  Functional{
    int operation(int a, int b, int c);

}
