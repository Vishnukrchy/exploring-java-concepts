package lamda_expresion;
/*
interface reference can be used the hold the lamda expression

 by  using lamda expression we can  used interface  method without creating a class or implementing it
 */

public interface  Employee{
    double getSalary();
}
public class UseOfLamda {
    public static void main(String[] args) {
        Employee employee=()->37000.00;
        System.out.println("Employee salary is "+employee.getSalary());

        Video video=()->System.out.println("playing video");
        video.play();

        CalculateTax calculateTax=(amount -> amount*0.1);
        System.out.println("Tax amount is "+calculateTax.calculateTax(10000));
    }
}
interface  CalculateTax{
    double calculateTax(double amount);
}
interface Video {
    void play();

}
