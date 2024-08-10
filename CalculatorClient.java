
import java.rmi.Naming;


public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
            System.out.println("Is stack empty? " + calculator.isEmpty());
        } catch (Exception e) {

            System.err.println("Calculator Client failed: " + e);
        }
    }
}