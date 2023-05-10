package JavaPractise;
class Employee{
    int empid;
    String name;
   static String company="Google";

    public Employee(int empid, String name) {
        this.empid = empid;
        this.name = name;
    }

    /*public Employee(int empid, String name, String company) {
        this.empid = empid;
        this.name = name;
        this.company = company;
    }*/
    void display()
    {
        System.out.println(empid+" "+name+" "+company);
    }
}
public class StaticDemo {
    public static void main(String[] args) {
       // Employee e=new Employee(101,"Krati,"Google");
       // Employee e1=new Employee(101,"Krati","Google");
        //e1.display();
Employee e2=new Employee(101,"Rutu");
        e2.display();
    }
}
