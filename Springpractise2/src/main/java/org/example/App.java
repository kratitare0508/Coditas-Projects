package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //pulling obj from spring.xml


        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

        Student student1= (Student) context.getBean("student1");
        System.out.println(student1);






    }
}
