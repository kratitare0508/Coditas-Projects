package CafeAllocationSystem;

public class NoreservationfoundException extends Exception {
    NoreservationfoundException(){
            System.out.println("Default");

        }
    NoreservationfoundException(String s){
            System.out.println("Reservation of a seat is "+s);
        }

    }
