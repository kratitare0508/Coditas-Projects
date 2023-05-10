package CafeAllocationSystem;
import java.awt.*;
import java.util.*;
public class PlaceOrder {
    int[] serialno = {1, 2, 3, 4};
    String[] name = {"Pizza", "Coke", "Burger", "Cofee"};
    int[] price = {350, 50, 100, 120};
    String[] n = new String[4];
    PrintMenu m = new PrintMenu();

    public void orderfood() {
        boolean ordering = true;
        int menuoption;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter table number");
        int tablenumber = sc.nextInt();
        int total = 0;
        int pizza = 0;
        int coke = 0;
        int burger = 0;
        int coffee = 0;
        boolean flag = true;
        do {
            System.out.println("=====MENU=====");
            m.showMenu();

            System.out.println("Order for table number:" + tablenumber);
            System.out.println("Enter the serailnumber from menu");
            int menunumber = sc.nextInt();
            switch (menunumber) {
                case 1:
                    System.out.println("Enter the quantity::");
                    int qty = sc.nextInt();
                    pizza = qty * price[0];
                    String item1 = "Name::" + name[0] + "Quantity::" + qty + "Price::" + price[0];
                    n[0] = item1;
                    break;
                case 2:
                    System.out.println("Enter the quantity");
                    int qtys = sc.nextInt();
                    // System.out.println("Name :: " + name[1] + " Quantity :: " + qtys + " Price is " + qtys * price[1]);
                    coke = qtys * price[1];
                    String item2 = "Name :: " + name[1] + " Quantity :: " + qtys + " Price is " + qtys * price[1];
                    n[1] = item2;
                    break;

                case 3:
                    System.out.println("Enter the quantity");
                    int qtya = sc.nextInt();
                    //System.out.println("Name :: " + name[2] + " Quantity :: " + qtya + " Price is " + qtya * price[2]);
                    burger = qtya * price[2];
                    String item3 = "Name :: " + name[2] + " Quantity :: " + qtya + " Price is " + qtya * price[2];
                    n[2] = item3;
                    break;

                case 4:
                    System.out.println("Enter the quantity");
                    int qtyn = sc.nextInt();
                    // System.out.println("Name :: " + name[3] + " Quantity :: " + qtyn + " Price is " + qtyn * price[3]);
                    coffee = qtyn * price[3];
                    // flag = false;
                    flag = true;
                    String item4 = "Name :: " + name[3] + " Quantity :: " + qtyn + " Price is " + qtyn * price[3];
                    n[3] = item4;
                    break;

                case 5:
                    ordering = false;
                    System.out.println("Thanks");
                    break;

                default:
                    System.out.println("Invalid choice please select from the menu only");

            }

        } while (ordering);
        if (!flag) {
            try {
                throw new InvalidOrderException();
            } catch (InvalidOrderException e) {
                e.getMessage();
            }

        } else {
            System.out.println("************************** Your Orders are ****************************");
            for (int i = 0; i < n.length; i++) {
                if (n[i] != null) {
                    System.out.println(n[i]);
                }
            }
            total = pizza + coke + coffee + burger;
            System.out.println("****** Bill Amount ******");
            System.out.println("Your total bill amount is " + total);
        }

    }
}
