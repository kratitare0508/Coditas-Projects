package BMS;

public class AccountNotPresentException extends Exception{

    public AccountNotPresentException() {
        System.out.println("Account is not present!");
    }
}
