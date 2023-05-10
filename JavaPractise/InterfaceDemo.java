package JavaPractise;

import java.util.Scanner;
import java.util.*;
interface Shape{
   void area();
}
class Rectangle implements Shape{
    public void area() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        int area = length * breadth;
        System.out.println("Area is::" + area);
    }

}
public class InterfaceDemo {
    public static void main(String[] args) {
        Rectangle r=new Rectangle();
        r.area();
    }
}
