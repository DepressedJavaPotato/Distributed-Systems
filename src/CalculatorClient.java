
import java.rmi.Naming;


public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            calculator.pushValue(10);
            calculator.pushValue(20);
            calculator.pushOperation("min");
            System.out.println("Min: " + calculator.pop());
            
            calculator.pushValue(5);
            calculator.pushValue(15);
            calculator.pushOperation("gcd");
            System.out.println("GCD: " + calculator.pop()); // Should print 5


            System.out.println("Is stack empty? " + calculator.isEmpty());
        } catch (Exception e) {

            System.err.println("Calculator Client failed: " + e);
        }
    }
}