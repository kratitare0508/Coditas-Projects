package SIMCompany;

public class RechargeAmountTooLowException extends Exception{
    public RechargeAmountTooLowException() {
        System.out.println("The amount you have entred is very very low");
    }
}
