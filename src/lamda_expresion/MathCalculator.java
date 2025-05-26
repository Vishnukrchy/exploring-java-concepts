package lamda_expresion;


interface MathOperation {
    int operation(int a, int b);


}


public class MathCalculator {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        System.out.println("Sum: " + add.operation(10, 5));
        MathOperation subtract = (a, b) -> a - b;
        System.out.println("Difference: " + subtract.operation(10, 5));
        MathOperation multiply = (a, b) -> a * b;
        System.out.println("Product: " + multiply.operation(10, 5));
        MathOperation divide = (a, b) -> a / b;
        System.out.println("Quotient: " + divide.operation(10, 5));

    }
}
