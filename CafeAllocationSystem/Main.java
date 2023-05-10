package CafeAllocationSystem;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        boolean isPossible = false;
        while (true) {
            System.out.println(" 0 for exit||1 to book table|| 2 to print menu|| 3 to order coffee");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your choice");
            int ch=sc.nextInt();
            switch(ch) {
                case 0:
                    flag = false;
                    System.exit(0);
                    break;
                case 1:
                    //Book table
                    BookTable b = new BookTable();
                    isPossible = b.bookTable();
                    break;
                case 2:
                    //print menu
                    if(!isPossible) {
                        System.out.println("You are not allowed to order because you need to book seat first!!");
                    } else{
                        PrintMenu m = new PrintMenu();
                       m.showMenu();
                    }
                    break;
                case 3:
                    if(!isPossible){
                    //order coffee
                    System.out.println("You are not allowed to order because you need to book seat first!!");
            }
                    else {

                PlaceOrder p = new PlaceOrder();
                p.orderfood();

            }
            break;


                default:
                    System.out.println("No such option is present:");
                    break;
            }
        }
    }
}
