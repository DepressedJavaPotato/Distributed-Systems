import java.rmi.Naming;


public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            calculator.pushValue(10);
            calculator.pushValue(20);
            calculator.pushOperation("min");
            System.out.println("Min: " + calculator.pop());


            calculator.pushValue(4);
            calculator.pushValue(6);
            calculator.pushOperation("lcm");
            System.out.println("LCM: " + calculator.pop());

            calculator.pushValue(10);
            calculator.pushValue(20);
            calculator.pushOperation("max");
            System.out.println("Max: " + calculator.pop());

            calculator.pushValue(5);
            calculator.pushValue(15);
            calculator.pushOperation("gcd");
            System.out.println("GCD: " + calculator.pop());

            System.out.println("Is stack empty? " + calculator.isEmpty());
        } catch (Exception e) {

            System.err.println("Calculator Client failed: " + e);
        }
    }
}