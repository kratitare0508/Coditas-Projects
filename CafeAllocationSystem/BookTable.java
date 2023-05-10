package CafeAllocationSystem;
import java.util.*;
public class BookTable {
    static int tableoftwo = 8, tableoffour = 4, tableofsix = 2, tableofeight = 2;

    public boolean bookTable() {
        boolean isAvailable = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter number of seats you want");
        int seats = sc.nextInt();
        if (seats <= 2) {
            if (tableoftwo != 0) {
                isAvailable = true;
                tableoftwo--;
                System.out.println("Your seat is booked in table of 2");
            }
        }
        if (seats <= 4 && !isAvailable) {
            if (tableoffour != 0) {
                isAvailable = true;
                tableoffour--;
                System.out.println("Your seat is booked in table of 4");
            }
        }
        if (seats <= 6 && !isAvailable) {
            if (tableofsix != 0) {
                tableofsix--;
                isAvailable = true;
                System.out.println("Hello " + name + " Your Seats are booked in table of six");

            }
        }
        if (seats <= 8 && !isAvailable) {
            if (tableofeight != 0) {
                tableofeight--;
                isAvailable = true;
                System.out.println("Hello " + name + " Your Seats are booked in table of eight");

            }
        }
        if (!isAvailable) {
            System.out.println("Sorry table are not available");
            ;
            return false;
        }
        return true;

    }

}

