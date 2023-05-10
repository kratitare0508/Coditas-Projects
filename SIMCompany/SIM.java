package SIMCompany;

//import jdbc_practise.StudentManagementSystem.Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class SIM {
    public static void main(String[] args) throws IOException, SQLException, UserDoesNotExistException, ClassNotFoundException, RechargeAmountTooLowException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        Operations operations=new Operations();
        while (true) {
            System.out.println("WELCOME TO AIRTEL CALLCENTRE");
            System.out.println("0 FOR EXIT");
            System.out.println("1 FOR PREPAID USER");
            System.out.println("2.FOR NEW CONNCETION");
            System.out.println("3 TO DISPLAY ALL USERS");
            System.out.println("Enter your choice::");
            int ch = Integer.parseInt(sc.readLine());
            switch (ch) {
                case 0:
                    flag = false;
                    System.out.println("Now you are out of t2he program");
                    break;
                case 1:
                 operations.prepaid();
                    break;
                case 2:
                    operations.newConnection();
                    break;
                case 3:
                    operations.display();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }


        }
    }
}