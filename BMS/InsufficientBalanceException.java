package BMS;

public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException() {
        System.out.println("Your balance is not sufficient");
    }
}
