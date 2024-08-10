
import java.rmi.registry.LocateRegistry;


public class CalculatorServer {
    public static void main(String[] args) {
        try {
            //local host
            LocateRegistry.createRegistry(1099);
            Calculator calculator = new CalculatorImplementation();
            Naming.rebind("rmi://localhost/CalculatorService", calculator);
            System.err.println("Calculator server ready");
            
        } catch (Exception e) {
            System.err.println("Calculator server failed with error: "+e);
        }
    }
}