package collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");

        Employee emp1= (Employee) context.getBean("emp1");

        System.out.println(emp1.getName());

        System.out.println(emp1.getAddress());

        System.out.println(emp1.getCourses());


        System.out.println(emp1);

    }

}
