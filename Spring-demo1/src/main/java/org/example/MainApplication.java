package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
//        HelloWorld h=new HelloWorld();
//        h.printHello();


        System.out.println("=====USING SPRING====");

        ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");

//            HelloWorld obj= (HelloWorld) context.getBean("hello");
//
//            obj.printHello();


        System.out.println("========================");

        HelloWorld obj1= (HelloWorld) context.getBean("construct");
        obj1.printHello();

        System.out.println("============================");


    }
}
