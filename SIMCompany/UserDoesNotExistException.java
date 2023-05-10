package SIMCompany;

public class UserDoesNotExistException extends Exception{

    public UserDoesNotExistException() {
        System.out.println("User doesnt exist:Mobile no is not registered");
    }
}
