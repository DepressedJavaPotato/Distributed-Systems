import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack;

    protected CalculatorImplementation() throws RemoteException {
        super();
        stack = new Stack<>();
    }

    @Override
    public synchronized void pushValue(int val) throws RemoteException {
        stack.push(val);
    }

    @Override
    public synchronized void pushOperation(String operator) throws RemoteException {
        if (stack.isEmpty()) return;

        int result;
        switch (operator) {
            case "min":
                result = stack.stream().min(Integer::compare).orElse(0);
                break;
            case "max":
                result = stack.stream().max(Integer::compare).orElse(0);
                break;
            case "lcm":
                result = stack.stream().reduce(1, (a, b) -> lcm(a, b));
                break;
            case "gcd":
                result = stack.stream().reduce(stack.peek(), (a, b) -> gcd(a, b));
                break;
            default:
                throw new RemoteException("Unknown operation: " + operator);
        }
        stack.clear();
        stack.push(result);
    }

    @Override
    public synchronized int pop() throws RemoteException {
        return stack.pop();
    }

    @Override
    public synchronized boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    @Override
    public synchronized int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return pop();
    }

    // Helper methods for lcm and gcd
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
