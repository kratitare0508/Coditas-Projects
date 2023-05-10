package BMS;
import java.io.IOException;
import java.util.*;
public class BMS {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Operations operations=new Operations();
        boolean flag=true;
        while(true)
        {
            System.out.println("EXIT");
            System.out.println("ADD BANK ACCOUNT");
            System.out.println("DEPOSIT AMOUNT");
            System.out.println("WITHDRAW AMOUNT");
            System.out.println("DISPLAY ACCOUNT DETAILS");
            System.out.println("Enter your choice");
           int ch=sc.nextInt();
           switch(ch)
           {
               case 0:
                   flag=false;
                   break;
               case 1:
                   operations.addAccount();
                   break;
               case 2:
                   operations.Deposit();
                   break;
               case 3:
                   operations.withdraw();
                   break;
               case 4:
                   operations.Display();
                   break;
               default:
                   System.out.println("Invalid choice");
                   break;
           }
        }
    }
}
