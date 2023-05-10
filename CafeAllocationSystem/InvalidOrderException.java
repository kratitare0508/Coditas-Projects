package CafeAllocationSystem;

public class InvalidOrderException extends Throwable {
    public InvalidOrderException() {
        System.out.println("Order is invalid atlest 1 coffee should be there");
    }
}
